package objects;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {
	private ObjectProperty<Information> information = new SimpleObjectProperty<>();
	private ObjectProperty<CombinedAttributes> combinedAttributes = new SimpleObjectProperty<>();
	private ObjectProperty<DetailAttributes> detailAttributes = new SimpleObjectProperty<>();
	private ObjectProperty<SecondaryInformation> secondaryInformation = new SimpleObjectProperty<>();

	public Player() {
		setCombinedAttributes(new CombinedAttributes());
		setDetailAttributes(new DetailAttributes());
		setInformation(new Information());
		setSecondaryInformation(new SecondaryInformation());
	}

	public Player(CombinedAttributes combinedAttributes, DetailAttributes detailAttributes, Information information,
			SecondaryInformation secondaryInformation) {
		setCombinedAttributes(combinedAttributes);
		setDetailAttributes(detailAttributes);
		setInformation(information);
		setSecondaryInformation(secondaryInformation);
	}

	public final ObjectProperty<CombinedAttributes> combinedAttributesProperty() {
		return this.combinedAttributes;
	} 

	public final CombinedAttributes getCombinedAttributes() {
		return this.combinedAttributesProperty().get();
	}

	public final void setCombinedAttributes(final CombinedAttributes combinedAttributes) {
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

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Player) {
			Player player = (Player) obj;
			if (getInformation() != null && player.getInformation() != null)
				return getInformation().getId().equals(player.getInformation().getId());
		}
		return false;
	}

	public final ObjectProperty<SecondaryInformation> secondaryInformationProperty() {
		return this.secondaryInformation;
	}

	public final SecondaryInformation getSecondaryInformation() {
		return this.secondaryInformationProperty().get();
	}

	public final void setSecondaryInformation(final SecondaryInformation secondaryInformation) {
		this.secondaryInformationProperty().set(secondaryInformation);
	}

}
