package utils.cellfactories;

import java.io.File;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class FileCellFactory implements Callback<ListView<File>, ListCell<File>> {

	@Override
	public ListCell<File> call(ListView<File> param) {
		ListCell<File> cell = new ListCell<File>() {

			@Override
			protected void updateItem(File item, boolean empty) {
				super.updateItem(item, empty);
				if (item != null) {
					setText(item.getName());
				} else {
					setText("");
				}
			}
		};
		return cell;
	}
}