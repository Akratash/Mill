package ch.akratash.muehle.model;

public class Game {

    public static int m_whitePlayerPoints;
    public static int m_blackPlayerPoints;
    public static int m_blackRoundPoints;
    public static int m_whiteRoundPoints;
    public static int m_bestOfRoundsBlack;
    public static int m_bestOfRoundsWhite;
    public static int m_bestOfRoundsMode;
    public static String m_whitePlayerName;
    public static String m_blackPlayerName;


    
    public Game(){
        
        m_bestOfRoundsBlack = 0;
        m_bestOfRoundsWhite = 0;
        m_whiteRoundPoints = 0;
        m_blackRoundPoints = 0;
        m_whitePlayerPoints = 0;
        m_blackPlayerPoints = 0;
        m_bestOfRoundsMode = 0;
 
     }

     //TODO Eine Methode für den BestOf Modus (3/5/7) --> und eine Methode bestOfOver() die überprüft wann ein Spieler gewonnen hat. (bei 3 -> Siege .f bei 5 -> 3 .. bei 7 -> 4 )
     // Logik ist maximal mögliche Spiele + 1 ... /2 (7+1->/2 = 4)
 
    public int getwhitePlayerPoints() {
        return Game.m_whitePlayerPoints;
    }

    public void setWhitePlayerPoints(int m_whitePlayerPoints) {
        Game.m_whitePlayerPoints = m_whitePlayerPoints;
    }

    public int getBlackPlayerPoints() {
        return Game.m_blackPlayerPoints;
    }

    public void setBlackPlayerPoints(int m_blackPlayerPoints) {
        Game.m_blackPlayerPoints = m_blackPlayerPoints;
    }

    public int getBestOfRoundsBlack() {
        return Game.m_bestOfRoundsBlack;
    }

    public void setBestOfRoundsBlack(int m_bestOfRounds) {
        Game.m_bestOfRoundsBlack = m_bestOfRounds;
    }
    public int getBestOfRoundsWhite() {
        return Game.m_bestOfRoundsWhite;
    }

    public void setBestOfRoundsWhite(int m_bestOfRounds) {
        Game.m_bestOfRoundsWhite = m_bestOfRounds;
    }

    public void setBestOfRoundsMode() {
        Game.m_bestOfRoundsMode = m_bestOfRoundsMode;
    }

    public int getBestOfRoundsMode() {
        return Game.m_bestOfRoundsMode;
    }

    public String getWhitePlayerName() {
        return Game.m_whitePlayerName;
    }

    public void setWhitePlayerName(String m_whitePlayerName) {
        Game.m_whitePlayerName = m_whitePlayerName;
    }

    public String getBlackPlayerName() {
        return Game.m_blackPlayerName;
    }

    public void setBlackPlayerName(String m_blackPlayerName) {
        Game.m_blackPlayerName = m_blackPlayerName;
    }




    

    
}
