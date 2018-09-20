package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import objects.TranslationPair;

public class TranslateUtils {

	private static List<TranslationPair> pairsRegular = Arrays.asList(new TranslationPair("age", "Alter"),
			new TranslationPair("name", "Name"), new TranslationPair("positions", "POS"),
			new TranslationPair("overallRating", "GES"), new TranslationPair("potential", "POT"),
			new TranslationPair("skillMoves", "Spezial"), new TranslationPair("weakFoot", "Schwacher Fuﬂ"),
			new TranslationPair("preferredFoot", "Fuﬂ"), new TranslationPair("workRate", "Arbeitsraten"),
			new TranslationPair("joined", "Seit"), new TranslationPair("loanedFrom", "Ausgeliehen"),
			new TranslationPair("comment", "Kommentar"), new TranslationPair("id", "ID"),
			new TranslationPair("team", "Team"), new TranslationPair("traits", "Eigenschaften"),
			new TranslationPair("height", "Grˆﬂe"), new TranslationPair("weight", "Gewicht"),

			new TranslationPair("crossing", "Flanken"), new TranslationPair("finishing", "Abschluss"),
			new TranslationPair("headingAccuracy", "Kopfball"), new TranslationPair("shortPassing", "Kurzpass"),
			new TranslationPair("volleys", "Volleys"), new TranslationPair("dribbling", "Dribbling"),
			new TranslationPair("curve", "Effet"), new TranslationPair("fKAccuracy", "Freistoﬂ"),
			new TranslationPair("longPassing", "Langer Pass"), new TranslationPair("ballControl", "Ballkontrolle"),
			new TranslationPair("acceleration", "Beschleunigung"),
			new TranslationPair("sprintSpeed", "Geschwindigkeit"), new TranslationPair("agility", "Beweglichkeit"),
			new TranslationPair("reactions", "Reaktion"), new TranslationPair("balance", "Balance"),
			new TranslationPair("shotPower", "Schusskraft"), new TranslationPair("jumping", "Sprungkraft"),
			new TranslationPair("stamina", "Ausdauer"), new TranslationPair("strength", "St‰rke"),
			new TranslationPair("longShots", "Weitschuss"), new TranslationPair("aggression", "Aggression"),
			new TranslationPair("interceptions", "Abfangen"), new TranslationPair("positioning", "Stellungsspiel"),
			new TranslationPair("vision", "‹bersicht"), new TranslationPair("penalties", "Elfmeter"),
			new TranslationPair("composure", "Ruhe"), new TranslationPair("marking", "Manndeckung"),
			new TranslationPair("standingTackle", "Zweikampf"), new TranslationPair("slidingTackle", "Gr‰tsche"),
			new TranslationPair("gKDiving", "Hechten"), new TranslationPair("gKHandling", "Fangsicherheit"),
			new TranslationPair("gKKicking", "Abschlag"), new TranslationPair("gKPositioning", "Stellungsspiel"),
			new TranslationPair("gKReflexes", "Reflexe"));

	private static List<TranslationPair> playerCombinedAttributes = Arrays.asList(
			new TranslationPair("firstAttribute", "Schnelligkeit"), new TranslationPair("secondAttribute", "Schieﬂen"),
			new TranslationPair("thirdAttribute", "Passen"), new TranslationPair("fourthAttribute", "Dribbling"),
			new TranslationPair("fifthAttribute", "Verteidigung"), new TranslationPair("sixthAttribute", "Physis"));

	private static List<TranslationPair> keeperCombinedAttributes = Arrays.asList(
			new TranslationPair("firstAttribute", "Hechten"), new TranslationPair("secondAttribute", "Fangsicherheit"),
			new TranslationPair("thirdAttribute", "Abschlag"), new TranslationPair("fourthAttribute", "Reflexe"),
			new TranslationPair("fifthAttribute", "Geschwindigkeit"),
			new TranslationPair("sixthAttribute", "Stellungsspiel"));

	private static List<TranslationPair> positions = Arrays.asList(new TranslationPair("GK", "TW"),
			new TranslationPair("LWB", "LAV"), new TranslationPair("LB", "LV"), new TranslationPair("CB", "IV"),
			new TranslationPair("RB", "RV"), new TranslationPair("RWB", "RAV"), new TranslationPair("CDM", "ZDM"),
			new TranslationPair("CM", "ZM"), new TranslationPair("LM", "LM"), new TranslationPair("RM", "RM"),
			new TranslationPair("RW", "RA"), new TranslationPair("LW", "LA"), new TranslationPair("CF", "MS"),
			new TranslationPair("CAM", "ZOM"), new TranslationPair("CAM", "ZOM"), new TranslationPair("ST", "ST"));

	public static String getReadableName(String fieldName) {
		Optional<TranslationPair> first = pairsRegular.stream().filter(p -> p.getFieldName().equals(fieldName))
				.findFirst();
		return first.isPresent() ? first.get().getReadableName() : fieldName;
	}

	public static String getCombinedAttributeName(String fieldName, boolean isKeeper) {
		if (isKeeper) {
			Optional<TranslationPair> first = keeperCombinedAttributes.stream()
					.filter(p -> p.getFieldName().equals(fieldName)).findFirst();
			return first.isPresent() ? first.get().getReadableName() : fieldName;
		} else {
			Optional<TranslationPair> first = playerCombinedAttributes.stream()
					.filter(p -> p.getFieldName().equals(fieldName)).findFirst();
			return first.isPresent() ? first.get().getReadableName() : fieldName;
		}
	}

	public static String translatePosition(String position) {
		Optional<TranslationPair> first = positions.stream().filter(p -> p.getFieldName().equals(position)).findFirst();
		return first.isPresent() ? first.get().getReadableName() : position;
	}

	public static String tryTranslatingBasics(String value) {
		value = value.replaceAll("Right", "Rechts");
		value = value.replaceAll("Left", "Links");
		value = value.replaceAll("High", "Hoch");
		value = value.replaceAll("Medium", "Mittel");
		value = value.replaceAll("Low", "Niedrig");
		value = value.replaceAll("/ ", " - ");
		return value;

	}
}
