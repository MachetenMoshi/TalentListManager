package input;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXTextArea;

public class PlayerInputViewController implements Initializable {

	@FXML
	PlayerInputView rootNode;
	@FXML
	JFXTextField tfId;
	@FXML
	JFXTextArea taComment;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void onAdd(ActionEvent event) {
		rootNode.fireEvent(new PlayerEvent(PlayerEvent.ON_ADD, tfId.getText(), taComment.getText()));

	}

}
