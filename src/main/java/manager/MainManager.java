package manager;

import controlbar.ControlBarView;
import maincontainer.MainContainerView;

public class MainManager {

	private PlayerManager playerManager = new PlayerManager();
	private ControlBarView controlBarView = new ControlBarView();

	public MainManager(MainContainerView root) {
		configureMainView(root);
	}

	private void configureMainView(MainContainerView root) {
		root.setTop(controlBarView);
		root.setCenter(playerManager.getPlayerDisplayView());

	}

}
