package manager;

import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;

import controlbar.ControlBarEvent;
import controlbar.ControlBarView;
import input.PlayerEvent;
import input.PlayerInputView;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.stage.Window;
import maincontainer.MainContainerView;
import objects.Player;
import options.OptionsView;
import services.SoFifaService;

public class ControlBarManager {
	private ControlBarView controlBarView = new ControlBarView();

	public ControlBarManager() {
	}


	void handleOnAdd(ControlBarEvent evt, Region root) {
		PlayerInputView inputView = new PlayerInputView();
		int width = 180;
		inputView.setMaxWidth(width);
		inputView.setMaxHeight(110);
		JFXPopup popup = new JFXPopup(inputView);
		inputView.addEventHandler(PlayerEvent.ON_ADD, playerEvent -> {
			popup.hide();
			controlBarView.fireEvent(playerEvent);
		});
		popup.show(root, PopupVPosition.TOP, PopupHPosition.LEFT, root.getWidth() - width, 30);
	}


	public ControlBarView getControlBarView() {
		return controlBarView;
	}

	public void handleOnOptions(ControlBarEvent evt, MainContainerView root) {
		OptionsView optionsView = new OptionsView();
		int width = 100;
		optionsView.setMaxWidth(width);
		optionsView.setMaxHeight(50);
		JFXPopup popup = new JFXPopup(optionsView);
		optionsView.addEventHandler(ControlBarEvent.ON_EXPORT, playerEvent -> {
			popup.hide();
			controlBarView.fireEvent(playerEvent);
		});
		popup.show(root, PopupVPosition.TOP, PopupHPosition.LEFT, root.getWidth() - width, 30);
	}
}
