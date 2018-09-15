package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

import display.PlayerDisplayView;
import input.PlayerEvent;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import objects.CombinedAttribtues;
import objects.Information;
import objects.Player;

public class PlayerManager {

	private PlayerDisplayView playerDisplayView = new PlayerDisplayView();

	public PlayerDisplayView getPlayerDisplayView() {
		return playerDisplayView;
	}

	public void handleNewPlayer(PlayerEvent evt) {
		playerDisplayView.getItems().add(evt.getPlayer());
	}

	public void handleExport() {
		BufferedReader in = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("/html/template.html")));
		String inputLine;
		StringBuffer content = new StringBuffer();
		try {
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			Document document = Jsoup.parse(content.toString());
			Elements playerTable = document.select("#playerTable");
			ObservableList<Player> items = playerDisplayView.getItems();
			generateHeaders(new Player(), playerTable);
			for (Player player : items)
				generateRow(player, playerTable);

			FileChooser fileChooser = new FileChooser();

			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(playerDisplayView.getScene().getWindow());
			if (file != null)
				saveFile(document.toString(), file);
		} catch (IOException e) {
			e.printStackTrace();
		}

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

	private void generateRow(Player player, Elements playerTable) {
		List<Field> fields = new ArrayList<>(Arrays.asList(player.getClass().getDeclaredFields()));
		StringBuilder stringBuilder = new StringBuilder();
		for (Field field : fields) {
			field.setAccessible(true);

			try {
				Object object = ((ObjectProperty<?>) field.get(player)).get();
				if (object instanceof Information) {
					List<Field> informationFields = new ArrayList<>(
							Arrays.asList(((Information) object).getClass().getDeclaredFields()));
					getFields(stringBuilder, object, informationFields);
				}
				if (object instanceof CombinedAttribtues) {
					List<Field> informationFields = new ArrayList<>(
							Arrays.asList(((CombinedAttribtues) object).getClass().getDeclaredFields()));
					getFields(stringBuilder, object, informationFields);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				stringBuilder.append("<td>" + "-" + "</td>");
				e.printStackTrace();
			}
		}
		playerTable.append("<tr>" + stringBuilder.toString() + "</tr>");
	}

	private void getFields(StringBuilder stringBuilder, Object object, List<Field> informationFields)
			throws IllegalAccessException {
		for (Field info : informationFields) {
			info.setAccessible(true);
			String value = ((StringProperty) info.get(object)).get();
			if (value == null)
				value = "-";
			stringBuilder.append("<td>" + value + "</td>");
		}
	}

	private void generateHeaders(Player player, Elements playerTable) {
		List<Field> fields = new ArrayList<>(Arrays.asList(player.getClass().getDeclaredFields()));
		StringBuilder stringBuilder = new StringBuilder();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object object = ((ObjectProperty<?>) field.get(player)).get();
				if (object instanceof Information) {
					List<Field> informationFields = new ArrayList<>(
							Arrays.asList(((Information) object).getClass().getDeclaredFields()));
					for (Field info : informationFields)
						stringBuilder.append("<th>" + info.getName() + "</th>");
				}
				if (object instanceof CombinedAttribtues) {
					List<Field> informationFields = new ArrayList<>(
							Arrays.asList(((CombinedAttribtues) object).getClass().getDeclaredFields()));
					for (Field info : informationFields)
						stringBuilder.append("<th>" + info.getName() + "</th>");
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		playerTable.append("<tr>" + stringBuilder.toString() + "</tr>");
	}

}
