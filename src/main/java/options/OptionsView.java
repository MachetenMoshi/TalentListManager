package options;

import com.jfoenix.controls.JFXButton;

import controlbar.ControlBarEvent;
import javafx.scene.layout.VBox;

public class OptionsView extends VBox {

	public OptionsView() {
		addExportButton();

	}

	private void addExportButton() {
		JFXButton btnExport = new JFXButton("Export");
		btnExport.setOnAction(evt -> fireEvent(new ControlBarEvent(ControlBarEvent.ON_EXPORT)));
		getChildren().add(btnExport);
	}

}
