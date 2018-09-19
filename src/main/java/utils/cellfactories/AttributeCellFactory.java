package utils.cellfactories;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import objects.Player;
import utils.AttributeUtils;

public class AttributeCellFactory implements Callback<TableColumn<Player, String>, TableCell<Player, String>> {

	@Override
	public TableCell<Player, String> call(TableColumn<Player, String> param) {
		return new TableCell<Player, String>() {
			@Override
			public void updateItem(String value, boolean empty) {
				super.updateItem(value, empty);
				if (empty) {
					setText("");
				} else {
					setText(value);
				}
				setStyle("-fx-background-color:" + AttributeUtils.getColorByAttribute(value) + ";");

			}
		};
	}

}