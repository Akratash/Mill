package ch.akratash.muehle.model;

import javafx.beans.property.SimpleStringProperty;

public class Person {

private SimpleStringProperty playerName;
private SimpleStringProperty playerColor;

public Person(String playerName, String playerColor){
    this.playerName = new SimpleStringProperty(playerName);
    this.playerColor = new SimpleStringProperty(playerColor);
}

public String getPlayerName() {
    return playerName.get();
}

public void setPlayerName(SimpleStringProperty playerName) {
    this.playerName = playerName;
}

public String getPlayerColor() {
    return playerColor.get();
}

public void setPlayerColor(SimpleStringProperty playerColor) {
    this.playerColor = playerColor;
}

}