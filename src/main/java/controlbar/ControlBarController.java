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
import utils.JFXHamburgerHelper;

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
	private JFXHamburgerHelper hamburgerHelper;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		hamburgerHelper = new JFXHamburgerHelper(rootNode.drawerClosedProperty(), jfxHamburger);
		setListener();
	}

	private void setListener() {
		hamburgerHelper.hamburgerStateAfterAnimationProperty().addListener((pbs, oldVal, newVal) -> rootNode
				.fireEvent(new ControlBarEvent(ControlBarEvent.ON_DRAWER_TOGGLE, !newVal)));
	}

	@FXML
	public void onRefresh(ActionEvent event) {
		rootNode.fireEvent(new ControlBarEvent(ControlBarEvent.ON_UPDATE));
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
