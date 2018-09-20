package input;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import utils.svg.SVG;
import utils.svg.SVGLoader;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXButton;

public class PlayerInputViewController implements Initializable {

	@FXML
	PlayerInputView rootNode;
	@FXML
	JFXTextField tfId;
	@FXML
	JFXTextArea taComment;
	@FXML
	JFXButton btnAdd;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnAdd.setGraphic(SVGLoader.loadSVGGlyph(SVG.PLUS, SVG.MEDIUM));
	}

	@FXML
	public void onAdd(ActionEvent event) {
		rootNode.fireEvent(new PlayerEvent(PlayerEvent.ON_ADD, tfId.getText(), taComment.getText()));

	}

}
