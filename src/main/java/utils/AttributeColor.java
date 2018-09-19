package utils;

public enum AttributeColor {

	RED("#e9573e"), GREEN("#8dc153"), DARK_GREEN("#0c953b"), YELLOW("#f6bb43"), ORANGE("#e77e23");

	AttributeColor(String color) {
		this.color = color;
	}

	private final String color;

	public String getColor() {
		return color;
	}
}
