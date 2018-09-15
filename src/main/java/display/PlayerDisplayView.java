package display;

import javafx.scene.control.TableView;
import objects.Player;
import utils.FXMLService;

public class PlayerDisplayView extends TableView<Player> {

	public PlayerDisplayView() {
		FXMLService.load(this);
	}
}
