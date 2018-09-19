package services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.text.html.HTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import objects.PlayerAttributes;
import utils.HtmlUtils;
import utils.StringUtils;

public class SoFifaParserService {

	public static Map<String, String> setMetaData(Document doc, Map<String, String> map) {
		Element meta = doc.selectFirst(".meta");
		setName(doc, map);
		setTeam(doc.selectFirst(HtmlUtils.hrefContainsTeam()), map);
		List<TextNode> first = meta.childNodes().stream()
				.filter(node -> node instanceof TextNode && !((TextNode) node).getWholeText().trim().isEmpty())
				.map(arg -> (TextNode) arg).collect(Collectors.toList());
		processAdditionalData(first.get(1), map);
		Element countryElement = meta.selectFirst("a[title]");
		map.put(PlayerAttributes.COUNTRY, countryElement.attr("title"));
		setPositions(map, meta);
		return map;
	}

	private static void setTeam(Element team, Map<String, String> map) {
		Optional<TextNode> first = team.childNodes().stream()
				.filter(node -> node instanceof TextNode && !((TextNode) node).getWholeText().trim().isEmpty())
				.map(arg -> (TextNode) arg).findFirst();
		map.put("Team", first.isPresent() ? first.get().text() : "");
	}

	private static void setName(Document doc, Map<String, String> map) {
		Elements header = doc.select(HtmlUtils.H1);
		Optional<Element> nameElement = header.stream().filter(element -> element.wholeText().contains("ID"))
				.findFirst();
		if (nameElement.isPresent()) {
			List<String> splitOnBraces = StringUtils.splitOnBraces(nameElement.get().wholeText());
			map.put(PlayerAttributes.NAME, splitOnBraces.get(0));
		}
	}

	private static void setPositions(Map<String, String> map, Element meta) {
		Elements positions = meta.select(HtmlUtils.SPAN);
		for (Element span : positions) {
			if (span.attr(HtmlUtils.CLASS) != null && span.attr(HtmlUtils.CLASS).trim().toLowerCase().contains("pos")) {
				if (map.containsKey(PlayerAttributes.POSITIONS))
					map.put(PlayerAttributes.POSITIONS, map.get(PlayerAttributes.POSITIONS).concat(" " + span.html()));
				else
					map.put(PlayerAttributes.POSITIONS, span.html());
			}
		}
	}

	private static void processAdditionalData(TextNode textNode, Map<String, String> map) {
		String text = textNode.text().trim();
		List<String> splittedAttributes = StringUtils.splitOnBraces(text);
		for (String attribute : splittedAttributes) {
			if (attribute.contains(PlayerAttributes.AGE))
				map.put(PlayerAttributes.AGE, attribute.replaceFirst(PlayerAttributes.AGE, "").trim());
			if (attribute.contains("cm") && attribute.contains("kg")) {
				List<String> heightNWeight = StringUtils.splitOnWhitespaces(attribute);
				for (String physical : heightNWeight) {
					if (physical.contains("cm"))
						map.put(PlayerAttributes.HEIGHT, physical.replaceFirst("cm", "").trim());
					if (physical.contains("kg"))
						map.put(PlayerAttributes.WEIGHT, physical.replaceFirst("kg", "").trim());
				}

			}

		}

	}

	public static Map<String, String> setEntry(Document doc, String selector, Map<String, String> map) {
		Element element = doc.selectFirst(HtmlUtils.listContains(selector));
		if (element == null)
			element = doc.selectFirst(HtmlUtils.divContainsOwn(selector));
		if (element != null) {
			Element span = element.selectFirst(HtmlUtils.SPAN);
			if (span != null) {
				map.put(selector, span.html());
			} else {
				Optional<TextNode> first = element.childNodes().stream()
						.filter(node -> node instanceof TextNode && !((TextNode) node).getWholeText().isEmpty())
						.map(arg -> (TextNode) arg).findFirst();
				if (first.isPresent())
					map.put(selector, first.get().getWholeText());
				else {
					Element joinedFrom = element.selectFirst(HtmlUtils.A);
					if (element != null)
						map.put(selector, joinedFrom.html());
				}
			}
		}
		if (!map.containsKey(selector))
			map.put(selector, "");
		return map;
	}

	public static Map<String, String> setCombinedAttributes(Document doc, Map<String, String> map, String id) {
		Elements scriptTags = doc.getElementsByTag(HtmlUtils.SCRIPT);
		for (Element tag : scriptTags)
			for (DataNode node : tag.dataNodes())
				if (node.getWholeData().contains(id)) {
					List<String> vars = StringUtils.splitOnSemicolon(node.getWholeData());
					putPlayerValues(map, vars);
				}
		return map;
	}

	private static void putPlayerValues(Map<String, String> map, List<String> vars) {
		for (String var : vars) {
			if (var.contains(PlayerAttributes.COMBINED_FIRST))
				map.put("firstAttribute", StringUtils.removeAllNonDigits(var));

			if (var.contains(PlayerAttributes.COMBINED_SECOND))
				map.put("secondAttribute", StringUtils.removeAllNonDigits(var));

			if (var.contains(PlayerAttributes.COMBINED_THIRD))
				map.put("thirdAttribute", StringUtils.removeAllNonDigits(var));

			if (var.contains(PlayerAttributes.COMBINED_FOURTH))
				map.put("fourthAttribute", StringUtils.removeAllNonDigits(var));

			if (var.contains(PlayerAttributes.COMBINED_FIFTH))
				map.put("fifthAttribute", StringUtils.removeAllNonDigits(var));

			if (var.contains(PlayerAttributes.COMBINED_SIXTH))
				map.put("sixthAttribute", StringUtils.removeAllNonDigits(var));
		}
	}

	public static Map<String, String> setTraits(Document doc, Map<String, String> map) {
		Elements traits = doc.selectFirst("h5:containsOwn(Traits)").parent().select("li");
		StringBuilder traitsBuilder = new StringBuilder();
		for (Element child : traits) {
			traitsBuilder.append(child.wholeText());
			if(traits.indexOf(child) < traits.size() -1)
				traitsBuilder.append(", ");
		}
		map.put("Traits", traitsBuilder.toString());
		return map;
	}

}
