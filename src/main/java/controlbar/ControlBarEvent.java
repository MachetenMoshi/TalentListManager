package controlbar;

import javafx.event.Event;
import javafx.event.EventType;

public class ControlBarEvent extends Event {

	private static final long serialVersionUID = 1L;

	public static final EventType<ControlBarEvent> ANY = new EventType<>(Event.ANY, "ControlBarEvent");
	public static final EventType<ControlBarEvent> ON_DRAWER_TOGGLE = new EventType<>(Event.ANY,
			"ControlBarEventOnDrawerToggle");
	public static final EventType<ControlBarEvent> ON_ADD = new EventType<>(ANY, "ControlBarEventAdd");
	public static final EventType<ControlBarEvent> ON_UPDATE = new EventType<>(ANY, "ControlBarEventUpdate");
	public static final EventType<ControlBarEvent> ON_OPTIONS = new EventType<>(ANY, "ControlBarEventOptions");
	public static final EventType<ControlBarEvent> ON_EXPORT = new EventType<>(ANY, "ControlBarEventExport");

	private boolean drawerOpened;

	public ControlBarEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}

	public ControlBarEvent(EventType<ControlBarEvent> eventType, boolean opened) {
		super(eventType);
		this.drawerOpened = opened;
	}

	public boolean isDrawerOpened() {
		return drawerOpened;
	}
}
