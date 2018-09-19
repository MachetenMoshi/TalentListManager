package maincontainer;

import com.jfoenix.controls.JFXDrawer;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import utils.FXMLService;
import utils.controls.JFXedDrawer;

public class MainContainerView extends StackPane {

	private ObjectProperty<BorderPane> mainContainer = new SimpleObjectProperty<>();
	private ObjectProperty<Node> drawerContent = new SimpleObjectProperty<>();
	private ObjectProperty<JFXedDrawer> drawer = new SimpleObjectProperty<>();
	private BooleanProperty showMaskerPane = new SimpleBooleanProperty(false);

	public MainContainerView() {
		FXMLService.load(this);
	}

	final ObjectProperty<BorderPane> mainContainerProperty() {
		return this.mainContainer;
	}

	final BorderPane getMainContainer() {
		return this.mainContainerProperty().get();
	}

	final void setMainContainer(final BorderPane mainContainer) {
		this.mainContainerProperty().set(mainContainer);
	}

	public void setTop(Node node) {
		getMainContainer().setTop(node);
	}

	public void setCenter(Node node) {
		getMainContainer().setCenter(node);
	}

	public final ObjectProperty<Node> drawerContentProperty() {
		return this.drawerContent;
	}

	public final Node getDrawerContent() {
		return this.drawerContentProperty().get();
	}

	public final void setDrawerContent(final Node drawerContent) {
		this.drawerContentProperty().set(drawerContent);
	}

	final ObjectProperty<JFXedDrawer> drawerProperty() {
		return this.drawer;
	}

	public final JFXedDrawer getDrawer() {
		return this.drawerProperty().get();
	}

	final void setDrawer(final JFXedDrawer drawer) {
		this.drawerProperty().set(drawer);
	}

	public final BooleanProperty showMaskerPaneProperty() {
		return this.showMaskerPane;
	}

	public final boolean isShowMaskerPane() {
		return this.showMaskerPaneProperty().get();
	}

	public final void setShowMaskerPane(final boolean showMaskerPane) {
		this.showMaskerPaneProperty().set(showMaskerPane);
	}

}
