package display;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
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
	TableColumn<Player, String> tcCrossing;
	@FXML
	TableColumn<Player, String> tcFinishing;
	@FXML
	TableColumn<Player, String> tcHeadingAccuracy;
	@FXML
	TableColumn<Player, String> tcShortPassing;
	@FXML
	TableColumn<Player, String> tcVolleys;
	@FXML
	TableColumn<Player, String> tcDribbling;
	@FXML
	TableColumn<Player, String> tcCurve;
	@FXML
	TableColumn<Player, String> tcFKAccuracy;
	@FXML
	TableColumn<Player, String> tcLongPassing;
	@FXML
	TableColumn<Player, String> tcBallControl;
	@FXML
	TableColumn<Player, String> tcAcceleration;
	@FXML
	TableColumn<Player, String> tcSprintSpeed;
	@FXML
	TableColumn<Player, String> tcAgility;
	@FXML
	TableColumn<Player, String> tcReactions;
	@FXML
	TableColumn<Player, String> tcBalance;
	@FXML
	TableColumn<Player, String> tcShotPower;
	@FXML
	TableColumn<Player, String> tcJumping;
	@FXML
	TableColumn<Player, String> tcStamina;
	@FXML
	TableColumn<Player, String> tcStrength;
	@FXML
	TableColumn<Player, String> tcLongShots;
	@FXML
	TableColumn<Player, String> tcAggression;
	@FXML
	TableColumn<Player, String> tcInterceptions;
	@FXML
	TableColumn<Player, String> tcPositioning;
	@FXML
	TableColumn<Player, String> tcVision;
	@FXML
	TableColumn<Player, String> tcPenalties;
	@FXML
	TableColumn<Player, String> tcComposure;
	@FXML
	TableColumn<Player, String> tcMarking;
	@FXML
	TableColumn<Player, String> tcStandingTackle;
	@FXML
	TableColumn<Player, String> tcSlidingTackle;
	@FXML
	TableColumn<Player, String> tcGKDiving;
	@FXML
	TableColumn<Player, String> tcGKHandling;
	@FXML
	TableColumn<Player, String> tcGKKicking;
	@FXML
	TableColumn<Player, String> tcGKPositioning;
	@FXML
	TableColumn<Player, String> tcGKReflexes;
	@FXML
	TableColumn<Player, String> tcWorkRate;
	@FXML
	TableColumn<Player, String> tcJoined;
	@FXML
	TableColumn<Player, String> tcLoanedFrom;

	// @formatter:on
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setBindings();

	}

	private void setBindings() {
		tcAge.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
		tcName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		tcPositions.setCellValueFactory(cellData -> cellData.getValue().positionsProperty());
		tcOverallRating.setCellValueFactory(cellData -> cellData.getValue().overallRatingProperty());
		tcPotential.setCellValueFactory(cellData -> cellData.getValue().potentialProperty());
		tcSkillMoves.setCellValueFactory(cellData -> cellData.getValue().skillMovesProperty());
		tcWeakFoot.setCellValueFactory(cellData -> cellData.getValue().weakFootProperty());
		tcCrossing.setCellValueFactory(cellData -> cellData.getValue().crossingProperty());
		tcFinishing.setCellValueFactory(cellData -> cellData.getValue().finishingProperty());
		tcHeadingAccuracy.setCellValueFactory(cellData -> cellData.getValue().headingAccuracyProperty());
		tcShortPassing.setCellValueFactory(cellData -> cellData.getValue().shortPassingProperty());
		tcVolleys.setCellValueFactory(cellData -> cellData.getValue().volleysProperty());
		tcDribbling.setCellValueFactory(cellData -> cellData.getValue().dribblingProperty());
		tcCurve.setCellValueFactory(cellData -> cellData.getValue().curveProperty());
		tcFKAccuracy.setCellValueFactory(cellData -> cellData.getValue().fKAccuracyProperty());
		tcLongPassing.setCellValueFactory(cellData -> cellData.getValue().longPassingProperty());
		tcBallControl.setCellValueFactory(cellData -> cellData.getValue().ballControlProperty());
		tcAcceleration.setCellValueFactory(cellData -> cellData.getValue().accelerationProperty());
		tcSprintSpeed.setCellValueFactory(cellData -> cellData.getValue().sprintSpeedProperty());
		tcAgility.setCellValueFactory(cellData -> cellData.getValue().agilityProperty());
		tcReactions.setCellValueFactory(cellData -> cellData.getValue().reactionsProperty());
		tcBalance.setCellValueFactory(cellData -> cellData.getValue().balanceProperty());
		tcShotPower.setCellValueFactory(cellData -> cellData.getValue().shotPowerProperty());
		tcJumping.setCellValueFactory(cellData -> cellData.getValue().jumpingProperty());
		tcStamina.setCellValueFactory(cellData -> cellData.getValue().staminaProperty());
		tcStrength.setCellValueFactory(cellData -> cellData.getValue().strengthProperty());
		tcLongShots.setCellValueFactory(cellData -> cellData.getValue().longShotsProperty());
		tcAggression.setCellValueFactory(cellData -> cellData.getValue().aggressionProperty());
		tcInterceptions.setCellValueFactory(cellData -> cellData.getValue().interceptionsProperty());
		tcPositioning.setCellValueFactory(cellData -> cellData.getValue().positioningProperty());
		tcVision.setCellValueFactory(cellData -> cellData.getValue().visionProperty());
		tcPenalties.setCellValueFactory(cellData -> cellData.getValue().penaltiesProperty());
		tcComposure.setCellValueFactory(cellData -> cellData.getValue().composureProperty());
		tcMarking.setCellValueFactory(cellData -> cellData.getValue().markingProperty());
		tcStandingTackle.setCellValueFactory(cellData -> cellData.getValue().standingTackleProperty());
		tcSlidingTackle.setCellValueFactory(cellData -> cellData.getValue().slidingTackleProperty());
		tcGKDiving.setCellValueFactory(cellData -> cellData.getValue().gKDivingProperty());
		tcGKHandling.setCellValueFactory(cellData -> cellData.getValue().gKHandlingProperty());
		tcGKKicking.setCellValueFactory(cellData -> cellData.getValue().gKKickingProperty());
		tcGKPositioning.setCellValueFactory(cellData -> cellData.getValue().gKPositioningProperty());
		tcGKReflexes.setCellValueFactory(cellData -> cellData.getValue().gKReflexesProperty());
		tcWorkRate.setCellValueFactory(cellData -> cellData.getValue().workRateProperty());
		tcJoined.setCellValueFactory(cellData -> cellData.getValue().joinedProperty());
		tcLoanedFrom.setCellValueFactory(cellData -> cellData.getValue().loanedFromProperty());
	}

}
