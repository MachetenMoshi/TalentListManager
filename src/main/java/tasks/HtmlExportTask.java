package tasks;

import java.io.InputStreamReader;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javafx.concurrent.Task;
import objects.Player;
import services.FileParserService;
import utils.HtmlUtils;
import utils.StringUtils;

public class HtmlExportTask extends Task<Document> {

	private List<Player> players;

	public HtmlExportTask(List<Player> players) {
		this.players = players;
	}

	@Override
	protected Document call() throws Exception {
		StringBuffer content = StringUtils
				.getContent(new InputStreamReader(getClass().getResourceAsStream(HtmlUtils.TEMPLATE_PATH)));
		return FileParserService.generateHtmlFile(Jsoup.parse(content.toString()), players, true);
	}

}
