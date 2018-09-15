package display;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import objects.Player;

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
	TableColumn<Player, String> tcPace;
	@FXML
	TableColumn<Player, String> tcShooting;
	@FXML
	TableColumn<Player, String> tcDribbling;
	@FXML
	TableColumn<Player, String> tcPassing;
	@FXML
	TableColumn<Player, String> tcDefending;
	@FXML
	TableColumn<Player, String> tcPhysical;

	// @formatter:on
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setBindings();

	}

	private void setBindings() {
		tcAge.setCellValueFactory(cellData -> cellData.getValue().getInformation().ageProperty());
		tcName.setCellValueFactory(cellData -> cellData.getValue().getInformation().nameProperty());
		tcPositions.setCellValueFactory(cellData -> cellData.getValue().getInformation().positionsProperty());
		tcOverallRating.setCellValueFactory(cellData -> cellData.getValue().getInformation().overallRatingProperty());
		tcPotential.setCellValueFactory(cellData -> cellData.getValue().getInformation().potentialProperty());
		tcSkillMoves.setCellValueFactory(cellData -> cellData.getValue().getInformation().skillMovesProperty());
		tcWeakFoot.setCellValueFactory(cellData -> cellData.getValue().getInformation().weakFootProperty());
		tcWorkRate.setCellValueFactory(cellData -> cellData.getValue().getInformation().workRateProperty());
		tcJoined.setCellValueFactory(cellData -> cellData.getValue().getInformation().joinedProperty());
		tcLoanedFrom.setCellValueFactory(cellData -> cellData.getValue().getInformation().loanedFromProperty());

		tcPace.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().paceProperty());
		tcDribbling.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().dribblingProperty());
		tcShooting.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().shootingProperty());
		tcDefending.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().defendingProperty());
		tcPhysical.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().physicalProperty());
		tcPassing.setCellValueFactory(cellData -> cellData.getValue().getCombinedAttributes().passingProperty());

	}

}
