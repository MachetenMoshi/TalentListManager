package objects;

import java.util.Arrays;
import java.util.List;

public class PlayerAttributes {
	public static final String NAME = "Name";
	public static final String COUNTRY = "Country";
	public static final String POSITIONS = "Positions";
	public static final String AGE = "Age";
	public static final String HEIGHT = "Height";
	public static final String WEIGHT = "Weight";

	public static final List<String> labels = Arrays.asList("Overall Rating", "Potential", "Skill Moves", "Weak Foot",
			"Crossing", "Finishing", "Heading Accuracy", "Short Passing", "Volleys", "Dribbling", "Curve",
			"FK Accuracy", "Long Passing", "Ball Control", "Acceleration", "Sprint Speed", "Agility", "Reactions",
			"Balance", "Shot Power", "Jumping", "Stamina", "Strength", "Long Shots", "Aggression", "Interceptions",
			"Positioning", "Vision", "Penalties", "Composure", "Marking", "Standing Tackle", "Sliding Tackle",
			"GK Diving", "GK Handling", "GK Kicking", "GK Positioning", "GK Reflexes", "Work Rate", "Joined",
			"Loaned From", "Preferred Foot");
	public static final CharSequence COMBINED_FIRST = "pointPAC";
	public static final CharSequence COMBINED_SECOND = "pointSHO";
	public static final CharSequence COMBINED_THIRD = "pointPAS";
	public static final CharSequence COMBINED_FOURTH = "pointDRI";
	public static final CharSequence COMBINED_FIFTH = "pointDEF";
	public static final CharSequence COMBINED_SIXTH = "pointPHY";
	public static final String ID = "id";

}
