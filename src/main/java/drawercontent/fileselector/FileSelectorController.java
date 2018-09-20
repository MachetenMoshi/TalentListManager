package drawercontent.fileselector;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import drawercontent.header.HeaderView;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import utils.cellfactories.FileCellFactory;
import utils.svg.SVG;
import utils.svg.SVGLoader;

public class FileSelectorController implements Initializable {

	@FXML
	FileSelectorView rootNode;
	@FXML
	HeaderView headerView;
	@FXML
	ListView<File> lvFiles;
	private static final String SVG_SIZE = "svg-button-small";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		JFXButton btnFileSelection = new JFXButton();
		btnFileSelection.getStyleClass().add("svg-hover-button");
		btnFileSelection.setGraphic(SVGLoader.loadSVGGlyph(SVG.FILE, SVG_SIZE));
		headerView.setActionNode(btnFileSelection);
		btnFileSelection.setOnAction(evt -> onSelectFilePath(evt));
		setListener();
		setBindings();
	}

	private void setBindings() {
		lvFiles.itemsProperty().bind(rootNode.selectedFilesProperty());
		lvFiles.setCellFactory(new FileCellFactory());
	}

	private void setListener() {
		lvFiles.getSelectionModel().selectedItemProperty()
				.addListener((obs, oldVal, newVal) -> handleFileSelectionChange(newVal));
		rootNode.selectedFilesProperty().addListener(
				(ListChangeListener.Change<? extends File> c) -> handleFileListChange(rootNode.getSelectedFiles()));

	}

	private void handleFileSelectionChange(File newVal) {
		if (newVal != null)
			rootNode.fireEvent(new FileSelectorEvent(FileSelectorEvent.ON_FILE_SELECTED, newVal));
	}

	private void handleFileListChange(ObservableList<File> selectedFiles) {
		// TODO Auto-generated method stub
	}

	private void onSelectFilePath(ActionEvent evt) {
		rootNode.fireEvent(new FileSelectorEvent(FileSelectorEvent.ON_SHOW_FILE_SELECTION));
	}

}
