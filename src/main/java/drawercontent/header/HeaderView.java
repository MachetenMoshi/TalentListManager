package drawercontent.header;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.FXMLService;

public class HeaderView extends HBox {

	private ObjectProperty<EventHandler<ActionEvent>> actionEventHander = new SimpleObjectProperty<>();
	private StringProperty text = new SimpleStringProperty();
	private BooleanProperty actionButtonVisible = new SimpleBooleanProperty(true);

	public HeaderView() {
		FXMLService.load(this);
	}

	public final ObjectProperty<EventHandler<ActionEvent>> actionEventHanderProperty() {
		return this.actionEventHander;
	}

	public final EventHandler<ActionEvent> getActionEventHander() {
		return this.actionEventHanderProperty().get();
	}

	public final void setActionEventHander(final EventHandler<ActionEvent> actionEventHander) {
		this.actionEventHanderProperty().set(actionEventHander);
	}

	public final StringProperty textProperty() {
		return this.text;
	}

	public final String getText() {
		return this.textProperty().get();
	}

	public final void setText(final String text) {
		this.textProperty().set(text);
	}

	public final BooleanProperty actionButtonVisibleProperty() {
		return this.actionButtonVisible;
	}
	

	public final boolean isActionButtonVisible() {
		return this.actionButtonVisibleProperty().get();
	}
	

	public final void setActionButtonVisible(final boolean actionButtonVisible) {
		this.actionButtonVisibleProperty().set(actionButtonVisible);
	}
	

}
