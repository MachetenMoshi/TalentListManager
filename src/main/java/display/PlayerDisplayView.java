package display;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.TableView;
import objects.Player;
import utils.FXMLService;

public class PlayerDisplayView extends TableView<Player> {

	private DoubleProperty resizeOffset = new SimpleDoubleProperty(0);

	public PlayerDisplayView() {
		FXMLService.load(this);
	}

	public final DoubleProperty resizeOffsetProperty() {
		return this.resizeOffset;
	}

	public final double getResizeOffset() {
		return this.resizeOffsetProperty().get();
	}

	public final void setResizeOffset(final double resizeOffset) {
		this.resizeOffsetProperty().set(resizeOffset);
	}

}
