package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hildan.fxgson.FxGson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import drawercontent.fileselector.FileSelectorEvent;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Pair;
import objects.CombinedAttributes;
import objects.FileInfo;
import objects.Information;
import objects.Player;
import objects.SecondaryInformation;
import utils.HtmlUtils;
import utils.StringUtils;
import utils.TranslateUtils;

public class FileParserService {

	private static final String LOANED_FROM = "loanedFrom";
	private static final String PLACEHOLDER = "-";
	private static final String POSITIONS = "positions";

	public static Pair<FileInfo, List<Player>> handleFile(FileSelectorEvent evt) {
		File file = evt.getFile();
		String header = "";
		List<Player> players = new ArrayList<>();
		if (file != null && file.isFile() && file.getAbsolutePath().endsWith(".html")) {
			try {
				StringBuffer content = StringUtils.getContent(new InputStreamReader(new FileInputStream(file)));
				Document document = Jsoup.parse(content.toString());
				Element headerElement = document.selectFirst(HtmlUtils.ID_MAIN_HEADER);
				if (headerElement != null)
					header = headerElement.html();
				Elements metaTags = document.getElementsByTag(HtmlUtils.META);
				for (Element metaTag : metaTags)
					if (metaTag.attr(HtmlUtils.ATTR_NAME).equalsIgnoreCase(HtmlUtils.PLAYER_JSON)) {
						Gson gson = FxGson.coreBuilder().setPrettyPrinting().disableHtmlEscaping().create();
						String attr = metaTag.attr(HtmlUtils.CONTENT);

						JsonElement jsonElement = gson.fromJson(attr, JsonElement.class);

						if (jsonElement.isJsonArray()) {
							JsonArray asJsonArray = jsonElement.getAsJsonArray();
							for (JsonElement element : asJsonArray) {
								players.add(gson.fromJson(element, Player.class));
							}
						} else {
							players.add(gson.fromJson(attr, Player.class));
						}
					}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return new Pair<FileInfo, List<Player>>(new FileInfo(header, file.getParentFile().getAbsolutePath()), players);
	}

	public static Document generateHtmlFile(Document document, List<Player> items, String header,
			boolean addSecondaryInformation) {
		Elements playerTable = document.select(HtmlUtils.ID_PLAYER_TABLE);
		setHeader(document, header);
		boolean allKeepers = items.stream().allMatch(p -> p.getInformation().getPositions().contains("GK"));
		generateHeaders(new Player(), playerTable, allKeepers, addSecondaryInformation);
		generateRows(items, playerTable, addSecondaryInformation);

		Elements metaTags = document.getElementsByTag(HtmlUtils.META);
		for (Element metaTag : metaTags)
			if (metaTag.attr(HtmlUtils.ATTR_NAME).equalsIgnoreCase(HtmlUtils.PLAYER_JSON)) {
				Gson gson = FxGson.coreBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				metaTag.attr(HtmlUtils.CONTENT, gson.toJson(items));
			}
		return document;
	}

	private static void setHeader(Document document, String header) {
		Element headerElement = document.selectFirst(HtmlUtils.ID_MAIN_HEADER);
		headerElement.html(header);
	}

	private static void generateRows(List<Player> items, Elements playerTable, boolean addSecondaryInformation) {
		StringBuilder rows = new StringBuilder();
		rows.append(HtmlUtils.TBODY);
		for (Player player : items)
			rows.append(generateRow(player, addSecondaryInformation));
		rows.append(HtmlUtils.TBODY_CLOSING);
		playerTable.append(rows.toString());
	}

	private static String generateRow(Player player, boolean addSecondaryInformation) {
		StringBuilder stringBuilder = new StringBuilder();

		try {
			List<Field> informationFields = new ArrayList<>(
					Arrays.asList(player.getInformation().getClass().getDeclaredFields()));
			getFields(stringBuilder, player.getInformation(), informationFields, false);

			List<Field> combinedAttritubes = new ArrayList<>(
					Arrays.asList(player.getCombinedAttributes().getClass().getDeclaredFields()));
			getFields(stringBuilder, player.getCombinedAttributes(), combinedAttritubes, true);
			if (addSecondaryInformation) {
				List<Field> secondaryInformation = new ArrayList<>(
						Arrays.asList(player.getSecondaryInformation().getClass().getDeclaredFields()));
				getFields(stringBuilder, player.getSecondaryInformation(), secondaryInformation, false);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return HtmlUtils.wrapInTableRecord(stringBuilder.toString());
	}

	private static void getFields(StringBuilder stringBuilder, Object object, List<Field> fields, boolean addColors)
			throws IllegalAccessException {
		for (Field info : fields) {
			info.setAccessible(true);
			String value = ((StringProperty) info.get(object)).get();
			String name = info.getName();
			if (value == null || value.isEmpty())
				value = PLACEHOLDER;
			if (name.equals(POSITIONS))
				value = translatePositions(value);
			if (name.equals(LOANED_FROM))
				value = value.equals(PLACEHOLDER) ? PLACEHOLDER : "Ja";
			else {
				value = TranslateUtils.tryTranslatingBasics(value);
			}
			if (addColors || isRating(name))
				stringBuilder.append(HtmlUtils.wrapInStyledTableCell(value));
			else
				stringBuilder.append(HtmlUtils.getAsTableCell(value));
		}
	}

	private static boolean isRating(String name) {
		return name.equals("overallRating") || name.equals("potential");
	}

	private static String translatePositions(String value) {
		List<String> positions = StringUtils.splitOnWhitespaces(value);
		StringBuilder positionBuilder = new StringBuilder();
		for (String position : positions)
			positionBuilder.append(TranslateUtils.translatePosition(position) + " ");
		value = positionBuilder.toString();
		return value;
	}

	private static void generateHeaders(Player player, Elements playerTable, boolean allKeepers,
			boolean addSecondaryInformation) {
		StringBuilder stringBuilder = new StringBuilder();
		int priority = parseInformations(stringBuilder, player.getInformation());
		priority = parseAttributes(priority, allKeepers, stringBuilder, player.getCombinedAttributes());
		if (addSecondaryInformation)
			parseSecondaryInformations(priority, stringBuilder, player.getSecondaryInformation());
		playerTable.append(HtmlUtils.wrapInTableHead(stringBuilder.toString()));
	}

	private static void parseSecondaryInformations(int priority, StringBuilder stringBuilder,
			SecondaryInformation secondaryInformation) {
		List<Field> secondaryInformationFields = new ArrayList<>(
				Arrays.asList(secondaryInformation.getClass().getDeclaredFields()));
		for (Field info : secondaryInformationFields)
			stringBuilder.append(HtmlUtils.wrapInTableHeader(secondaryInformationFields.indexOf(info) + priority,
					TranslateUtils.getReadableName(info.getName())));

	}

	private static int parseInformations(StringBuilder stringBuilder, Information information) {
		List<Field> informationFields = new ArrayList<>(Arrays.asList(information.getClass().getDeclaredFields()));
		for (Field info : informationFields)
			stringBuilder.append(HtmlUtils.wrapInTableHeader(informationFields.indexOf(info),
					TranslateUtils.getReadableName(info.getName())));
		return informationFields.size();
	}

	private static int parseAttributes(int priority, boolean allKeepers, StringBuilder stringBuilder,
			CombinedAttributes attr) {
		List<Field> informationFields = new ArrayList<>(Arrays.asList(attr.getClass().getDeclaredFields()));
		for (Field info : informationFields)
			stringBuilder.append(HtmlUtils.wrapInTableHeader(informationFields.indexOf(info) + priority,
					TranslateUtils.getCombinedAttributeName(info.getName(), allKeepers)));
		return priority + informationFields.size();
	}

}
