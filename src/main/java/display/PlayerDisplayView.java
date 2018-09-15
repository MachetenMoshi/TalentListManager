package display;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import objects.Player;

public class PlayerDisplayView extends TableView<Player> {

	private static final String FXML = "/display/PlayerDisplayView.fxml";

	public PlayerDisplayView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(FXML));
			// loader.setResources(ResourceBundle.getBundle("bundle.helloWorld"));
			loader.setRoot(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
