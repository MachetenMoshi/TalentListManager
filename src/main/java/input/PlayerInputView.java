package input;

import java.io.IOException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import objects.Player;

public class PlayerInputView extends VBox{

	private ObjectProperty<Player> player = new SimpleObjectProperty<>();
	
	private static final String FXML = "/input/PlayerInputView.fxml";
	public PlayerInputView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(FXML));
			//loader.setResources(ResourceBundle.getBundle("bundle.helloWorld"));
			loader.setRoot(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public final ObjectProperty<Player> playerProperty() {
		return this.player;
	}
	
	public final Player getPlayer() {
		return this.playerProperty().get();
	}
	
	public final void setPlayer(final Player player) {
		this.playerProperty().set(player);
	}
	
}
