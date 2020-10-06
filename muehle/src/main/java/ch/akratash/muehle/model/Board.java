package ch.akratash.muehle.model;

/**
 * Hello world!
 *
 */
public class Board
{

	/**
	 * 3Dimensionales Array welches den Zustand der gesetzten Steine beinhaltet
	 */
	private Player[][][] m_grid;
	private boolean m_gameOver;
	private Player m_activePlayer;
	private Player m_winner;
	private int m_stackStones;
	private int m_stonesLost;

	/**
	 * Default Zustände des Boards GameOver Zustand auf false neues 2 Dimensionales
	 * Array 7Felder breit 6Felder tief Der Rote Spieler beginnt GewinnerZustand ist
	 * enum None zu Beginn des Spiels
	 * 
	 */
	public Board() {
		m_gameOver = false;
		m_grid = new Player[3][3][3];
		m_activePlayer = Player.WHITE;
		m_winner = Player.NONE;
		m_stackStones = 9;

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

	/**
	 * Macht einen Spielschritt auf der Colmn für den nächsten Spieler.
	 * 
	 * @param column Spalte in welcher der Stein gesetzt wird
	 * @return true falls valider Zug
	 */
	public boolean makeMove(int column) {
		boolean result = false;
		// TODO add logic

		return result;
	}


	protected int checkPhase(){
		return 0;
	}


	/*
	 *Methode für die Setzphase jeder Spieler kann pro Zug einen Spielstein
	 * auf einen beliebigen freien Index setzen.
	 * Die Phase endet wenn jeder Spieler 9 Steine gesetzt hat.
	 */
	public boolean makeMovePhase1(int dimension, int column, int row) {
		boolean result = false;

		
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

		m_grid[dimension][column][row] = m_activePlayer;
		switchPlayer();
		result = true;

		return result;
	}

	/**
	 * Gibt an ob das Spiel vorbei ist.
	 * 
	 * @return true if game is over
	 */
	public boolean isGameOver() {
		return m_gameOver;
	}


	private void checkGameOver() {
		// TODO implement
	}


	/**
	 * Getter für den Gewinner
	 * @return m_winner
	 */
	public Player getWinner() {
		return m_winner;
	}

	/**
	 * Liest die den Spieler aus dem Ĝrid aus.
	 * 
	 * @param colIndex
	 * @param rowIndex
	 * @return m_grid[colIndex][rowIndex]
	 */
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
