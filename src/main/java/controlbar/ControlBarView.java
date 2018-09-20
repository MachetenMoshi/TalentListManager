package controlbar;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.HBox;
import utils.FXMLService;

public class ControlBarView extends HBox {
	private BooleanProperty drawerClosed = new SimpleBooleanProperty(true);
	private StringProperty headerText = new SimpleStringProperty();
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

	public final StringProperty headerTextProperty() {
		return this.headerText;
	}
	

	public final String getHeaderText() {
		return this.headerTextProperty().get();
	}
	

	public final void setHeaderText(final String headerText) {
		this.headerTextProperty().set(headerText);
	}
	
	

}
