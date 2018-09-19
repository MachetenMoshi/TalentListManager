package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.hildan.fxgson.FxGson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import objects.PlayerAttributes;
import objects.SecondaryInformation;
import objects.CombinedAttributes;
import objects.DetailAttributes;
import objects.Information;
import objects.Player;

public class SoFifaService {
	private static final String baseUrl = "https://sofifa.com/player/";

	public Player loadPlayer(String id) throws Exception {
		Document doc = loadPlayerPage(baseUrl.concat(id));
		Map<String, String> map = new HashMap<>();

		for (String label : PlayerAttributes.labels)
			SoFifaParserService.setEntry(doc, label, map);
		map = SoFifaParserService.setMetaData(doc, map);
		map = SoFifaParserService.setCombinedAttributes(doc, map, id);
		map = SoFifaParserService.setTraits(doc, map);
		map = convertMap(map);
		map.put(PlayerAttributes.ID, id);
		Gson gson = FxGson.coreBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		JsonElement jsonElement = gson.toJsonTree(map);
		DetailAttributes detailAttributes = gson.fromJson(jsonElement, DetailAttributes.class);
		Information information = gson.fromJson(jsonElement, Information.class);
		CombinedAttributes combinedAttribtues = gson.fromJson(jsonElement, CombinedAttributes.class);
		SecondaryInformation secondaryInformation = gson.fromJson(jsonElement, SecondaryInformation.class);
		return new Player(combinedAttribtues, detailAttributes, information, secondaryInformation);
	}

	private static Map<String, String> convertMap(Map<String, String> map) {
		Map<String, String> convertedMap = new HashMap<>();
		map.forEach((k, v) -> {
			String firstChar = k.substring(0, 1);
			convertedMap.put(k.replaceAll("\\s", "").replaceFirst(firstChar, firstChar.toLowerCase()), v);
		});
		return convertedMap;
	}

	private static Document loadPlayerPage(String urlString) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		// Proxy proxy = new Proxy(Proxy.Type.HTTP, new
		// InetSocketAddress("89.40.127.28", 80));
		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), Charset.forName("utf-8")));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();

		return Jsoup.parse(content.toString());
	}

}
