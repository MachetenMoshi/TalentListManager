package input;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXTextField;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PlayerInputViewController implements Initializable {

	@FXML
	PlayerInputView rootNode;
	@FXML
	JFXTextField tfId;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void onKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER)
			rootNode.fireEvent(new PlayerEvent(PlayerEvent.ID_CHANGED, tfId.getText()));
	}

}
