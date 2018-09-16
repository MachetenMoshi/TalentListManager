package manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import display.PlayerDisplayView;
import drawercontent.fileselector.FileSelectorEvent;
import input.PlayerEvent;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import objects.Player;
import services.FileParserService;
import services.SoFifaService;
import utils.HtmlUtils;
import utils.StringUtils;

public class PlayerManager {

	private PlayerDisplayView playerDisplayView = new PlayerDisplayView();

	public PlayerDisplayView getPlayerDisplayView() {
		return playerDisplayView;
	}

	public void handleNewPlayer(PlayerEvent evt) {
		playerDisplayView.getItems().add(evt.getPlayer());
	}

	public void handleExport() {
		StringBuffer content = StringUtils
				.getContent(new InputStreamReader(getClass().getResourceAsStream(HtmlUtils.TEMPLATE_PATH)));
		Document document = FileParserService.generateHtmlFile(Jsoup.parse(content.toString()),
				playerDisplayView.getItems());
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(HtmlUtils.HTML_FILTER_NAME,
				HtmlUtils.HTML_FILTER_VALUE);
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showSaveDialog(playerDisplayView.getScene().getWindow());
		if (file != null)
			saveFile(document.toString(), file);

	}

	private void saveFile(String content, File file) {
		try {
			FileWriter fileWriter = null;
			fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void handleFile(FileSelectorEvent evt) {
		List<Player> players = FileParserService.handleFile(evt);
		playerDisplayView.getItems().setAll(players);
	}

	public void updatePlayers() {
		ObservableList<Player> items = playerDisplayView.getItems();
		SoFifaService soFifaService = new SoFifaService();
		List<Player> updatedPlayers = new ArrayList<>();
		for (Player player : items) {
			try {
				Player updatedPlayer = soFifaService.loadPlayer(player.getInformation().getId());
				if (updatedPlayer != null)
					updatedPlayer.getInformation().setComment(player.getInformation().getComment());
				updatedPlayers.add(updatedPlayer);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<Player> notUpdated = items.stream().filter(p -> !updatedPlayers.contains(p)).collect(Collectors.toList());
		updatedPlayers.addAll(notUpdated);
		playerDisplayView.getItems().setAll(updatedPlayers);

	}

}
