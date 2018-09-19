package utils.controls;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class JFXedDialog extends JFXDialog {

    private ObjectProperty<Node>            contentNode    = new SimpleObjectProperty<>();
    private StringProperty                  title          = new SimpleStringProperty();
    private JFXDialogLayout                 layout;
    private ObjectProperty<List<JFXButton>> controlButtons = new SimpleObjectProperty<>();
    private ObjectProperty<Double>          dialogWidth    = new SimpleObjectProperty<>();
    private ObjectProperty<Double>          dialogHeight   = new SimpleObjectProperty<>();


    public JFXedDialog(StackPane parent, Node contentNode) {
        super(parent, null, DialogTransition.CENTER);
        setContentNode(contentNode);
        setContent(buildLayout());
        registerListener();
    }

    private void registerListener() {
        contentNodeProperty().addListener((obs, oldVal, newVal) -> setNewLayoutBody(newVal));
        controlButtonsProperty().addListener((obs, oldVal, newVal) -> setNewControlButtons(newVal));
        dialogHeightProperty().addListener((obs, oldVal, newVal) -> setNewDialogHeight(newVal));
        dialogWidthProperty().addListener((obs, oldVal, newVal) -> setNewDialogWidth(newVal));
    }

    private void setNewDialogWidth(Double newVal) {
        if (newVal != null) {
            layout.setPrefWidth(newVal);
        }
    }

    private void setNewDialogHeight(Double newVal) {
        if (newVal != null) {
            layout.setPrefHeight(newVal);
        }
    }

    private void setNewLayoutBody(Node newVal) {
        if (newVal != null) {
            layout.setBody(newVal);
        }
    }

    private void setNewControlButtons(List<JFXButton> newVal) {
        if (newVal != null) {
            layout.setActions(getControlButtons());
        }
    }

    private JFXDialogLayout buildLayout() {
        this.layout = new JFXDialogLayout();
        layout.setHeading(buildHeaderLabel());
        setNewLayoutBody(getContentNode());
        setNewControlButtons(getControlButtons());
        return this.layout;
    }

    private Node buildHeaderLabel() {
        Label header = new Label();
        header.textProperty().bind(titleProperty());
        header.setMaxWidth(Double.MAX_VALUE);
        header.getStyleClass().add("label-pane-header");
        return header;
    }

    public final ObjectProperty<Node> contentNodeProperty() {
        return this.contentNode;
    }


    public final Node getContentNode() {
        return this.contentNodeProperty().get();
    }


    public final void setContentNode(final Node contentNode) {
        this.contentNodeProperty().set(contentNode);
    }


    public final StringProperty titleProperty() {
        return this.title;
    }


    public final String getTitle() {
        return this.titleProperty().get();
    }


    public final void setTitle(final String title) {
        this.titleProperty().set(title);
    }


    public final ObjectProperty<List<JFXButton>> controlButtonsProperty() {
        return this.controlButtons;
    }


    public final List<JFXButton> getControlButtons() {
        return this.controlButtonsProperty().get();
    }


    public final void setControlButtons(final List<JFXButton> controlButtons) {
        this.controlButtonsProperty().set(controlButtons);
    }


    public final ObjectProperty<Double> dialogWidthProperty() {
        return this.dialogWidth;
    }


    public final Double getDialogWidth() {
        return this.dialogWidthProperty().get();
    }


    public final void setDialogWidth(final Double dialogWidth) {
        this.dialogWidthProperty().set(dialogWidth);
    }


    public final ObjectProperty<Double> dialogHeightProperty() {
        return this.dialogHeight;
    }


    public final Double getDialogHeight() {
        return this.dialogHeightProperty().get();
    }


    public final void setDialogHeight(final Double dialogHeight) {
        this.dialogHeightProperty().set(dialogHeight);
    }
}
