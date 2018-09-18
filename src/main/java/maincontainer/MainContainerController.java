package maincontainer;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import org.controlsfx.control.MaskerPane;

public class MainContainerController implements Initializable {

	BorderPane mainContainer = new BorderPane();
	@FXML
	MainContainerView rootNode;
	@FXML
	JFXDrawer jfxDrawer;
	@FXML
	MaskerPane maskerPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootNode.setMainContainer(mainContainer);
		rootNode.setDrawer(jfxDrawer);
		maskerPane.visibleProperty().bind(rootNode.showMaskerPaneProperty());
		configureDrawer();
		setListener();
	}

	private void configureDrawer() {
		jfxDrawer.setContent(mainContainer);
		jfxDrawer.setDefaultDrawerSize(250);
		jfxDrawer.setResizeContent(true);
		jfxDrawer.addInitDrawerCallback((param) -> false);
		jfxDrawer.setOverLayVisible(false);
	}

	private void setListener() {
		rootNode.drawerContentProperty().addListener((obs, oldVal, newVal) -> handleDrawerContentChange(newVal));
	}

	private void handleDrawerContentChange(Node newVal) {
		jfxDrawer.getSidePane().clear();
		jfxDrawer.setSidePane(newVal);
	}

}
