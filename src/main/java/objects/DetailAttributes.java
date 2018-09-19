package objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DetailAttributes {
	private StringProperty crossing = new SimpleStringProperty();
	private StringProperty finishing = new SimpleStringProperty();
	private StringProperty headingAccuracy = new SimpleStringProperty();
	private StringProperty shortPassing = new SimpleStringProperty();
	private StringProperty volleys = new SimpleStringProperty();
	private StringProperty dribbling = new SimpleStringProperty();
	private StringProperty curve = new SimpleStringProperty();
	private StringProperty fKAccuracy = new SimpleStringProperty();
	private StringProperty longPassing = new SimpleStringProperty();
	private StringProperty ballControl = new SimpleStringProperty();
	private StringProperty acceleration = new SimpleStringProperty();
	private StringProperty sprintSpeed = new SimpleStringProperty();
	private StringProperty agility = new SimpleStringProperty();
	private StringProperty reactions = new SimpleStringProperty();
	private StringProperty balance = new SimpleStringProperty();
	private StringProperty shotPower = new SimpleStringProperty();
	private StringProperty jumping = new SimpleStringProperty();
	private StringProperty stamina = new SimpleStringProperty();
	private StringProperty strength = new SimpleStringProperty();
	private StringProperty longShots = new SimpleStringProperty();
	private StringProperty aggression = new SimpleStringProperty();
	private StringProperty interceptions = new SimpleStringProperty();
	private StringProperty positioning = new SimpleStringProperty();
	private StringProperty vision = new SimpleStringProperty();
	private StringProperty penalties = new SimpleStringProperty();
	private StringProperty composure = new SimpleStringProperty();
	private StringProperty marking = new SimpleStringProperty();
	private StringProperty standingTackle = new SimpleStringProperty();
	private StringProperty slidingTackle = new SimpleStringProperty();
	private StringProperty gKDiving = new SimpleStringProperty();
	private StringProperty gKHandling = new SimpleStringProperty();
	private StringProperty gKKicking = new SimpleStringProperty();
	private StringProperty gKPositioning = new SimpleStringProperty();
	private StringProperty gKReflexes = new SimpleStringProperty();

	public final StringProperty crossingProperty() {
		return this.crossing;
	}

	public final String getCrossing() {
		return this.crossingProperty().get();
	}

	public final void setCrossing(final String crossing) {
		this.crossingProperty().set(crossing);
	}

	public final StringProperty finishingProperty() {
		return this.finishing;
	}

	public final String getFinishing() {
		return this.finishingProperty().get();
	}

	public final void setFinishing(final String finishing) {
		this.finishingProperty().set(finishing);
	}

	public final StringProperty headingAccuracyProperty() {
		return this.headingAccuracy;
	}

	public final String getHeadingAccuracy() {
		return this.headingAccuracyProperty().get();
	}

	public final void setHeadingAccuracy(final String headingAccuracy) {
		this.headingAccuracyProperty().set(headingAccuracy);
	}

	public final StringProperty shortPassingProperty() {
		return this.shortPassing;
	}

	public final String getShortPassing() {
		return this.shortPassingProperty().get();
	}

	public final void setShortPassing(final String shortPassing) {
		this.shortPassingProperty().set(shortPassing);
	}

	public final StringProperty volleysProperty() {
		return this.volleys;
	}

	public final String getVolleys() {
		return this.volleysProperty().get();
	}

	public final void setVolleys(final String volleys) {
		this.volleysProperty().set(volleys);
	}

	public final StringProperty dribblingProperty() {
		return this.dribbling;
	}

	public final String getDribbling() {
		return this.dribblingProperty().get();
	}

	public final void setDribbling(final String dribbling) {
		this.dribblingProperty().set(dribbling);
	}

	public final StringProperty curveProperty() {
		return this.curve;
	}

	public final String getCurve() {
		return this.curveProperty().get();
	}

	public final void setCurve(final String curve) {
		this.curveProperty().set(curve);
	}

	public final StringProperty fKAccuracyProperty() {
		return this.fKAccuracy;
	}

	public final String getFKAccuracy() {
		return this.fKAccuracyProperty().get();
	}

	public final void setFKAccuracy(final String fKAccuracy) {
		this.fKAccuracyProperty().set(fKAccuracy);
	}

	public final StringProperty longPassingProperty() {
		return this.longPassing;
	}

	public final String getLongPassing() {
		return this.longPassingProperty().get();
	}

	public final void setLongPassing(final String longPassing) {
		this.longPassingProperty().set(longPassing);
	}

	public final StringProperty ballControlProperty() {
		return this.ballControl;
	}

	public final String getBallControl() {
		return this.ballControlProperty().get();
	}

	public final void setBallControl(final String ballControl) {
		this.ballControlProperty().set(ballControl);
	}

	public final StringProperty accelerationProperty() {
		return this.acceleration;
	}

	public final String getAcceleration() {
		return this.accelerationProperty().get();
	}

	public final void setAcceleration(final String acceleration) {
		this.accelerationProperty().set(acceleration);
	}

	public final StringProperty sprintSpeedProperty() {
		return this.sprintSpeed;
	}

	public final String getSprintSpeed() {
		return this.sprintSpeedProperty().get();
	}

	public final void setSprintSpeed(final String sprintSpeed) {
		this.sprintSpeedProperty().set(sprintSpeed);
	}

	public final StringProperty agilityProperty() {
		return this.agility;
	}

	public final String getAgility() {
		return this.agilityProperty().get();
	}

	public final void setAgility(final String agility) {
		this.agilityProperty().set(agility);
	}

	public final StringProperty reactionsProperty() {
		return this.reactions;
	}

	public final String getReactions() {
		return this.reactionsProperty().get();
	}

	public final void setReactions(final String reactions) {
		this.reactionsProperty().set(reactions);
	}

	public final StringProperty balanceProperty() {
		return this.balance;
	}

	public final String getBalance() {
		return this.balanceProperty().get();
	}

	public final void setBalance(final String balance) {
		this.balanceProperty().set(balance);
	}

	public final StringProperty shotPowerProperty() {
		return this.shotPower;
	}

	public final String getShotPower() {
		return this.shotPowerProperty().get();
	}

	public final void setShotPower(final String shotPower) {
		this.shotPowerProperty().set(shotPower);
	}

	public final StringProperty jumpingProperty() {
		return this.jumping;
	}

	public final String getJumping() {
		return this.jumpingProperty().get();
	}

	public final void setJumping(final String jumping) {
		this.jumpingProperty().set(jumping);
	}

	public final StringProperty staminaProperty() {
		return this.stamina;
	}

	public final String getStamina() {
		return this.staminaProperty().get();
	}

	public final void setStamina(final String stamina) {
		this.staminaProperty().set(stamina);
	}

	public final StringProperty strengthProperty() {
		return this.strength;
	}

	public final String getStrength() {
		return this.strengthProperty().get();
	}

	public final void setStrength(final String strength) {
		this.strengthProperty().set(strength);
	}

	public final StringProperty longShotsProperty() {
		return this.longShots;
	}

	public final String getLongShots() {
		return this.longShotsProperty().get();
	}

	public final void setLongShots(final String longShots) {
		this.longShotsProperty().set(longShots);
	}

	public final StringProperty aggressionProperty() {
		return this.aggression;
	}

	public final String getAggression() {
		return this.aggressionProperty().get();
	}

	public final void setAggression(final String aggression) {
		this.aggressionProperty().set(aggression);
	}

	public final StringProperty interceptionsProperty() {
		return this.interceptions;
	}

	public final String getInterceptions() {
		return this.interceptionsProperty().get();
	}

	public final void setInterceptions(final String interceptions) {
		this.interceptionsProperty().set(interceptions);
	}

	public final StringProperty positioningProperty() {
		return this.positioning;
	}

	public final String getPositioning() {
		return this.positioningProperty().get();
	}

	public final void setPositioning(final String positioning) {
		this.positioningProperty().set(positioning);
	}

	public final StringProperty visionProperty() {
		return this.vision;
	}

	public final String getVision() {
		return this.visionProperty().get();
	}

	public final void setVision(final String vision) {
		this.visionProperty().set(vision);
	}

	public final StringProperty penaltiesProperty() {
		return this.penalties;
	}

	public final String getPenalties() {
		return this.penaltiesProperty().get();
	}

	public final void setPenalties(final String penalties) {
		this.penaltiesProperty().set(penalties);
	}

	public final StringProperty composureProperty() {
		return this.composure;
	}

	public final String getComposure() {
		return this.composureProperty().get();
	}

	public final void setComposure(final String composure) {
		this.composureProperty().set(composure);
	}

	public final StringProperty markingProperty() {
		return this.marking;
	}

	public final String getMarking() {
		return this.markingProperty().get();
	}

	public final void setMarking(final String marking) {
		this.markingProperty().set(marking);
	}

	public final StringProperty standingTackleProperty() {
		return this.standingTackle;
	}

	public final String getStandingTackle() {
		return this.standingTackleProperty().get();
	}

	public final void setStandingTackle(final String standingTackle) {
		this.standingTackleProperty().set(standingTackle);
	}

	public final StringProperty slidingTackleProperty() {
		return this.slidingTackle;
	}

	public final String getSlidingTackle() {
		return this.slidingTackleProperty().get();
	}

	public final void setSlidingTackle(final String slidingTackle) {
		this.slidingTackleProperty().set(slidingTackle);
	}

	public final StringProperty gKDivingProperty() {
		return this.gKDiving;
	}

	public final String getGKDiving() {
		return this.gKDivingProperty().get();
	}

	public final void setGKDiving(final String gKDiving) {
		this.gKDivingProperty().set(gKDiving);
	}

	public final StringProperty gKHandlingProperty() {
		return this.gKHandling;
	}

	public final String getGKHandling() {
		return this.gKHandlingProperty().get();
	}

	public final void setGKHandling(final String gKHandling) {
		this.gKHandlingProperty().set(gKHandling);
	}

	public final StringProperty gKKickingProperty() {
		return this.gKKicking;
	}

	public final String getGKKicking() {
		return this.gKKickingProperty().get();
	}

	public final void setGKKicking(final String gKKicking) {
		this.gKKickingProperty().set(gKKicking);
	}

	public final StringProperty gKPositioningProperty() {
		return this.gKPositioning;
	}

	public final String getGKPositioning() {
		return this.gKPositioningProperty().get();
	}

	public final void setGKPositioning(final String gKPositioning) {
		this.gKPositioningProperty().set(gKPositioning);
	}

	public final StringProperty gKReflexesProperty() {
		return this.gKReflexes;
	}

	public final String getGKReflexes() {
		return this.gKReflexesProperty().get();
	}

	public final void setGKReflexes(final String gKReflexes) {
		this.gKReflexesProperty().set(gKReflexes);
	}

}
