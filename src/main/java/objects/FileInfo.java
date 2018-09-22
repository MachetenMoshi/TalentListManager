package objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FileInfo {
	private StringProperty contentName = new SimpleStringProperty();
	private StringProperty filePath = new SimpleStringProperty();

	public FileInfo(String contentName, String filePath) {
		setContentName(contentName);
		setFilePath(filePath);
	}

	public final StringProperty contentNameProperty() {
		return this.contentName;
	}

	public final String getContentName() {
		return this.contentNameProperty().get();
	}

	public final void setContentName(final String contentName) {
		this.contentNameProperty().set(contentName);
	}

	public final StringProperty filePathProperty() {
		return this.filePath;
	}

	public final String getFilePath() {
		return this.filePathProperty().get();
	}

	public final void setFilePath(final String filePath) {
		this.filePathProperty().set(filePath);
	}

}
