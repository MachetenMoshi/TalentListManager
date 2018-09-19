package objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Information {
	private StringProperty name = new SimpleStringProperty();
	private StringProperty age = new SimpleStringProperty();
	private StringProperty positions = new SimpleStringProperty();
	private StringProperty overallRating = new SimpleStringProperty();
	private StringProperty potential = new SimpleStringProperty();
	private StringProperty team = new SimpleStringProperty();
	private StringProperty joined = new SimpleStringProperty();
	private StringProperty height = new SimpleStringProperty();
	private StringProperty weight = new SimpleStringProperty();
	private StringProperty skillMoves = new SimpleStringProperty();
	private StringProperty weakFoot = new SimpleStringProperty();
	private StringProperty preferredFoot = new SimpleStringProperty();
	private StringProperty workRate = new SimpleStringProperty();
	private StringProperty loanedFrom = new SimpleStringProperty();
	private StringProperty comment = new SimpleStringProperty();
	private StringProperty id = new SimpleStringProperty();

	public final StringProperty ageProperty() {
		return this.age;
	}

	public final String getAge() {
		return this.ageProperty().get();
	}

	public final void setAge(final String age) {
		this.ageProperty().set(age);
	}

	public final StringProperty nameProperty() {
		return this.name;
	}

	public final String getName() {
		return this.nameProperty().get();
	}

	public final void setName(final String name) {
		this.nameProperty().set(name);
	}

	public final StringProperty positionsProperty() {
		return this.positions;
	}

	public final String getPositions() {
		return this.positionsProperty().get();
	}

	public final void setPositions(final String positions) {
		this.positionsProperty().set(positions);
	}

	public final StringProperty overallRatingProperty() {
		return this.overallRating;
	}

	public final String getOverallRating() {
		return this.overallRatingProperty().get();
	}

	public final void setOverallRating(final String overallRating) {
		this.overallRatingProperty().set(overallRating);
	}

	public final StringProperty potentialProperty() {
		return this.potential;
	}

	public final String getPotential() {
		return this.potentialProperty().get();
	}

	public final void setPotential(final String potential) {
		this.potentialProperty().set(potential);
	}

	public final StringProperty skillMovesProperty() {
		return this.skillMoves;
	}

	public final String getSkillMoves() {
		return this.skillMovesProperty().get();
	}

	public final void setSkillMoves(final String skillMoves) {
		this.skillMovesProperty().set(skillMoves);
	}

	public final StringProperty weakFootProperty() {
		return this.weakFoot;
	}

	public final String getWeakFoot() {
		return this.weakFootProperty().get();
	}

	public final void setWeakFoot(final String weakFoot) {
		this.weakFootProperty().set(weakFoot);
	}

	public final StringProperty workRateProperty() {
		return this.workRate;
	}

	public final String getWorkRate() {
		return this.workRateProperty().get();
	}

	public final void setWorkRate(final String workRate) {
		this.workRateProperty().set(workRate);
	}

	public final StringProperty joinedProperty() {
		return this.joined;
	}

	public final String getJoined() {
		return this.joinedProperty().get();
	}

	public final void setJoined(final String joined) {
		this.joinedProperty().set(joined);
	}

	public final StringProperty loanedFromProperty() {
		return this.loanedFrom;
	}

	public final String getLoanedFrom() {
		return this.loanedFromProperty().get();
	}

	public final void setLoanedFrom(final String loanedFrom) {
		this.loanedFromProperty().set(loanedFrom);
	}

	public final StringProperty commentProperty() {
		return this.comment;
	}

	public final String getComment() {
		return this.commentProperty().get();
	}

	public final void setComment(final String comment) {
		this.commentProperty().set(comment);
	}

	public final StringProperty idProperty() {
		return this.id;
	}

	public final String getId() {
		return this.idProperty().get();
	}

	public final void setId(final String id) {
		this.idProperty().set(id);
	}

	public final StringProperty preferredFootProperty() {
		return this.preferredFoot;
	}

	public final String getPreferredFoot() {
		return this.preferredFootProperty().get();
	}

	public final void setPreferredFoot(final String preferredFoot) {
		this.preferredFootProperty().set(preferredFoot);
	}

	public final StringProperty teamProperty() {
		return this.team;
	}

	public final String getTeam() {
		return this.teamProperty().get();
	}

	public final void setTeam(final String team) {
		this.teamProperty().set(team);
	}

	public final StringProperty heightProperty() {
		return this.height;
	}

	public final String getHeight() {
		return this.heightProperty().get();
	}

	public final void setHeight(final String height) {
		this.heightProperty().set(height);
	}

	public final StringProperty weightProperty() {
		return this.weight;
	}

	public final String getWeight() {
		return this.weightProperty().get();
	}

	public final void setWeight(final String weight) {
		this.weightProperty().set(weight);
	}

}
