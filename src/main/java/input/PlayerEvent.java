package input;

import javafx.event.Event;
import javafx.event.EventType;
import objects.Player;

public class PlayerEvent extends Event {

	private static final long serialVersionUID = 1L;

	public static final EventType<PlayerEvent> ANY = new EventType<>(Event.ANY, "PlayerEvent");
	public static final EventType<PlayerEvent> ON_ADD = new EventType<>(ANY, "PlayerEventOnAdd");
	public static final EventType<PlayerEvent> NEW_PLAYER = new EventType<>(ANY, "PlayerEventNewPlayer");

	private String id;

	private String comment;

	private Player player;

	public PlayerEvent(EventType<? extends Event> eventType, String id, String comment) {
		super(eventType);
		this.id = id;
		this.comment = comment;
	}

	public PlayerEvent(EventType<? extends Event> eventType, Player player) {
		super(eventType);
		this.player = player;
	}

	public String getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public Player getPlayer() {
		return player;
	}
}
