package utils;

public class HtmlUtils {

	public static final String TBODY_CLOSING = "</tbody>";
	public static final String TBODY = "<tbody>";
	private static final String CLOSING_STYLE = "\";>";
	private static final String TD_STYLE_BACKGROUND_COLOR = "<td style=\"background-color:";
	private static final String TR = "<tr>";
	private static final String CLOSING_TR = "</tr>";
	private static final String CLOSING_TD = "</td>";
	private static final String TD = "<td>";
	private static final String TH = "<th>";
	private static final String CLOSING_TH = "</th>";

	public static final String META = "meta";
	public static final String CONTENT = "content";
	public static final String ID_PLAYER_TABLE = "#playerTable";
	public static final String PLAYER_JSON = "playerListJson";
	public static final String ATTR_NAME = "name";
	public static final String SPAN = "span";
	public static final String H1 = "h1";
	public static final String A = "a";
	public static final String SCRIPT = "script";
	public static final String CLASS = "class";

	public static final String HTML_SUFFIX = ".html";
	public static final String HTML_FILTER_NAME = "HTML files (*.html)";
	public static final String HTML_FILTER_VALUE = "*.html";

	public static final String TEMPLATE_PATH = "/html/template.html";
	public static final String ID_MAIN_HEADER = "#mainHeader";

	public static String getAsTableCell(String string) {
		return TD + string + CLOSING_TD;
	}

	public static String wrapInTableHead(String string) {
		return "<thead>" + wrapInTableRecord(string) + "</thead>";
	}

	public static String wrapInTableBody(String string) {
		return TBODY + wrapInTableRecord(string) + TBODY_CLOSING;
	}

	public static String wrapInTableRecord(String string) {
		return TR + string + CLOSING_TR;
	}

	public static String wrapInStyledTableCell(String value) {
		return TD_STYLE_BACKGROUND_COLOR + AttributeUtils.getColorByAttribute(value) + CLOSING_STYLE + value
				+ CLOSING_TD;
	}

	public static String wrapInTableHeader(int priority, String string) {
		return "<th " + "data-priority=\"" + priority + 1 + "\">" + string + CLOSING_TH;
	}

	public static String listContains(String selector) {
		return "li:contains(" + selector + ")";
	}

	public static String divContainsOwn(String selector) {
		return "div:containsOwn(" + selector + ")";
	}

	public static String hrefContainsTeam() {
		return "[href*=/team/]";
	}
}
