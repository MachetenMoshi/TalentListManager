package drawercontent.header;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.HBox;

public class HeaderController implements Initializable {

	@FXML
	HeaderView rootNode;
	@FXML
	Label lblText;
	@FXML
	JFXButton btnAction;
	@FXML
	HBox actionContainer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setBindings();
		rootNode.actionNodeProperty().addListener((obs, oldVal, newVal) -> handleActionNodeChange(newVal));
	}

	private void handleActionNodeChange(Node newVal) {
		actionContainer.getChildren().clear();
		if (newVal != null)
			actionContainer.getChildren().add(newVal);

	}

	private void setBindings() {
		lblText.textProperty().bind(rootNode.textProperty());
	}

}
