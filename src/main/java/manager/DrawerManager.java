package manager;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jfoenix.svg.SVGGlyphLoader;

import drawercontent.DrawerContentView;
import drawercontent.fileselector.FileSelectorEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import utils.HtmlUtils;

public class DrawerManager {

	private DrawerContentView drawerContentView = new DrawerContentView();

	public DrawerManager() {
		setListener();
	}

	private void setListener() {
		drawerContentView.addEventHandler(FileSelectorEvent.ON_SHOW_FILE_SELECTION, evt -> showFileSelectionDialog());

	}

	private void showFileSelectionDialog() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Open Resource File");
		File file = directoryChooser.showDialog(drawerContentView.getScene().getWindow());
		if (file != null && file.exists()) {
			List<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));
			files = files.stream().filter(arg -> arg.isFile() && arg.getAbsolutePath().endsWith(HtmlUtils.HTML_SUFFIX))
					.collect(Collectors.toList());
			drawerContentView.setSelectedFiles(FXCollections.observableArrayList(files));
		}
	}

	public DrawerContentView getDrawerContentView() {
		return drawerContentView;
	}
}
