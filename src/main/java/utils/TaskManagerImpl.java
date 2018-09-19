
package utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressIndicator;

public final class TaskManagerImpl implements TaskManager {

	private static final String WORKER_NAME = "PREAG-Worker-";

	private final ObservableList<Task<?>> tasks = FXCollections.observableArrayList();

	private final ObservableList<Service<?>> services = FXCollections.observableArrayList();

	private final ObservableList<ProgressIndicator> progressIndicators = FXCollections.observableArrayList();

	private final DoubleProperty progress = new SimpleDoubleProperty(this, "progress", NO_TASKS_RUNNING);

	private final ExecutorService executorService;

	private int numberOfParallelThreads = Runtime.getRuntime().availableProcessors();
	private BooleanProperty hasRunningTasks = new SimpleBooleanProperty(false);

	public TaskManagerImpl() {
		executorService = createExecutor();
		tasks.addListener((ListChangeListener.Change<? extends Task<?>> c) -> {
			setHasRunningTasks(!tasks.isEmpty());
		});
		progressIndicators.addListener((ListChangeListener.Change<? extends ProgressIndicator> c) -> {

			while (c.next()) {

				if (c.wasAdded()) {
					for (ProgressIndicator indicator : c.getAddedSubList()) {
						indicator.progressProperty().bind(progress);
					}
				}

				if (c.wasRemoved()) {
					for (ProgressIndicator indicator : c.getRemoved()) {
						indicator.progressProperty().unbind();
					}
				}

			}

		});

		EventHandler<WorkerStateEvent> taskHandler = evt -> {
			if (evt.getEventType().equals(WorkerStateEvent.WORKER_STATE_SUCCEEDED)
					|| evt.getEventType().equals(WorkerStateEvent.WORKER_STATE_CANCELLED)
					|| evt.getEventType().equals(WorkerStateEvent.WORKER_STATE_FAILED)) {
				removeTaskListener((Task<?>) evt.getSource());
				tasks.remove(evt.getSource());
			}
		};

		EventHandler<WorkerStateEvent> serviceHandler = evt -> {
			if (evt.getEventType().equals(WorkerStateEvent.WORKER_STATE_SUCCEEDED)
					|| evt.getEventType().equals(WorkerStateEvent.WORKER_STATE_CANCELLED)
					|| evt.getEventType().equals(WorkerStateEvent.WORKER_STATE_FAILED)) {

				((Service<?>) evt.getSource()).exceptionProperty()
						.removeListener((observable, oldValue, newValue) -> exceptionHandler(newValue));
				services.remove(evt.getSource());
				((Service<?>) evt.getSource()).reset();
			}
		};

		services.addListener((ListChangeListener<Service<?>>) c -> {

			updateProgress();

			while (c.next()) {
				if (c.wasAdded()) {
					for (Service<?> service : c.getAddedSubList()) {
						service.addEventHandler(WorkerStateEvent.ANY, serviceHandler);
					}
				} else if (c.wasRemoved()) {
					for (Service<?> service : c.getRemoved()) {
						service.removeEventHandler(WorkerStateEvent.ANY, serviceHandler);
					}
				}
			}

		});

		tasks.addListener((ListChangeListener<Task<?>>) c -> {
			updateProgress();
			while (c.next()) {
				if (c.wasAdded()) {
					for (Task<?> task : c.getAddedSubList()) {
						task.addEventHandler(WorkerStateEvent.ANY, taskHandler);
					}
				} else if (c.wasRemoved()) {
					for (Task<?> task : c.getRemoved()) {
						task.removeEventHandler(WorkerStateEvent.ANY, taskHandler);
					}
				}
			}
		});

	}

	private void updateProgress() {
		if (tasks.isEmpty() && services.isEmpty()) {
			setProgress(NO_TASKS_RUNNING);
		} else {
			setProgress(INTERMEDIATE);
		}
	}

