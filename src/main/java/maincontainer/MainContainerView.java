package maincontainer;

import javafx.scene.layout.BorderPane;
import utils.FXMLService;

public class MainContainerView extends BorderPane {


	public MainContainerView() {
		FXMLService.load(this);
	}

}
