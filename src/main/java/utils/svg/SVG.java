package utils.svg;

public enum SVG {

	NEW_FILE("file"), DELETE("delete"), EXPORT("export"), PLUS("plus"), PLAYER_ADD("player_add"), REFRESH(
			"refresh"), REMOVE("remove"), OPTIONS("options"), DISK("disk"), FILE("file"), STAR("star");

	public static final String SMALL = "svg-button-small";
	public static final String MEDIUM = "svg-button-medium";
	public static final String LARGE = "svg-button-large";
	private final String name;

	SVG(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
