package ch.akratash.muehle.control;

import ch.akratash.muehle.model.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class Controller {

    private Board m_board = new Board();
    public Label playerLabel = null;
    public Label winnerLabel = null;

    public GridPane grid = null;

    @FXML
    private void handleTestButtonAction(ActionEvent event){
        m_board = new Board();


    }
    
}
