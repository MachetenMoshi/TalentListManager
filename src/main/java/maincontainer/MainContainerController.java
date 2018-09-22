package maincontainer;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.MaskerPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import utils.controls.JFXedDrawer;

public class MainContainerController implements Initializable {

	BorderPane mainContainer = new BorderPane();
	@FXML
	MainContainerView rootNode;
	@FXML
	JFXedDrawer jfxDrawer;
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
		jfxDrawer.setResizableOnDrag(false);
		jfxDrawer.setMiniDrawerSize(-1);
		jfxDrawer.setContent(mainContainer);
		jfxDrawer.setDefaultDrawerSize(180);
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
