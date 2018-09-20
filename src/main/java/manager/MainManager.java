package manager;

import controlbar.ControlBarEvent;
import controlbar.ControlBarView;
import drawercontent.fileselector.FileSelectorEvent;
import input.PlayerEvent;
import maincontainer.MainContainerView;
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
		root.addEventHandler(FileSelectorEvent.ON_FILE_SELECTED, evt -> playerManager.handleFile(evt));
		root.addEventHandler(FileSelectorEvent.ON_NEW_HEADER, evt -> controlBarManager.setHeaderHint(evt.getHeader()));
		root.addEventHandler(PlayerEvent.ON_ADD, evt -> playerManager.addPlayer(evt));
		root.addEventHandler(ControlBarEvent.ON_DRAWER_TOGGLE, evt -> handleDrawerToggle(root.getDrawer(), evt));
	}

	private void handleDrawerToggle(JFXedDrawer drawer, ControlBarEvent evt) {
		if (evt.isDrawerOpened())
			drawer.open();
		else
			drawer.close();
	}

	private void configureMainView(MainContainerView root) {
		root.setTop(controlBarManager.getControlBarView());
		root.setCenter(playerManager.getPlayerDisplayView());
		root.setDrawerContent(drawerManager.getDrawerContentView());

	}

}