	/**
	 * Adds a task to the que and runs it immediately
	 *
	 * @param task
	 *            the task to add
	 */
	@Override
	public void addTask(Task<?> task) {
		configureTask(task, true);

	}

	/**
	 * ProgressProperty to determine if a services are running.
	 *
	 * @return progress either -1.0 or 1.0;
	 */
	@Override
	public ReadOnlyDoubleProperty progressProperty() {
		return progress;
	}

	@Override
	public synchronized boolean hasTaskRunning() {
		boolean empty = tasks.isEmpty();
		return !empty;
	}

	@Override
	public void runTaskSilent(Task<?> task) {
		configureTask(task, false);
	}

	@Override
	public void addService(Service<?> service) {
		configureService(service, true);
	}

	@Override
	public void runServiceSilent(Service<?> service) {
		configureService(service, false);
	}

	/**
	 * Method configureService configures a given service an prepares it and
	 * executes it
	 *
	 * @param service
	 *            of type Service<?> the service to configure
	 * @param verbose
	 *            of type boolean lets the service run without progress binding
	 */
	private void configureService(Service<?> service, boolean verbose) {
		if (verbose) {
			services.add(service);
		}
		service.exceptionProperty().addListener((obsVal, oldVal, newVal) -> exceptionHandler(newVal));
		service.start();
	}

	/**
	 * Method configureService configures a given service an prepares it and
	 * executes it
	 *
	 * @param task
	 *            of type Task<?> the service to configure
	 * @param verbose
	 *            of type boolean lets the service run without progress binding
	 */
	private void configureTask(Task<?> task, boolean verbose) {
		if (verbose) {
			tasks.add(task);
		}
		task.exceptionProperty().addListener((obsVal, oldVal, newVal) -> exceptionHandler(newVal));
		executorService.execute(task);
	}

	@Override
	public void addProgressIndicator(ProgressIndicator progressIndicator) {
		progressIndicators.add(progressIndicator);
	}

	@Override
	public void removeProgressIndicator(ProgressIndicator progressIndicator) {
		progressIndicators.remove(progressIndicator);
	}

	private void exceptionHandler(Throwable throwable) {
		if (Thread.getDefaultUncaughtExceptionHandler() != null) {
			Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), throwable);
		}

	}

	private void removeTaskListener(Task<?> task) {
		task.exceptionProperty().removeListener((obsVal, oldVal, newVal) -> exceptionHandler(newVal));
	}

	private boolean isFXApplicationThread() {
		return Platform.isFxApplicationThread();
	}

	private ExecutorService createExecutor() {
		return Executors.newFixedThreadPool(getNumberOfParallelThreads(), new ThreadFactory() {

			/**
			 * Simple index for our Threads
			 */
			private AtomicInteger index = new AtomicInteger(1);

			@Override
			public Thread newThread(Runnable runnable) {
				final Thread thread = new Thread(runnable, WORKER_NAME + index.getAndIncrement());
				thread.setDaemon(true);
				return thread;
			}
		});

	}

	private void setProgress(double progress) {
		if (isFXApplicationThread()) {
			this.progress.set(progress);
		} else {
			Platform.runLater(() -> this.progress.set(progress));
		}
	}

	public int getNumberOfParallelThreads() {
		return numberOfParallelThreads;
	}

	public void setNumberOfParallelThreads(int numberOfParallelThreads) {
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		if (numberOfParallelThreads > availableProcessors) {
			numberOfParallelThreads = availableProcessors;
		}
		this.numberOfParallelThreads = numberOfParallelThreads;
	}

	public final BooleanProperty hasRunningTasksProperty() {
		return this.hasRunningTasks;
	}

	public final boolean isHasRunningTasks() {
		return this.hasRunningTasksProperty().get();
	}

	public final void setHasRunningTasks(final boolean hasRunningTasks) {
		this.hasRunningTasksProperty().set(hasRunningTasks);
	}

}
