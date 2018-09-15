package controlbar;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
		// TODO Auto-generated method stub

	}

	@FXML
	public void onRefresh(ActionEvent event) {
	}

	@FXML
	public void onAdd(ActionEvent event) {
	}

	@FXML
	public void onOptions(ActionEvent event) {
	}

}
