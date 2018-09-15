package objects;

import java.util.Arrays;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {
	private ObjectProperty<Information> information = new SimpleObjectProperty<>();
	private ObjectProperty<CombinedAttribtues> combinedAttributes = new SimpleObjectProperty<>();
	private ObjectProperty<DetailAttributes> detailAttributes = new SimpleObjectProperty<>();

	public Player() {
		setCombinedAttributes(new CombinedAttribtues());
		setDetailAttributes(new DetailAttributes());
		setInformation(new Information());
	}

	public Player(CombinedAttribtues combinedAttributes, DetailAttributes detailAttributes, Information information) {
		setCombinedAttributes(combinedAttributes);
		setDetailAttributes(detailAttributes);
		setInformation(information);
	}

	public final ObjectProperty<CombinedAttribtues> combinedAttributesProperty() {
		return this.combinedAttributes;
	}

	public final CombinedAttribtues getCombinedAttributes() {
		return this.combinedAttributesProperty().get();
	}

	public final void setCombinedAttributes(final CombinedAttribtues combinedAttributes) {
		this.combinedAttributesProperty().set(combinedAttributes);
	}

	public final ObjectProperty<DetailAttributes> detailAttributesProperty() {
		return this.detailAttributes;
	}

	public final DetailAttributes getDetailAttributes() {
		return this.detailAttributesProperty().get();
	}

	public final void setDetailAttributes(final DetailAttributes detailAttributes) {
		this.detailAttributesProperty().set(detailAttributes);
	}

	public final ObjectProperty<Information> informationProperty() {
		return this.information;
	}

	public final Information getInformation() {
		return this.informationProperty().get();
	}

	public final void setInformation(final Information information) {
		this.informationProperty().set(information);
	}

}
