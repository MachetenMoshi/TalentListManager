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

import controlbar.ControlBarEvent;
import display.PlayerDisplayView;
import drawercontent.fileselector.FileSelectorEvent;
import input.PlayerEvent;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.stage.FileChooser;
import javafx.util.Pair;
import objects.Player;
import services.FileParserService;
import services.SoFifaService;
import tasks.HtmlExportTask;
import tasks.PlayerLoadingTask;
import tasks.PlayerUpdateTask;
import utils.HtmlUtils;
import utils.StringUtils;
import utils.TaskManager;

public class PlayerManager {

	private PlayerDisplayView playerDisplayView = new PlayerDisplayView();
	private TaskManager taskManager;
	private String header = "";

	public PlayerDisplayView getPlayerDisplayView() {
		return playerDisplayView;
	}

	public void handleNewPlayer(Player newVal) {
		playerDisplayView.getItems().add(newVal);
	}

	public void handleExport(ControlBarEvent evt) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(HtmlUtils.HTML_FILTER_NAME,
				HtmlUtils.HTML_FILTER_VALUE);
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showSaveDialog(playerDisplayView.getScene().getWindow());
		if (file != null) {
			HtmlExportTask exportTask = new HtmlExportTask(playerDisplayView.getItems(), evt.getExportHeader());
			exportTask.valueProperty().addListener((obs, oldVal, newVal) -> handleExport(newVal, file));
			taskManager.addTask(exportTask);
		}
	}

	private void handleExport(Document content, File file) {
		try {
			FileWriter fileWriter = null;
			fileWriter = new FileWriter(file);
			fileWriter.write(content.toString());
			fileWriter.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void handleFile(FileSelectorEvent evt) {
		Pair<String, List<Player>> players = FileParserService.handleFile(evt);
		playerDisplayView.fireEvent(new FileSelectorEvent(FileSelectorEvent.ON_NEW_HEADER, players.getKey()));
		playerDisplayView.getItems().setAll(players.getValue());
	}

	public void updatePlayers() {
		ObservableList<Player> items = playerDisplayView.getItems();
		PlayerUpdateTask playerUpdateTask = new PlayerUpdateTask(items);
		playerUpdateTask.valueProperty().addListener((obs, oldVal, newVal) -> handleUpdatedPlayers(items, newVal));
		taskManager.addTask(playerUpdateTask);
	}

	private void handleUpdatedPlayers(ObservableList<Player> items, List<Player> updatedPlayers) {
		List<Player> notUpdated = items.stream().filter(p -> !updatedPlayers.contains(p)).collect(Collectors.toList());
		updatedPlayers.addAll(notUpdated);
		playerDisplayView.getItems().setAll(updatedPlayers);
	}

	public void setTaskManager(TaskManager taskManager) {
		this.taskManager = taskManager;

	}

	public void addPlayer(PlayerEvent evt) {
		PlayerLoadingTask playerLoadingTask = new PlayerLoadingTask(evt.getId());
		playerLoadingTask.valueProperty().addListener((obs, oldVal, newVal) -> {
			newVal.getInformation().setComment(evt.getComment());
			handleNewPlayer(newVal);
		});
		taskManager.addTask(playerLoadingTask);
	}

}
