
package utils;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public interface TaskManager {

	double INTERMEDIATE = ProgressBar.INDETERMINATE_PROGRESS;
	double NO_TASKS_RUNNING = 1.0;

	void addTask(Task<?> task);

	ReadOnlyDoubleProperty progressProperty();

	boolean hasTaskRunning(); 

	void runTaskSilent(Task<?> task);

	void addService(Service<?> service);

	void runServiceSilent(Service<?> service);

	void addProgressIndicator(ProgressIndicator progressIndicator);

	void removeProgressIndicator(ProgressIndicator progressIndicator);

	int getNumberOfParallelThreads();

	void setNumberOfParallelThreads(int numberOfParallelThreads);

	ReadOnlyBooleanProperty hasRunningTasksProperty();
}
