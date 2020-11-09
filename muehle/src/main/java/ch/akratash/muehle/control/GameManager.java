package ch.akratash.muehle.control;

import ch.akratash.muehle.view.Gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameManager {

	public static void main(String[] args) {

		Application.launch(Gui.class, args);

	}

	final void start(Stage mainStage) {
		mainStage.setTitle("JavaFX-TitledPane-with-checkbox");

		TitledPane bestOfMode = new TitledPane();
		Scene scene = new Scene(bestOfMode);

		bestOfMode.setContent(new TextArea());
		BorderPane bPane = new BorderPane();
		bPane.setLeft(new Label("Titel"));
		Label label = new Label(" ");
		bPane.setCenter(label);
		bPane.setRight(new CheckBox()); // new Button() ... ginge natürlich auch
		bPane.setCenter(new Button());
		bestOfMode.setGraphic(bPane);
  
	   mainStage.setScene(scene);
	   mainStage.show();
	}

}