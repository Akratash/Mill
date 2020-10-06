package ch.akratash.muehle.control;

import ch.akratash.muehle.model.Board;
import ch.akratash.muehle.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Controller {

    private Board m_board = new Board();
    public Label playerLabel = null;
    public Label winnerLabel = null;

    public GridPane grid = null;

    @FXML
    private void handleRowGridAction(ActionEvent event){
        m_board = new Board();

        for (int i = 0; i < 3; i++){
            Circle circle = new Circle();
            GridPane.setRowIndex(circle, i);
            for(int j = 0; j < 3; j++){
                GridPane.setColumnIndex(circle, j);
                renderRowGrid(i, j);
            }
        }

    }

    private  void renderRowGrid(final int colIndex, final int rowIndex){

        for (Node node : grid.getChildren()){
            if (node instanceof Circle && GridPane.getColumnIndex(node) == colIndex) {
                Circle circle = (Circle) node;

                if (node instanceof Circle && GridPane.getRowIndex(node) == rowIndex){
    
                    if (Player.WHITE == m_board.getPlayer(2, colIndex, rowIndex)){
                        circle.setFill(Paint.valueOf("white"));
                    } else if (Player.BLACK == m_board.getPlayer(2, colIndex, rowIndex)) {
                        circle.setFill(Paint.valueOf("black"));
                    } else {
                        circle.setFill(Paint.valueOf("grey"));
                    }
                }
            }

        }
    }

    private void renderLabels(){
        playerLabel.setText(m_board.getActivePlayer().toString());
        winnerLabel.setText(m_board.getWinner().toString());
    }

    @FXML
    private void handleRowGridIndexAction00(MouseEvent event){
        m_board.makeMovePhase1(2,0,0);
        renderRowGrid(0, 0);
        renderLabels();
    }
    
    @FXML
    private void handleRowGridIndexAction01(KeyEvent event){
        m_board.makeMovePhase1(2,0,1);
        renderRowGrid(0, 1);
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction02(KeyEvent event){
        m_board.makeMovePhase1(2,0,2);
        renderRowGrid(0, 2);
        renderLabels();
    }
    

    @FXML
    private void handleRowGridIndexAction10(KeyEvent event){
        m_board.makeMovePhase1(2,1,0);
        renderRowGrid(1, 0);
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction12(KeyEvent event){
        m_board.makeMovePhase1(2,1,2);
        renderRowGrid(1, 2);
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction20(KeyEvent event){
        m_board.makeMovePhase1(2,2,0);
        renderRowGrid(2, 0);
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction21(KeyEvent event){
        m_board.makeMovePhase1(2,2,1);
        renderRowGrid(2, 1);
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction22(KeyEvent event){
        m_board.makeMovePhase1(2,2,2);
        renderRowGrid(2, 2);
        renderLabels();
    }
}
