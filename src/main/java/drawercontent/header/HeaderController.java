package drawercontent.header;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;

public class HeaderController implements Initializable {

	@FXML
	HeaderView rootNode;
	@FXML
	Label lblText;
	@FXML
	JFXButton btnAction;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setBindings();

	}

	private void setBindings() {
		lblText.textProperty().bind(rootNode.textProperty());
		btnAction.onActionProperty().bind(rootNode.actionEventHanderProperty());
		btnAction.visibleProperty().bind(rootNode.actionButtonVisibleProperty());
		btnAction.managedProperty().bind(btnAction.visibleProperty());
	}

}
