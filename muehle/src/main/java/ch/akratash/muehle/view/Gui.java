package ch.akratash.muehle.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Gui extends Application {
	/**
	 * Die GameGui erstellen mit neuer Scene Grösse 1000x600
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
			Scene scene = new Scene(root, 1980, 720);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}