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
			new TranslationPair("skillMoves", "Spezial"), new TranslationPair("weakFoot", "Schwacher Fuß"),
			new TranslationPair("preferredFoot", "Fuß"), new TranslationPair("workRate", "Arbeits&shy;rate"),
			new TranslationPair("joined", "Seit"), new TranslationPair("loanedFrom", "Leihe"),
			new TranslationPair("comment", "Kommentar"), new TranslationPair("id", "ID"),
			new TranslationPair("team", "Team"), new TranslationPair("traits", "Infos"),
			new TranslationPair("height", "Größe"), new TranslationPair("weight", "Gewicht"),

			new TranslationPair("crossing", "Flanken"), new TranslationPair("finishing", "Abschluss"),
			new TranslationPair("headingAccuracy", "Kopfball"), new TranslationPair("shortPassing", "Kurzpass"),
			new TranslationPair("volleys", "Volleys"), new TranslationPair("dribbling", "Dribbling"),
			new TranslationPair("curve", "Effet"), new TranslationPair("fKAccuracy", "Freistoß"),
			new TranslationPair("longPassing", "Langer Pass"), new TranslationPair("ballControl", "Ballkontrolle"),
			new TranslationPair("acceleration", "Beschleunigung"),
			new TranslationPair("sprintSpeed", "Geschwindigkeit"), new TranslationPair("agility", "Beweglichkeit"),
			new TranslationPair("reactions", "Reaktion"), new TranslationPair("balance", "Balance"),
			new TranslationPair("shotPower", "Schusskraft"), new TranslationPair("jumping", "Sprungkraft"),
			new TranslationPair("stamina", "Ausdauer"), new TranslationPair("strength", "Stärke"),
			new TranslationPair("longShots", "Weitschuss"), new TranslationPair("aggression", "Aggression"),
			new TranslationPair("interceptions", "Abfangen"), new TranslationPair("positioning", "Stellungsspiel"),
			new TranslationPair("vision", "Übersicht"), new TranslationPair("penalties", "Elfmeter"),
			new TranslationPair("composure", "Ruhe"), new TranslationPair("marking", "Manndeckung"),
			new TranslationPair("standingTackle", "Zweikampf"), new TranslationPair("slidingTackle", "Grätsche"),
			new TranslationPair("gKDiving", "Hechten"), new TranslationPair("gKHandling", "Fangsicherheit"),
			new TranslationPair("gKKicking", "Abschlag"), new TranslationPair("gKPositioning", "Stellungsspiel"),
			new TranslationPair("gKReflexes", "Reflexe"));

	private static List<TranslationPair> playerCombinedAttributes = Arrays.asList(
			new TranslationPair("firstAttribute", "Schnell&shy;igkeit"),
			new TranslationPair("secondAttribute", "Schießen"), new TranslationPair("thirdAttribute", "Passen"),
			new TranslationPair("fourthAttribute", "Dribbling"), new TranslationPair("fifthAttribute", "Abwehr"),
			new TranslationPair("sixthAttribute", "Physis"));

	private static List<TranslationPair> keeperCombinedAttributes = Arrays.asList(
			new TranslationPair("firstAttribute", "Hechten"),
			new TranslationPair("secondAttribute", "Fangsicher&shy;heit"),
			new TranslationPair("thirdAttribute", "Abschlag"), new TranslationPair("fourthAttribute", "Reflexe"),
			new TranslationPair("fifthAttribute", "Geschwind&shy;igkeit"),
			new TranslationPair("sixthAttribute", "Stellungs&shy;spiel"));

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
		value = value.replaceAll("High", "H");
		value = value.replaceAll("Medium", "M");
		value = value.replaceAll("Low", "L");
		value = value.replaceAll("/ ", "/");
		value = value.replaceAll("GK Rushes Out of Goal", "Stürmt aus dem Tor");
		value = value.replaceAll("GK Long Throw", "Weiter Abwurf");
		value = value.replaceAll("GK Cautious With Crosses", "Vorsichtig bei Flanken");
		value = value.replaceAll("GK Saves With Feet", "Fußabwehr");
		value = value.replaceAll("Comes For Crosses", "Fängt Flanken ab");
		value = value.replaceAll("Puncher", "Faustet");

		value = value.replaceAll("Injury Prone", "Verletzungs&shy;anfällig");
		value = value.replaceAll("Speed Dribbler", "Schneller Dribbler");
		value = value.replaceAll("Corner Specialist", "Ecken&shy;spezialist");
		value = value.replaceAll("Takes Finesse Free Kicks", "Raffinierte Freistöße");
		value = value.replaceAll("Long Throw-in", "Weiter Einwurf");
		value = value.replaceAll("Early Crosser", "Frühe Flanken");
		value = value.replaceAll("Avoids Using Weaker Foot", "Meidet schwachen Fuß");
		value = value.replaceAll("Technical Dribbler", "Technischer Dribbler");
		value = value.replaceAll("Long Shot Taker", "Weit&shy;schüsse");

		value = value.replaceAll("Tries To Beat Defensive Line", "Versucht Abwehr zu überlaufen");
		value = value.replaceAll("Finesse Shot", "An&shy;geschnitt&shy;ener Schuss");
		value = value.replaceAll("Playmaker", "Spielmacher");
		value = value.replaceAll("Backs Into Player", "Abschirmen");
		value = value.replaceAll("Diver", "Schwalben&shy;könig");
		value = value.replaceAll("Through Ball", "Schnitt&shy;stellen&shy;pässe");
		value = value.replaceAll("Selfish", "Egoistisch");
		value = value.replaceAll("Injury Free", "Verletzungs&shy;frei");
		value = value.replaceAll("Outside Foot Shot", "Außen&shy;rist&shy;schuss");

		value = value.replaceAll("Target Torward", "Wand&shy;spieler");
		value = value.replaceAll("Power Header", "Power-Kopf&shy;ball");
		value = value.replaceAll("Chip Shot", "Lupfer");
		value = value.replaceAll("Power Free Kick", "Power-Frei&shy;stoß");
		value = value.replaceAll("Long Passer", "Lange Pässe");
		value = value.replaceAll("Team Player", "Team&shy;spieler");
		value = value.replaceAll("Dives Into Tackles", "Wirft sich in Zwei&shy;kämpfe");
		value = value.replaceAll("Leadership", "Anführer");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");
		value = value.replaceAll("", "");

		return value;
	}
}
