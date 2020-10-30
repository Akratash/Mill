package ch.akratash.muehle.control;

import ch.akratash.muehle.model.Person;

import java.net.URL;
import java.util.ResourceBundle;

import ch.akratash.muehle.model.Board;
import ch.akratash.muehle.model.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Controller {

    private Board m_board = new Board();
    public Label playerLabel = new Label();
    public Label winnerLabel = new Label();
    public Label stonesLostLabel = new Label();

    public Label blackPlayerStonesLostLabel = new Label();
    public Label whitePlayerStonesLostLabel = new Label();
    public Label blackPlayerStonesLabel = new Label();
    public Label whitePlayerStonesLabel = new Label();
    public Label isGameOverLabel = new Label();
    public Label isMillLabel = new Label();
    public Label isFirstClickPendingLabel = new Label();
    public Label isTakeClickPendingLabel = new Label();
    public Label isTurnDoneLabel = new Label();
    public Label turnWithoutMill = new Label();

    public GridPane innerGrid = new GridPane();
    public GridPane midGrid = new GridPane();
    public GridPane outerGrid = new GridPane();
    public TableView<Person> MainTable = new TableView<Person>();
    
    


    @FXML
    private TableColumn<Person, String> playerName;
    private TableColumn<Person, String> playerColor;
    private TableColumn<Person, String> playerPoints;
    private TableColumn<Person, String> playerRounds;

    public void initialize(URL url, ResourceBundle rb){

        //Die Spalten im TableView initialisieren.
        playerName.setCellValueFactory(new PropertyValueFactory<Person,String>("playerName"));
        playerColor.setCellValueFactory(new PropertyValueFactory<Person,String>("playerColor"));
        playerPoints.setCellValueFactory(new PropertyValueFactory<Person,String>("playerPoints"));
        playerRounds.setCellValueFactory(new PropertyValueFactory<Person,String>("playerRounds"));

        //Daten laden
        MainTable.setItems(getPeople());

        
    }

    public  ObservableList<Person> getPeople(){
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Akratash","White"));
        people.add(new Person("Kalash","Black"));

        return people;
    }

    @FXML
    private void handleRowGridAction(ActionEvent event) {
        m_board = new Board();
        renderGrids();
    }

    @FXML
    private void handleSysoutButtonAction(ActionEvent event) {
       m_board.endTurn();
    }

    private void renderGrids() {
        renderInnerGrid();
        renderMidGrid();
        renderOuterGrid();
    }

    // TableView

    // Grids
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

        stonesLostLabel.setText(Integer.toString(m_board.getStonesLost()));
        playerLabel.setText(m_board.getActivePlayer().toString());
        winnerLabel.setText(m_board.getWinner().toString());

        winnerLabel.setText("Gewinner: " + m_board.getWinner().toString());

        blackPlayerStonesLostLabel.setText("B Stones lost: " + m_board.getBlackPlayerStonesLost());
        whitePlayerStonesLostLabel.setText("W Stones lost: " + m_board.getWhitePlayerStonesLost());
        blackPlayerStonesLabel.setText("B Stones: " + m_board.getBlackPlayerStones());
        whitePlayerStonesLabel.setText("W Stones: " + m_board.getWhitePlayerStones());
        isGameOverLabel.setText("GameOver: " + m_board.isGameOver());
        isMillLabel.setText("Mill: " + m_board.isMill());
        isFirstClickPendingLabel.setText("FirstClickPend: " + m_board.isFirstClickPending());
        isTakeClickPendingLabel.setText("TakeClickPend: " + m_board.isTakeClickPending());
        isTurnDoneLabel.setText("TurnDone: " + m_board.isTurnDone());
        turnWithoutMill.setText("turnWithoutMillCounter: "+m_board.getTurnWithoutMill());
        
    
        
    }

    @FXML
    private void handleRowGridIndexAction00(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(2, 0, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction01(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(2, 0, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction02(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(2, 0, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction10(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(2, 1, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction12(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(2, 1, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction20(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(2, 2, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction21(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(2, 2, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleRowGridIndexAction22(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(2, 2, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction00(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(1, 0, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction01(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(1, 0, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction02(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(1, 0, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction10(MouseEvent event) {
        renderGrids();
        m_board.makeMove(1, 1, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction12(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(1, 1, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction20(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(1, 2, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction21(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(1, 2, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleColGridIndexAction22(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(1, 2, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction00(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(0, 0, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction01(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(0, 0, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction02(MouseEvent event) {
        renderGrids();
        m_board.makeMove(0, 0, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction10(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(0, 1, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction12(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(0, 1, 2);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction20(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(0, 2, 0);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction21(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(0, 2, 1);
        renderGrids();
        renderLabels();
    }

    @FXML
    private void handleDimGridIndexAction22(MouseEvent event) {
        renderGrids();
        renderLabels();
        m_board.makeMove(0, 2, 2);
        renderGrids();
        renderLabels();
    }
}
