package drawercontent.filter;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import drawercontent.header.HeaderView;
import com.jfoenix.controls.JFXTextField;

public class FilterController implements Initializable {

	@FXML FilterView rootNode;
	@FXML HeaderView headerView;
	@FXML JFXTextField tfName;
	@FXML JFXTextField tfAgeFrom;
	@FXML JFXTextField tfAgeTo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
