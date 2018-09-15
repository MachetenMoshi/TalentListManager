package input;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.VBox;
import objects.Player;
import utils.FXMLService;

public class PlayerInputView extends VBox{

	private ObjectProperty<Player> player = new SimpleObjectProperty<>();
	
	public PlayerInputView() {
		FXMLService.load(this);
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
