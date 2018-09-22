package utils;

import java.util.Arrays;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;


import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.PopupWindow.AnchorLocation;
import javafx.stage.Window;
import utils.controls.JFXedDialog;

public class DialogBuilder {

    private static final String           PIW_DIALOGS_CLOSE                                   = "piw.dialogs.CLOSE";
    private static final String           PIW_DIALOGS_OK                                      = "piw.dialogs.OK";
    private static final String           PIW_DIALOGS_ADD                                     = "piw.dialogs.ADD";
    private static final String           APPOINTMENT_APPOINTMENT_CREATION_VIEW_CSS           = "/com/preag/app/mirendapiw/appointment/AppointmentCreationView.css";
    private static final String           CORRESPONDENCE_CORRESPONDENCE_CONTAINER_VIEW_CSS    = "/com/preag/app/mirendapiw/correspondence/CorrespondenceContainerView.css";
    private static final String           CONTACTCREATION_CONTACT_CREATION_CONTAINER_VIEW_CSS = "/com/preag/app/mirendapiw/contactcreation/ContactCreationContainerView.css";
    private static final String           CUSTOM_DIALOG                                       = "custom-dialog";
    private static final String           BORDER_BUTTON                                       = "border-button";
    private static final DialogBuilder DIALOGBUILDER                                       = new DialogBuilder();

    private DialogBuilder() {

    }

    public static DialogBuilder getInstance() {
        return DIALOGBUILDER;
    }



    /*----------------------------
     * JFoenix Dialogs
     *----------------------------*/

    

 

    public JFXedDialog reallyAddPartnerDialog(StackPane rootNode, EventHandler<ActionEvent> actionEvent) {
        Label content = new Label("");
//
//        JFXButton addButton = new JFXButton(Localization.asKey(PIW_DIALOGS_ADD));
//        JFXButton cancelButton = new JFXButton(Localization.asKey(PIW_DIALOGS_CLOSE));

        JFXedDialog dialog = new JFXedDialog(rootNode, content);
//        dialog.setTitle(Localization.asKey("piw.dialogs.addPartnerHeader"));
//        dialog.setControlButtons(Arrays.asList(addButton, cancelButton));
//        dialog.setDialogWidth(400d);
//
//        cancelButton.setOnAction(evt -> dialog.close());
//        addButton.setOnAction(actionEvent);
        return dialog;
    }

    /*----------------------------
     * JavaFX Dialogs
     *----------------------------*/




    public Dialog<ButtonType> noButtonDialog(String title, Node content, Window owner) {
        Dialog<ButtonType> customDialog = new Dialog<>();
        customDialog.getDialogPane().getStyleClass().add(CUSTOM_DIALOG);
        customDialog.initModality(Modality.APPLICATION_MODAL);
        customDialog.setResizable(true);
        customDialog.setTitle(title);
        customDialog.getDialogPane().setContent(content);
        customDialog.initOwner(owner);

        Window dialogWindow = customDialog.getDialogPane().getScene().getWindow();
        dialogWindow.setOnCloseRequest(evt -> dialogWindow.hide());
        return customDialog;
    }

    public Dialog<ButtonType> createOkDialog(String title, Node content, Window owner) {
        Dialog<ButtonType> customDialog = noButtonDialog(title, content, owner);
        customDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
        Button lookupButton = (Button) customDialog.getDialogPane().lookupButton(ButtonType.OK);
        lookupButton.getStyleClass().add(BORDER_BUTTON);
        lookupButton.setDefaultButton(true);
        return customDialog;
    }

    public Dialog<ButtonType> applyCancelDialog(String title, Node content, Window owner) {
        Dialog<ButtonType> customDialog = noButtonDialog(title, content, owner);
        customDialog.getDialogPane().getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);
        Button lookupButton = (Button) customDialog.getDialogPane().lookupButton(ButtonType.CANCEL);
        lookupButton.getStyleClass().add(BORDER_BUTTON);
        lookupButton.setDefaultButton(true);

        Button applyButton = (Button) customDialog.getDialogPane().lookupButton(ButtonType.APPLY);
        applyButton.getStyleClass().add(BORDER_BUTTON);
        return customDialog;
    }


    public Dialog<ButtonType> confirmDialog(String title, String headerText, String contentText, Window owner) {
        Dialog<ButtonType> customDialog = new Dialog<>();
        customDialog.getDialogPane().getStyleClass().add(CUSTOM_DIALOG);
        customDialog.initModality(Modality.APPLICATION_MODAL);
        customDialog.setResizable(true);
        customDialog.setTitle(title);
        customDialog.setHeaderText(headerText);
        customDialog.setContentText(contentText);
        customDialog.initOwner(owner);
        customDialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        Button lookupButton = (Button) customDialog.getDialogPane().lookupButton(ButtonType.OK);
        lookupButton.getStyleClass().add(BORDER_BUTTON);
        lookupButton.setDefaultButton(true);
        Window dialogWindow = customDialog.getDialogPane().getScene().getWindow();
        dialogWindow.setOnCloseRequest(evt -> {
            dialogWindow.hide();
        });
        return customDialog;
    }

    public Dialog<ButtonType> buildYesNoDialog(String titleString, String contentString, Window owner) {
        Dialog<ButtonType> customDialog = new Dialog<>();
        Label content = new Label(contentString);
        customDialog.getDialogPane().setContent(content);
        customDialog.initModality(Modality.APPLICATION_MODAL);
        customDialog.setTitle(titleString);
        customDialog.initOwner(owner);
        customDialog.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        Button lookupButtonNo = (Button) customDialog.getDialogPane().lookupButton(ButtonType.NO);
        lookupButtonNo.setDefaultButton(true);
        Window dialogWindow = customDialog.getDialogPane().getScene().getWindow();
        dialogWindow.setOnCloseRequest(evt -> {
            dialogWindow.hide();
        });
        return customDialog;
    }

    public Dialog<ButtonType> missingDataDialog(String title, String headerText, Node content, Window owner) {
        Dialog<ButtonType> customDialog = new Dialog<>();
        customDialog.getDialogPane().getStyleClass().add(CUSTOM_DIALOG);
        customDialog.initModality(Modality.APPLICATION_MODAL);
        customDialog.setResizable(true);
        customDialog.setTitle(title);
        customDialog.setHeaderText(headerText);
        customDialog.getDialogPane().setContent(content);
        customDialog.initOwner(owner);
        customDialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        Button lookupButton = (Button) customDialog.getDialogPane().lookupButton(ButtonType.OK);
        lookupButton.getStyleClass().add(BORDER_BUTTON);
        lookupButton.setDefaultButton(true);
        Window dialogWindow = customDialog.getDialogPane().getScene().getWindow();
        dialogWindow.setOnCloseRequest(evt -> {
            dialogWindow.hide();
        });
        return customDialog;
    }


}
