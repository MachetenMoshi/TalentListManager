package maincontainer;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class MainContainerView extends BorderPane {

	private static final String FXML = "/maincontainer/MainContainerView.fxml";

	public MainContainerView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(FXML));
			// loader.setResources(ResourceBundle.getBundle("bundle.helloWorld"));
			loader.setRoot(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
