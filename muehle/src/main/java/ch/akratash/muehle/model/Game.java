package ch.akratash.muehle.model;

public class Game {

    public static int m_whitePlayerPoints;
    public static int m_blackPlayerPoints;
    public static int m_bestOfRounds;
    public static String m_whitePlayerName;
    public static String m_blackPlayerName;


    
    public Game(){
        
        m_bestOfRounds = 0;
        m_whitePlayerPoints = 0;
        m_blackPlayerPoints = 0;
 
     }
 
     public void pointCounter(){
         
     }
 
     public void roundCounter(){
 
     }
 
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

    public int getBestOfRounds() {
        return Game.m_bestOfRounds;
    }

    public void setBestOfRounds(int m_bestOfRounds) {
        Game.m_bestOfRounds = m_bestOfRounds;
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
