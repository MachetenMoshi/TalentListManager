package drawercontent.fileselector;

import java.io.File;
import java.nio.file.Path;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import utils.FXMLService;

public class FileSelectorView extends VBox {

	private ListProperty<File> selectedFiles = new SimpleListProperty<>();

	public FileSelectorView() {
		FXMLService.load(this);
	}

	public final ListProperty<File> selectedFilesProperty() {
		return this.selectedFiles;
	}
	

	public final ObservableList<File> getSelectedFiles() {
		return this.selectedFilesProperty().get();
	}
	

	public final void setSelectedFiles(final ObservableList<File> selectedFiles) {
		this.selectedFilesProperty().set(selectedFiles);
	}
	



}
