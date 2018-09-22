package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import maincontainer.MainContainerView;
import manager.MainManager;

public class Main extends Application {

	private static final String CSS = "/css/SoFifa.css";

	@Override
	public void start(Stage primaryStage) {
		try {
			MainContainerView root = new MainContainerView();
			Scene scene = new Scene(root, 800, 400);
			scene.getStylesheets().add(getClass().getResource(CSS).toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icons/trollface.png")));
			primaryStage.setTitle("Talentmanager");
			primaryStage.show();
			new MainManager(root);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
