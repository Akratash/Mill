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
    public Label playerLabel = new Label();
    public Label winnerLabel = new Label();

    public GridPane innerGrid = new GridPane();
    public GridPane midGrid = new GridPane();
    public GridPane outerGrid = new GridPane();

    @FXML
    private void handleRowGridAction(ActionEvent event) {
        m_board = new Board();

        /*Circle circle = new Circle();
        for (int i = 0; i < 3; i++) {
            GridPane.setColumnIndex(circle, i);
            for (int j = 0; j < 3; j++) {
                GridPane.setRowIndex(circle, j);
                renderGrids();

            }
        }*/
        renderGrids();
    }

    private void initGridPane(GridPane gridPane) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Circle circle = new Circle();
                GridPane.setColumnIndex(circle, i);
                GridPane.setRowIndex(circle, j);
            
            }
        }
    }

    @FXML
    private void handleSysoutButtonAction(ActionEvent event) {
        renderGrids();
    }

    private void renderGrids() {
        renderInnerGrid();
        renderMidGrid();
        renderOuterGrid();
    }

    private void renderInnerGrid() {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                for (Node node : innerGrid.getChildren()) {

                    if (node instanceof Circle && GridPane.getColumnIndex(node) == col
                            && GridPane.getRowIndex(node) == row) {
                        Circle circle = (Circle) node;
                        if (Player.WHITE == m_board.getPlayer(2, col, row)) {
                            circle.setFill(Paint.valueOf("white"));
                            circle.setOpacity(1);
                        } else if (Player.BLACK == m_board.getPlayer(2, col, row)) {
                            circle.setFill(Paint.valueOf("black"));
                            circle.setOpacity(1);
                        } else {
                            circle.setOpacity(0);
                        }
                    }

                }
            }

        }

    }

    private void renderMidGrid() {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                for (Node node : midGrid.getChildren()) {

                    if (node instanceof Circle && GridPane.getColumnIndex(node) == col
                            && GridPane.getRowIndex(node) == row) {
                        Circle circle = (Circle) node;
                        if (Player.WHITE == m_board.getPlayer(1, col, row)) {
                            circle.setFill(Paint.valueOf("white"));
                            circle.setOpacity(1);
                        } else if (Player.BLACK == m_board.getPlayer(1, col, row)) {
                            circle.setFill(Paint.valueOf("black"));
                            circle.setOpacity(1);
                        } else {
                            circle.setOpacity(0);
                        }
                    }

                }
            }
        }
    }

    private void renderOuterGrid() {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                for (Node node : outerGrid.getChildren()) {

                    if (node instanceof Circle && GridPane.getColumnIndex(node) == col
                            && GridPane.getRowIndex(node) == row) {
                        Circle circle = (Circle) node;
                        if (Player.WHITE == m_board.getPlayer(0, col, row)) {
                            circle.setFill(Paint.valueOf("white"));
                            circle.setOpacity(1);
                        } else if (Player.BLACK == m_board.getPlayer(0, col, row)) {
                            circle.setFill(Paint.valueOf("black"));
                            circle.setOpacity(1);
                        } else {
                            circle.setOpacity(0);
                        }
                    }
                }
            }
        }
    }

    private void renderLabels() {
        playerLabel.setText(m_board.getActivePlayer().toString());
        winnerLabel.setText(m_board.getWinner().toString());
    }

    @FXML
    private void handleRowGridIndexAction00(MouseEvent event) {
        m_board.makeMove(2, 0, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction01(MouseEvent event) {
        m_board.makeMove(2, 0, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction02(MouseEvent event) {
        m_board.makeMove(2, 0, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction10(MouseEvent event) {
        m_board.makeMove(2, 1, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction12(MouseEvent event) {
        m_board.makeMove(2, 1, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction20(MouseEvent event) {
        m_board.makeMove(2, 2, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction21(MouseEvent event) {
        m_board.makeMove(2, 2, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction22(MouseEvent event) {
        m_board.makeMove(2, 2, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction00(MouseEvent event) {
        m_board.makeMove(1, 0, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction01(MouseEvent event) {
        m_board.makeMove(1, 0, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction02(MouseEvent event) {
        m_board.makeMove(1, 0, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction10(MouseEvent event) {
        m_board.makeMove(1, 1, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction12(MouseEvent event) {
        m_board.makeMove(1, 1, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction20(MouseEvent event) {
        m_board.makeMove(1, 2, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction21(MouseEvent event) {
        m_board.makeMove(1, 2, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction22(MouseEvent event) {
        m_board.makeMove(1, 2, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction00(MouseEvent event) {
        m_board.makeMove(0, 0, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction01(MouseEvent event) {
        m_board.makeMove(0, 0, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction02(MouseEvent event) {
        m_board.makeMove(0, 0, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction10(MouseEvent event) {
        m_board.makeMove(0, 1, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction12(MouseEvent event) {
        m_board.makeMove(0, 1, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction20(MouseEvent event) {
        m_board.makeMove(0, 2, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction21(MouseEvent event) {
        m_board.makeMove(0, 2, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction22(MouseEvent event) {
        m_board.makeMove(0, 2, 2);
        renderGrids();
        renderLabels();
    }
}
