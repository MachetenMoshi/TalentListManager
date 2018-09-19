package objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CombinedAttributes {

	private StringProperty firstAttribute = new SimpleStringProperty();

	private StringProperty secondAttribute = new SimpleStringProperty();

	private StringProperty thirdAttribute = new SimpleStringProperty();

	private StringProperty fourthAttribute = new SimpleStringProperty();

	private StringProperty fifthAttribute = new SimpleStringProperty();

	private StringProperty sixthAttribute = new SimpleStringProperty();

	public final StringProperty firstAttributeProperty() {
		return this.firstAttribute;
	}

	public final String getFirstAttribute() {
		return this.firstAttributeProperty().get();
	}

	public final void setFirstAttribute(final String firstAttribute) {
		this.firstAttributeProperty().set(firstAttribute);
	}

	public final StringProperty secondAttributeProperty() {
		return this.secondAttribute;
	}

	public final String getSecondAttribute() {
		return this.secondAttributeProperty().get();
	}

	public final void setSecondAttribute(final String secondAttribute) {
		this.secondAttributeProperty().set(secondAttribute);
	}

	public final StringProperty thirdAttributeProperty() {
		return this.thirdAttribute;
	}

	public final String getThirdAttribute() {
		return this.thirdAttributeProperty().get();
	}

	public final void setThirdAttribute(final String thirdAttribute) {
		this.thirdAttributeProperty().set(thirdAttribute);
	}

	public final StringProperty fourthAttributeProperty() {
		return this.fourthAttribute;
	}

	public final String getFourthAttribute() {
		return this.fourthAttributeProperty().get();
	}

	public final void setFourthAttribute(final String fourthAttribute) {
		this.fourthAttributeProperty().set(fourthAttribute);
	}

	public final StringProperty sixthAttributeProperty() {
		return this.sixthAttribute;
	}

	public final String getSixthAttribute() {
		return this.sixthAttributeProperty().get();
	}

	public final void setSixthAttribute(final String sixthAttribute) {
		this.sixthAttributeProperty().set(sixthAttribute);
	}

	public final StringProperty fifthAttributeProperty() {
		return this.fifthAttribute;
	}

	public final String getFifthAttribute() {
		return this.fifthAttributeProperty().get();
	}

	public final void setFifthAttribute(final String fifthAttribute) {
		this.fifthAttributeProperty().set(fifthAttribute);
	}

}
