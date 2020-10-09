package ch.akratash.muehle.control;

import ch.akratash.muehle.model.Board;
import ch.akratash.muehle.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Controller {

    private Board m_board = new Board();
    public Label playerLabel =  new Label();
    public Label winnerLabel = new Label();

    public GridPane rowGrid, colGrid, dimGrid = new GridPane();
    @FXML
    private void handleRowGridAction(ActionEvent event){
        m_board = new Board();
        m_board.getPlayerInt();
        Circle circle = new Circle();
        for (int i = 0; i < 3; i++){
            GridPane.setColumnIndex(circle, i);
            for(int j = 0; j < 3; j++){
                GridPane.setRowIndex(circle, j);
                renderRowGrid(i, j);
                renderColGrid(i, j);
                renderDimGrid(i, j);
            }
        }
    }
    @FXML
    private void handleSysoutButtonAction(ActionEvent event){
      
    }

    private  void renderRowGrid(final int colIndex, final int rowIndex){
        for (Node node : rowGrid.getChildren()){

            if (node instanceof Circle && GridPane.getColumnIndex(node) == colIndex && GridPane.getRowIndex(node) == rowIndex) {
                Circle circle = (Circle) node;
                if (Player.WHITE == m_board.getPlayer(2, colIndex, rowIndex)) {
                    circle.setFill(Paint.valueOf("white"));
                    circle.setOpacity(1);
                } else if (Player.BLACK == m_board.getPlayer(2, colIndex, rowIndex)) {
                    circle.setFill(Paint.valueOf("black"));
                    circle.setOpacity(1);
                } else {
                    circle.setOpacity(0);
                }
            }

        }
    }

    private  void renderColGrid(final int colIndex, final int rowIndex){
        for (Node node : colGrid.getChildren()){

            if (node instanceof Circle && GridPane.getColumnIndex(node) == colIndex && GridPane.getRowIndex(node) == rowIndex) {
                Circle circle = (Circle) node;
                if (Player.WHITE == m_board.getPlayer(1, colIndex, rowIndex)) {
                    circle.setFill(Paint.valueOf("white"));
                    circle.setOpacity(1);
                } else if (Player.BLACK == m_board.getPlayer(1, colIndex, rowIndex)) {
                    circle.setFill(Paint.valueOf("black"));
                    circle.setOpacity(1);
                } else {
                    circle.setOpacity(0);
                }
            }

        }
    }
    private  void renderDimGrid(final int colIndex, final int rowIndex){
        for (Node node : dimGrid.getChildren()){

            if (node instanceof Circle && GridPane.getColumnIndex(node) == colIndex && GridPane.getRowIndex(node) == rowIndex) {
                Circle circle = (Circle) node;
                if (Player.WHITE == m_board.getPlayer(0, colIndex, rowIndex)) {
                    circle.setFill(Paint.valueOf("white"));
                    circle.setOpacity(1);
                } else if (Player.BLACK == m_board.getPlayer(0, colIndex, rowIndex)) {
                    circle.setFill(Paint.valueOf("black"));
                    circle.setOpacity(1);
                } else {
                    circle.setOpacity(0);
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
    private void handleRowGridIndexAction01(MouseEvent event){
        m_board.makeMovePhase1(2,0,1);
        renderRowGrid(0, 1);
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction02(MouseEvent event){
        m_board.makeMovePhase1(2,0,2);
        renderRowGrid(0, 2);
        renderLabels();
    }
    

    @FXML
    private void handleRowGridIndexAction10(MouseEvent event){
        m_board.makeMovePhase1(2,1,0);
        renderRowGrid(1, 0);
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction12(MouseEvent event){
        m_board.makeMovePhase1(2,1,2);
        renderRowGrid(1, 2);
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction20(MouseEvent event){
        m_board.makeMovePhase1(2,2,0);
        renderRowGrid(2, 0);
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction21(MouseEvent event){
        m_board.makeMovePhase1(2,2,1);
        renderRowGrid(2, 1);
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction22(MouseEvent event){
        m_board.makeMovePhase1(2,2,2);
        renderRowGrid(2, 2);
        renderLabels();
    }


    @FXML
    private void handleColGridIndexAction00(MouseEvent event){
        m_board.makeMovePhase1(1,0,0);
        renderColGrid(0, 0);
        renderLabels();
    }
    
    @FXML
    private void handleColGridIndexAction01(MouseEvent event){
        m_board.makeMovePhase1(1,0,1);
        renderColGrid(0, 1);
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction02(MouseEvent event){
        m_board.makeMovePhase1(1,0,2);
        renderColGrid(0, 2);
        renderLabels();
    }
    

    @FXML
    private void handleColGridIndexAction10(MouseEvent event){
        m_board.makeMovePhase1(1,1,0);
        renderColGrid(1, 0);
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction12(MouseEvent event){
        m_board.makeMovePhase1(1,1,2);
        renderColGrid(1, 2);
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction20(MouseEvent event){
        m_board.makeMovePhase1(1,2,0);
        renderColGrid(2, 0);
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction21(MouseEvent event){
        m_board.makeMovePhase1(1,2,1);
        renderColGrid(2, 1);
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction22(MouseEvent event){
        m_board.makeMovePhase1(1,2,2);
        renderColGrid(2, 2);
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction00(MouseEvent event){
        m_board.makeMovePhase1(0,0,0);
        renderDimGrid(0, 0);
        renderLabels();
    }
    
    @FXML
    private void handleDimGridIndexAction01(MouseEvent event){
        m_board.makeMovePhase1(0,0,1);
        renderDimGrid(0, 1);
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction02(MouseEvent event){
        m_board.makeMovePhase1(0,0,2);
        renderDimGrid(0, 2);
        renderLabels();
    }
    

    @FXML
    private void handleDimGridIndexAction10(MouseEvent event){
        m_board.makeMovePhase1(0,1,0);
        renderDimGrid(1, 0);
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction12(MouseEvent event){
        m_board.makeMovePhase1(0,1,2);
        renderDimGrid(1, 2);
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction20(MouseEvent event){
        m_board.makeMovePhase1(0,2,0);
        renderDimGrid(2, 0);
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction21(MouseEvent event){
        m_board.makeMovePhase1(0,2,1);
        renderDimGrid(2, 1);
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction22(MouseEvent event){
        m_board.makeMovePhase1(0,2,2);
        renderDimGrid(2, 2);
        renderLabels();
    }
}
