package maincontainer;

import com.jfoenix.controls.JFXDrawer;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import utils.FXMLService;

public class MainContainerView extends StackPane {

	private ObjectProperty<BorderPane> mainContainer = new SimpleObjectProperty<>();
	private ObjectProperty<Node> drawerContent = new SimpleObjectProperty<>();
	private ObjectProperty<JFXDrawer> drawer = new SimpleObjectProperty<>();

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

	final ObjectProperty<JFXDrawer> drawerProperty() {
		return this.drawer;
	}

	public final JFXDrawer getDrawer() {
		return this.drawerProperty().get();
	}

	final void setDrawer(final JFXDrawer drawer) {
		this.drawerProperty().set(drawer);
	}

}
