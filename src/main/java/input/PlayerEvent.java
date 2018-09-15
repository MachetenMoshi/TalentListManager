package input;

import javafx.event.Event;
import javafx.event.EventType;

public class PlayerEvent extends Event {

	private static final long serialVersionUID = 1L;

	public static final EventType<PlayerEvent> ANY = new EventType<>(Event.ANY, "PlayerEvent");
	public static final EventType<PlayerEvent> ID_CHANGED = new EventType<>(ANY, "PlayerEventIdChanged");

	private String id;

	public PlayerEvent(EventType<? extends Event> eventType, String id) {
		super(eventType);
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
