package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import maincontainer.MainContainerView;
import manager.MainManager;

public class Main extends Application {

	
	@Override
	public void start(Stage primaryStage) {
		try {
			MainContainerView root = new MainContainerView();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/css/SoFifa.css").toExternalForm());
			primaryStage.setScene(scene);
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
