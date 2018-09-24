package manager;

import java.util.Optional;

import controlbar.ControlBarEvent;
import controlbar.ControlBarView;
import drawercontent.fileselector.FileSelectorEvent;
import input.PlayerEvent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import maincontainer.MainContainerView;
import utils.DialogBuilder;
import utils.TaskManager;
import utils.TaskManagerImpl;
import utils.controls.JFXedDrawer;

public class MainManager {

	private PlayerManager playerManager = new PlayerManager();
	private ControlBarManager controlBarManager = new ControlBarManager();
	private DrawerManager drawerManager = new DrawerManager();
	private TaskManager taskManager = new TaskManagerImpl();

	public MainManager(MainContainerView root) {
		root.showMaskerPaneProperty().bind(taskManager.hasRunningTasksProperty());
		playerManager.setTaskManager(taskManager);
		configureMainView(root);
		addListener(root);
	}

	private void addListener(MainContainerView root) {
		root.addEventHandler(ControlBarEvent.ON_ADD, evt -> controlBarManager.handleOnAdd(evt, root));
		root.addEventHandler(ControlBarEvent.ON_OPTIONS, evt -> controlBarManager.handleOnOptions(evt, root));
		root.addEventHandler(ControlBarEvent.ON_UPDATE, evt -> playerManager.updatePlayers());
		root.addEventHandler(ControlBarEvent.ON_EXPORT, evt -> playerManager.handleExport(evt));
		root.addEventHandler(ControlBarEvent.ON_NEW_FILE, evt -> handleReset(evt, root));
		root.addEventHandler(FileSelectorEvent.ON_FILE_SELECTED, evt -> playerManager.handleFile(evt));
		root.addEventHandler(FileSelectorEvent.ON_NEW_HEADER, evt -> controlBarManager.setFileInfo(evt.getFileInfo()));
		root.addEventHandler(ControlBarEvent.ON_RESET, evt -> reset(evt));
		root.addEventHandler(PlayerEvent.ON_ADD, evt -> playerManager.addPlayer(evt));
		root.addEventHandler(ControlBarEvent.ON_DRAWER_TOGGLE, evt -> handleDrawerToggle(root.getDrawer(), evt));
	}

	private void reset(ControlBarEvent evt) {
		playerManager.reset(evt);
		controlBarManager.reset(evt);
	
	}

	private void handleReset(ControlBarEvent evt, MainContainerView root) {
		if (playerManager.isDataPresent()) {
			Dialog<ButtonType> yesNoDialog = DialogBuilder.getInstance().buildYesNoDialog("Neuen Datensatz anlegen",
					"Alle ungespeicherten Änderungen gehen verloren! Dennoch fortfahren?", root.getScene().getWindow());
			Optional<ButtonType> result = yesNoDialog.showAndWait();
			if (result.isPresent())
				if (result.get() == ButtonType.YES)
					root.fireEvent(new ControlBarEvent(ControlBarEvent.ON_RESET));
		}
	}

	private void handleDrawerToggle(JFXedDrawer drawer, ControlBarEvent evt) {
		if (evt.isDrawerOpened()) {
			drawer.open();
			playerManager.setResizeOffset(drawer.getDefaultDrawerSize());
		} else {
			drawer.close();
			playerManager.setResizeOffset(0);
		}
	}

	private void configureMainView(MainContainerView root) {
		root.setTop(controlBarManager.getControlBarView());
		root.setCenter(playerManager.getPlayerDisplayView());
		root.setDrawerContent(drawerManager.getDrawerContentView());

	}

}
