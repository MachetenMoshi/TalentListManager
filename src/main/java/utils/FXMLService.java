package utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class FXMLService {

	public static void load(Object object) {
		try {
			FXMLLoader loader = new FXMLLoader();
			String pathToThis = getPathToThis(object);
			loader.setLocation(object.getClass().getResource(pathToThis));
			// loader.setResources(ResourceBundle.getBundle("bundle.helloWorld"));
			loader.setRoot(object);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getPathToThis(Object object) {
		return "/" + object.getClass().getName().replace(".", "/") + ".fxml";
	}
}
