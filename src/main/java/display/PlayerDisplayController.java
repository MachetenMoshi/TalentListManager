package display;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.sun.javafx.scene.control.SelectedCellsMap;

import controlbar.ControlBarEvent;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import objects.Player;
import utils.cellfactories.AttributeCellFactory;

public class PlayerDisplayController implements Initializable {
	// @formatter: off
	@FXML
	PlayerDisplayView rootNode;
	@FXML
	TableColumn<Player, String> tcAge;
	@FXML
	TableColumn<Player, String> tcName;
	@FXML
	TableColumn<Player, String> tcPositions;
	@FXML
	TableColumn<Player, String> tcOverallRating;
	@FXML
	TableColumn<Player, String> tcPotential;
	@FXML
	TableColumn<Player, String> tcSkillMoves;
	@FXML
	TableColumn<Player, String> tcWeakFoot;
	@FXML
	TableColumn<Player, String> tcWorkRate;
	@FXML
	TableColumn<Player, String> tcJoined;
	@FXML
	TableColumn<Player, String> tcLoanedFrom;
	@FXML
	TableColumn<Player, String> tcCombinedFirst;
	@FXML
	TableColumn<Player, String> tcCombinedThird;
	@FXML
	TableColumn<Player, String> tcCombinedSecond;
	@FXML
	TableColumn<Player, String> tcCombinedSixth;
	@FXML
	TableColumn<Player, String> tcCombinedFourth;
	@FXML
	TableColumn<Player, String> tcCombinedFifth;
	@FXML
	TableColumn<Player, String> tcPreferredFoot;
	@FXML
	TableColumn<Player, String> tcTeam;

	// @formatter:on
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setCellFactories();
		setBindings();
		rootNode.getItems()
				.addListener((ListChangeListener.Change<? extends Player> c) -> handleListChange(rootNode.getItems()));

		setContextMenu();

	}

	private void setContextMenu() {
		JFXButton btnDelete = new JFXButton("Löschen");
		JFXPopup popup = new JFXPopup(btnDelete);
		btnDelete.setOnAction(evt -> handleOnDelete(evt, popup));
		rootNode.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				if (t.getButton() == MouseButton.SECONDARY)
					popup.show(rootNode, PopupVPosition.TOP, PopupHPosition.LEFT, t.getSceneX(), t.getSceneY() - 35);
			}
		});

	}

	private void handleOnDelete(ActionEvent evt, JFXPopup popup) {
		if (rootNode.getSelectionModel().getSelectedItem() != null)
			rootNode.getItems().remove(rootNode.getSelectionModel().getSelectedItem());
		popup.hide();

	}

	private void handleListChange(ObservableList<Player> items) {
		boolean allKeepers = items.stream().allMatch(p -> p.getInformation().getPositions().contains("GK"));
		if (allKeepers) {
			tcCombinedFirst.setText("Hechten");
			tcCombinedSecond.setText("Fangsicherheit");
			tcCombinedThird.setText("Abschlag");
			tcCombinedFourth.setText("Reflexe");
			tcCombinedFifth.setText("Geschwindigkeit");
			tcCombinedSixth.setText("Stellungsspiel");
		} else {
			tcCombinedFirst.setText("Geschwindigkeit");
			tcCombinedSecond.setText("Schießen");
			tcCombinedThird.setText("Passen");
			tcCombinedFourth.setText("Dribbling");
			tcCombinedFifth.setText("Verteidigung");
			tcCombinedSixth.setText("Physis");
		}

	}

	private void setCellFactories() {
		tcCombinedFirst.setCellFactory(new AttributeCellFactory());
		tcCombinedSecond.setCellFactory(new AttributeCellFactory());
		tcCombinedThird.setCellFactory(new AttributeCellFactory());
		tcCombinedFourth.setCellFactory(new AttributeCellFactory());
		tcCombinedFifth.setCellFactory(new AttributeCellFactory());
		tcCombinedSixth.setCellFactory(new AttributeCellFactory());
		tcOverallRating.setCellFactory(new AttributeCellFactory());
		tcPotential.setCellFactory(new AttributeCellFactory());
	}

	private void setBindings() {
		tcAge.setCellValueFactory(cellData -> cellData.getValue().getInformation().ageProperty());
		tcName.setCellValueFactory(cellData -> cellData.getValue().getInformation().nameProperty());
		tcTeam.setCellValueFactory(cellData -> cellData.getValue().getInformation().teamProperty());
		tcPositions.setCellValueFactory(cellData -> cellData.getValue().getInformation().positionsProperty());
		tcOverallRating.setCellValueFactory(cellData -> cellData.getValue().getInformation().overallRatingProperty());
		tcPotential.setCellValueFactory(cellData -> cellData.getValue().getInformation().potentialProperty());
		tcSkillMoves.setCellValueFactory(cellData -> cellData.getValue().getInformation().skillMovesProperty());
		tcWeakFoot.setCellValueFactory(cellData -> cellData.getValue().getInformation().weakFootProperty());
		tcPreferredFoot.setCellValueFactory(cellData -> cellData.getValue().getInformation().preferredFootProperty());
		tcWorkRate.setCellValueFactory(cellData -> cellData.getValue().getInformation().workRateProperty());
		tcJoined.setCellValueFactory(cellData -> cellData.getValue().getInformation().joinedProperty());
		tcLoanedFrom.setCellValueFactory(cellData -> cellData.getValue().getInformation().loanedFromProperty());

		tcCombinedFirst
				.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().firstAttributeProperty());
		tcCombinedSecond
				.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().secondAttributeProperty());
		tcCombinedThird
				.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().thirdAttributeProperty());
		tcCombinedFourth
				.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().fourthAttributeProperty());
		tcCombinedFifth
				.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().fifthAttributeProperty());
		tcCombinedSixth
				.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().sixthAttributeProperty());

	}

}
