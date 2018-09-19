package drawercontent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import drawercontent.filter.FilterView;
import drawercontent.fileselector.FileSelectorView;

public class DrawerContentController implements Initializable {

	@FXML
	DrawerContentView rootNode;
	@FXML
	FilterView filterView;
	@FXML
	FileSelectorView fileSelectorView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fileSelectorView.selectedFilesProperty().bind(rootNode.selectedFilesProperty());

	}

}
