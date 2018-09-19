package controlbar;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.HBox;
import utils.FXMLService;

public class ControlBarView extends HBox {
	private BooleanProperty drawerClosed = new SimpleBooleanProperty(true);

	public ControlBarView() {
		FXMLService.load(this);
	}

	public final BooleanProperty drawerClosedProperty() {
		return this.drawerClosed;
	}
	

	public final boolean isDrawerClosed() {
		return this.drawerClosedProperty().get();
	}
	

	public final void setDrawerClosed(final boolean drawerClosed) {
		this.drawerClosedProperty().set(drawerClosed);
	}
	

}
