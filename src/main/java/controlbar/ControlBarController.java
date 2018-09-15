package controlbar;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;

import input.PlayerInputView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class ControlBarController implements Initializable {

	@FXML
	ControlBarView rootNode;
	@FXML
	JFXHamburger jfxHamburger;
	@FXML
	JFXButton btnRefresh;
	@FXML
	JFXButton btnAdd;
	@FXML
	JFXButton btnOptions;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initHamburger();

	}

	private void initHamburger() {
		HamburgerSlideCloseTransition burgerTask = new HamburgerSlideCloseTransition(jfxHamburger);
		burgerTask.setRate(-1);
		jfxHamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
			burgerTask.setRate(burgerTask.getRate() * -1);
			burgerTask.play();
			rootNode.fireEvent(new ControlBarEvent(ControlBarEvent.ON_DRAWER_TOGGLE));

		});

	}

	@FXML
	public void onRefresh(ActionEvent event) {
	}

	@FXML
	public void onAdd(ActionEvent event) {
		rootNode.fireEvent(new ControlBarEvent(ControlBarEvent.ON_ADD));

	}

	@FXML
	public void onOptions(ActionEvent event) {
		rootNode.fireEvent(new ControlBarEvent(ControlBarEvent.ON_OPTIONS));
	}

}
