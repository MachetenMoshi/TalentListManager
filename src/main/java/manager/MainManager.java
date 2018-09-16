package manager;

import controlbar.ControlBarEvent;
import controlbar.ControlBarView;
import drawercontent.fileselector.FileSelectorEvent;
import input.PlayerEvent;
import maincontainer.MainContainerView;

public class MainManager {

	private PlayerManager playerManager = new PlayerManager();
	private ControlBarManager controlBarManager = new ControlBarManager();
	private DrawerManager drawerManager = new DrawerManager();

	public MainManager(MainContainerView root) {
		configureMainView(root);
		addListener(root);
	}

	private void addListener(MainContainerView root) {
		root.addEventHandler(ControlBarEvent.ON_ADD, evt -> controlBarManager.handleOnAdd(evt, root));
		root.addEventHandler(ControlBarEvent.ON_OPTIONS, evt -> controlBarManager.handleOnOptions(evt, root));
		root.addEventHandler(ControlBarEvent.ON_UPDATE, evt -> playerManager.updatePlayers());
		
		
		root.addEventHandler(ControlBarEvent.ON_EXPORT, evt -> playerManager.handleExport());
		root.addEventHandler(FileSelectorEvent.ON_FILE_SELECTED, evt -> playerManager.handleFile(evt));
		root.addEventHandler(PlayerEvent.NEW_PLAYER, evt -> playerManager.handleNewPlayer(evt));
		root.addEventHandler(ControlBarEvent.ON_DRAWER_TOGGLE, evt -> root.getDrawer().toggle());
	}

	private void configureMainView(MainContainerView root) {
		root.setTop(controlBarManager.getControlBarView());
		root.setCenter(playerManager.getPlayerDisplayView());
		root.setDrawerContent(drawerManager.getDrawerContentView());

	}

}
