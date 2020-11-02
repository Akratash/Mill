package ch.akratash.muehle.model;

public class Game {

    public static int m_whitePlayerPoints;
    public static int m_blackPlayerPoints;
    private int m_bestOfRounds;
    private String m_whitePlayerName;
    private String m_blackPlayerName;


    
    public Game(){
        
        m_bestOfRounds = 0;
        m_whitePlayerPoints = 1000;
        m_blackPlayerPoints = 100;
 
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
        return this.m_bestOfRounds;
    }

    public void setBestOfRounds(int m_bestOfRounds) {
        this.m_bestOfRounds = m_bestOfRounds;
    }

    public String getWhitePlayerName() {
        return this.m_whitePlayerName;
    }

    public void setWhitePlayerName(String m_whitePlayerName) {
        this.m_whitePlayerName = m_whitePlayerName;
    }

    public String getBlackPlayerName() {
        return this.m_blackPlayerName;
    }

    public void setBlackPlayerName(String m_blackPlayerName) {
        this.m_blackPlayerName = m_blackPlayerName;
    }




    

    
}
