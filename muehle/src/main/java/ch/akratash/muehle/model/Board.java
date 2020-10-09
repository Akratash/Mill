package ch.akratash.muehle.model;

import java.util.Collections;

public class Board extends Mills
{

	/**
	 * 3Dimensionales Array welches den Zustand der gesetzten Steine beinhaltet
	 */
	private Player[][][] m_grid;
	private int m_player;
	private int m_playerStonesLeft[][];
	private int blackplayerstones;
	private int whiteplayerstones;
	private boolean m_gameOver;
	private Player m_activePlayer;
	private Player m_winner;

	public static final boolean IS_FLYING_ALLOWED = false;

	/**
	 * Default Zustände des Boards GameOver Zustand auf false neues 2 Dimensionales
	 * Array 7Felder breit 6Felder tief Der Rote Spieler beginnt GewinnerZustand ist
	 * enum None zu Beginn des Spiels
	 * 
	 */
	public Board() {
		m_player = 0;
		// KINDERGAGGI
		whiteplayerstones = 9;
		blackplayerstones = 9;
		
		m_gameOver = false;
		m_grid = new Player[3][3][3];
		m_playerStonesLeft = new int [2][1];
		m_activePlayer = Player.WHITE;
		m_winner = Player.NONE;


		/**
		 * überschreiben der NULL Werte im Array auf den Zustand NONE
		 */
		for (int dimension = 0; dimension < m_grid.length; dimension++) {
			for (int column = 0; column < m_grid[dimension].length; column++) {
				for (int row = 0; row < m_grid[dimension][column].length; row++) {
					m_grid[dimension][column][row] = Player.NONE;
				}
			}	
		}
	}

	public void checkMILLS(){
		
	}

	// BRUUUUUUUCHTS DA !!!?
	private void setPlayerInt(int player){
		if(m_activePlayer==Player.WHITE){
			player = 1;
		} else if(m_activePlayer==Player.BLACK){
			player = 2;
		}
		m_player = player;
	}

	public int getPlayerInt(){
		return m_player;
	}

	public int getStonesblack(){
		return blackplayerstones;
	}
	
	public int getStoneswhite(){
		return whiteplayerstones;
	}

	/*
		KOMISCHE SCHàDEN
	*/ 
	/*public void stoneCounter(){
		if(m_player==1){
			whiteplayerstones-=1;
			m_playerStonesLeft[m_player][0]= whiteplayerstones;
		}
		if(m_player==2){
			blackplayerstones-=1;
			m_playerStonesLeft[m_player][0]= blackplayerstones;
		}
	}*/

	public void stoneCounter(){
		if(m_player==1){
			whiteplayerstones-=1;
		}
		if(m_player==2){
			blackplayerstones-=1;
		}
	}

	/**
	 * Methode um den Spieler nach vollendetem Zug zu wechseln
	 */
	private void switchPlayer() {
		if (m_gameOver) {
			m_activePlayer = Player.NONE;
		} else if (m_activePlayer == Player.BLACK) {
			m_activePlayer = Player.WHITE;
		} else if (m_activePlayer == Player.WHITE) {
			m_activePlayer = Player.BLACK;
		}
	}




	/*
	 *Methode für die Setzphase jeder Spieler kann pro Zug einen Spielstein
	 * auf einen beliebigen freien Index setzen.
	 * Die Phase endet wenn jeder Spieler 9 Steine gesetzt hat.
	 */
	public boolean makeMovePhase1(int dimension, int column, int row) {
		boolean result = false;
		setPlayerInt(m_player);

		if (dimension < 0 || dimension > 2){
			return false;
		}
		if (column < 0 || column > 2){
			return false;
		}
		if (row < 0 || row > 2){
			return false;
		}
		if (column == 1 && row == 1){
			return false;
		}

		if(m_grid[dimension][column][row]!=Player.NONE){
			return false;
		}

		//KINDER IMPLEMENTS
		if(m_activePlayer==Player.WHITE&&whiteplayerstones==0){
			return false;
		}

		if(m_activePlayer==Player.BLACK&&blackplayerstones==0){
			return false;
		}


		m_grid[dimension][column][row] = m_activePlayer;
		stoneCounter();
		switchPlayer();
		result = true;

		return result;
	}


	public void getPlayerPossMillIndex(){
			
	}

	public void makeMove(){
		if(m_playerStonesLeft[m_player][0]==0){
			
		}
	}

	/* 
	* Phase 2 die Steine können jetzt nur noch verschoben werden an benachbarte Felder
	*/
	public boolean makeMovePhase2(int dimension, int column, int row) {
		boolean result = false;
		boolean p1Done = false;
		if(m_activePlayer==Player.WHITE&&whiteplayerstones==0){
			p1Done = true;
		}else if(m_activePlayer==Player.BLACK&&blackplayerstones==0){
			p1Done = true;
		}

		// TODO add logic

		return result;
	}

	/*
	 * Gibt an ob das Spiel vorbei ist.
	 */ 
	public boolean isGameOver() {
		//Wenn ein Spieler keine Steine mehr hat oder keinen mehr bewegen kann hat er das Spiel verloren.
		return m_gameOver;
	}


	private void checkGameOver() {
		//Wenn ein Spieler keine Steine mehr hat oder keinen mehr bewegen kann hat er das Spiel verloren.

	}

	public Player getWinner() {
		return m_winner;
	}

	// Liest die den Spieler aus dem Ĝrid aus.
	public Player getPlayer(int dimension, int colIndex, int rowIndex) {
		return m_grid[dimension][colIndex][rowIndex];
	}

	/**
	 * Gibt aktiven Spieler zurück.
	 * 
	 * 
	 */
	public Player getActivePlayer() {
		return m_activePlayer;
	}




}
