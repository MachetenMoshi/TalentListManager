package objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SecondaryInformation {
	private StringProperty traits = new SimpleStringProperty();

	public final StringProperty traitsProperty() {
		return this.traits;
	}

	public final String getTraits() {
		return this.traitsProperty().get();
	}

	public final void setTraits(final String traits) {
		this.traitsProperty().set(traits);
	}

}
