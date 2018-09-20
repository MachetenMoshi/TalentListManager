package drawercontent.fileselector;

import java.io.File;

import javafx.event.Event;
import javafx.event.EventType;
import objects.Player;

public class FileSelectorEvent extends Event {
	private static final long serialVersionUID = 1L;

	public static final EventType<FileSelectorEvent> ANY = new EventType<>(Event.ANY, "FileSelectorEvent");
	public static final EventType<FileSelectorEvent> ON_SHOW_FILE_SELECTION = new EventType<>(Event.ANY,
			"FileSelectorEventOnShowFileSelection");
	public static final EventType<FileSelectorEvent> ON_FILE_SELECTED = new EventType<>(Event.ANY,
			"FileSelectorEventOnFileSelected");
	public static final EventType<FileSelectorEvent> ON_NEW_HEADER = new EventType<>(Event.ANY,
			"FileSelectorEventOnNewHeader");

	private File file;

	private String header;

	public FileSelectorEvent(EventType<? extends Event> arg0) {
		super(arg0);
	}

	public FileSelectorEvent(EventType<? extends Event> arg0, String header) {
		super(arg0);
		this.header = header;
	}

	public FileSelectorEvent(EventType<? extends Event> arg0, File file) {
		super(arg0);
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public String getHeader() {
		return header;
	}
}
