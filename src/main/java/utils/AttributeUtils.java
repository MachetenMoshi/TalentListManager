package utils;

public class AttributeUtils {

	public static String getColorByAttribute(String attributeValue) {
		Integer integer = StringUtils.parseToInt(attributeValue);
		if (integer != null) {
			if (integer < 51) {
				return AttributeColor.RED.getColor();
			}
			if (integer < 61) {
				return AttributeColor.ORANGE.getColor();
			}
			if (integer < 71)
				return AttributeColor.YELLOW.getColor();
			if (integer < 81)
				return AttributeColor.GREEN.getColor();
			return AttributeColor.DARK_GREEN.getColor();
		}
		return "#00000000";
	}
}
