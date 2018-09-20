package drawercontent.header;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import utils.FXMLService;

public class HeaderView extends HBox {

	private StringProperty text = new SimpleStringProperty();
	private ObjectProperty<Node> actionNode = new SimpleObjectProperty<>();

	public HeaderView() {
		FXMLService.load(this);
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

	public final ObjectProperty<Node> actionNodeProperty() {
		return this.actionNode;
	}

	public final Node getActionNode() {
		return this.actionNodeProperty().get();
	}

	public final void setActionNode(final Node actionNode) {
		this.actionNodeProperty().set(actionNode);
	}

}
