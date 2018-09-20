package options;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import controlbar.ControlBarEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import utils.svg.SVG;
import utils.svg.SVGLoader;

public class OptionsView extends VBox {

	public OptionsView(String headerHint) {
		setPadding(new Insets(15, 5, 10, 5));
		addExportButton(headerHint);

	}

	private void addExportButton(String headerHint) {
		JFXTextField tfHeader = new JFXTextField();
		setSpacing(15);
		tfHeader.setLabelFloat(true);
		tfHeader.setPromptText("Titel");
		if (headerHint != null)
			tfHeader.setText(headerHint);
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		Region region = new Region();
		HBox.setHgrow(region, Priority.ALWAYS);
		JFXButton btnExport = new JFXButton();
		btnExport.setGraphic(SVGLoader.loadSVGGlyph(SVG.EXPORT, SVG.MEDIUM));
		btnExport.getStyleClass().add("svg-hover-button");
		btnExport.setOnAction(evt -> fireEvent(new ControlBarEvent(ControlBarEvent.ON_EXPORT, tfHeader.getText())));
		hBox.getChildren().addAll(region, btnExport);
		getChildren().addAll(tfHeader, hBox);
	}

}
