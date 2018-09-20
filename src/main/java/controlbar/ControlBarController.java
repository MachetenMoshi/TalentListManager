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
import utils.svg.SVG;
import utils.svg.SVGLoader;
import javafx.scene.control.Label;

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

	private static final String SVG_SIZE = "svg-button-medium";
	@FXML
	Label lblHeader;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		hamburgerHelper = new JFXHamburgerHelper(rootNode.drawerClosedProperty(), jfxHamburger);
		lblHeader.textProperty().bind(rootNode.headerTextProperty());
		setListener();
		setGlyphs();
	}

	private void setListener() {
		hamburgerHelper.hamburgerStateAfterAnimationProperty().addListener((pbs, oldVal, newVal) -> rootNode
				.fireEvent(new ControlBarEvent(ControlBarEvent.ON_DRAWER_TOGGLE, !newVal)));
	}

	private void setGlyphs() {
		btnAdd.setGraphic(SVGLoader.loadSVGGlyph(SVG.PLAYER_ADD, SVG_SIZE));
		btnRefresh.setGraphic(SVGLoader.loadSVGGlyph(SVG.REFRESH, SVG_SIZE));
		btnOptions.setGraphic(SVGLoader.loadSVGGlyph(SVG.OPTIONS, SVG_SIZE));
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
