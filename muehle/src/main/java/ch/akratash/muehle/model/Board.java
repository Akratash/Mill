package ch.akratash.muehle.model;




public class Board {

	/**
	 * 3Dimensionales Array welches den Zustand der gesetzten Steine beinhaltet
	 */
	private Player[][][] m_grid;
	private int m_blackPlayerStones;
	private int m_whitePlayerStones;
	private int m_blackPlayerStonesLost;
	private int m_whitePlayerStonesLost;
	private boolean m_gameOver;
	private Player m_activePlayer;
	private Player m_winner;
	private boolean m_isMill;
	private boolean m_isPartOfMill;
	

	/**
	 * Default Zustände des Boards GameOver Zustand auf false neues 2 Dimensionales
	 * Array 7Felder breit 6Felder tief Der Rote Spieler beginnt GewinnerZustand ist
	 * enum None zu Beginn des Spiels
	 * 
	 */
	public Board() {
		// Initialisieren des Boards inklusive Counter für die Steine.
		m_whitePlayerStones = 9;
		m_blackPlayerStones = 9;
		m_blackPlayerStonesLost = 0;
		m_whitePlayerStonesLost = 0;

		m_gameOver = false;
		m_isMill = false;
		m_isPartOfMill = false;
		m_grid = new Player[3][3][3];
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

	// Getter für die Steine der Spieler.
	public int getStonesblack() {
		return m_blackPlayerStones;
	}

	public int getStoneswhite() {
		return m_whitePlayerStones;
	}



	// Methode die zählt wievele Steine gesetzt wurden. Beginnt bei 9 und endet bei 0.
	public void stoneCounter() {
		if (m_activePlayer == Player.WHITE) {
			m_whitePlayerStones -= 1;
		}
		if (m_activePlayer == Player.BLACK) {
			m_blackPlayerStones -= 1;
		}
	}
	// Zählt pro Spieler die verlorenen Steine
	public void stoneCounterLost() {
		if (m_activePlayer == Player.WHITE) {
			m_blackPlayerStonesLost += 1;
		}
		if (m_activePlayer == Player.BLACK) {
			m_whitePlayerStonesLost += 1;
		}
	}

	/**
	 * Methode um den Spieler nach vollendetem Zug zu wechseln
	 */
	public void switchPlayer() {
		if(m_isMill){
			return;
		}
		if (m_gameOver) {
			m_activePlayer = Player.NONE;
		} else if (m_activePlayer == Player.BLACK) {
			m_activePlayer = Player.WHITE;
		} else if (m_activePlayer == Player.WHITE) {
			m_activePlayer = Player.BLACK;
		}
	}

	// Variabeln für den Cache für einen Spielzug Phase 2.
	private boolean m_firstClickPending = true;
	private boolean m_takeClickPending = true;

	private int m_firstClickDimension;
	private int m_firstClickColumn;
	private int m_firstClickRow;
	private boolean m_turnDone = false;

	/** 
	 * Methode die alle Varianten des Spielzugs handelt
	 */
	public void makeMove(int dimension, int column, int row) {
		// Erster Teil kontrolliert ob alle Spielsteine schon gesetzt wurden und somit Phase2 beginnt.(Spielsteine schieben)
		m_turnDone = false;
		if(m_isMill){
			takeStone(dimension, column, row);
			m_turnDone = true;			
		} else {
		
			if (m_blackPlayerStones > 0) {
				makeMovePhase1(dimension, column, row);

			} else {
				// Prüft ob der Spieler schon einen Zielpunkt für den Stein gewählt hat wenn nicht speichert er die koordinaten in die Variabeln.
				if (!m_firstClickPending) {
					m_firstClickPending = true;
					m_firstClickDimension = dimension;
					m_firstClickColumn = column;
					m_firstClickRow = row;
				} else {
					// Ausführen des Spielzugs Phase 2 oder 3
					if(m_whitePlayerStonesLost == 6|| m_blackPlayerStonesLost == 6){
						makeMovePhase3(m_firstClickDimension, m_firstClickColumn, m_firstClickRow, dimension, column, row);
						
					} else {
						makeMovePhase2(m_firstClickDimension, m_firstClickColumn, m_firstClickRow, dimension, column, row);
						
						
					}
					m_firstClickPending = false;

					
				}
				checkGameOver();
			}
			if(m_turnDone){
					
					//m_takeClickPending = true;
										
			}
		}
		
	}

	/*
	 * Methode für die Setzphase jeder Spieler kann pro Zug einen Spielstein auf
	 * einen beliebigen freien Index setzen. Die Phase endet wenn jeder Spieler 9
	 * Steine gesetzt hat.
	 */
	protected boolean makeMovePhase1(int dimension, int column, int row) {
		boolean result = false;
		// setPlayerInt(m_player);
		if(m_activePlayer==Player.NONE){
			return false;
		}

		if (dimension < 0 || dimension > 2) {
			return false;
		}
		if (column < 0 || column > 2) {
			return false;
		}
		if (row < 0 || row > 2) {
			return false;
		}
		if (column == 1 && row == 1) {
			return false;
		}

		if (m_grid[dimension][column][row] != Player.NONE) {
			return false;
		}

		// Prüft ob noch Steine gesetzt werden dürfen
		if (m_activePlayer == Player.WHITE && m_whitePlayerStones == 0) {
			return false;
		}

		if (m_activePlayer == Player.BLACK && m_blackPlayerStones == 0) {
			return false;
		}

		m_grid[dimension][column][row] = m_activePlayer;
		stoneCounter();
		checkMill(dimension, column, row);
		if(!m_isMill){
			switchPlayer();
		}
		result = true;

		return result;
	}

	/*
	 * Phase 2 die Steine können jetzt nur noch verschoben werden an freie benachbarte
	 * Felder
	 */
	protected boolean makeMovePhase2(int dimension0, int column0, int row0, int dimension1, int column1, int row1) {
		boolean result = false;

		if(m_activePlayer==Player.NONE){
			return false;
		}

		if (m_grid[dimension0][column0][row0] != m_activePlayer) {
			return false;
		}

		if (m_grid[dimension1][column1][row1] != Player.NONE) {
			return false;
		}
		if((column0+row0%2)==0&&dimension0!=dimension1){
			return false;
		}
		if((column0+row0)%2==0){
			if((column1+row1)%2==0){
				return false;
			}
		}
		m_grid[dimension0][column0][row0] = Player.NONE;
		m_grid[dimension1][column1][row1] = m_activePlayer;

		checkMill(dimension1, column1, row1);
		result = true;
		if(!m_isMill){
			switchPlayer();
		}

		return result;
	}


	protected boolean makeMovePhase3(int dimension0, int column0, int row0, int dimension1, int column1, int row1){
		boolean result = false;

		if(m_activePlayer==Player.NONE){
			return false;
		}

		if (m_grid[dimension0][column0][row0] != m_activePlayer) {
			return false;
		}

		if (m_grid[dimension1][column1][row1] != Player.NONE) {
			return false;
		}

		m_grid[dimension0][column0][row0] = Player.NONE;
		m_grid[dimension1][column1][row1] = m_activePlayer;

		checkMill(dimension1, column1, row1);
		result = true;
		if(!m_isMill){
			switchPlayer();
		}

		return result;
	}


	//Check ob das Spiel vorbei ist und setzt den Gewinner
	public void checkGameOver(){
		if(m_blackPlayerStonesLost > 6){
			m_gameOver = true;
			m_winner = Player.WHITE;
		} else if (m_whitePlayerStonesLost > 6){
			m_gameOver = true;
			m_winner = Player.BLACK;
		}
	}

	// Prüft ob aktive Mühlen vorhanden sind.
	public void checkMill(final int lastInsertedDim, final int lastInsertedCol, final int lastInsertedRow){
		Player lastInsertedPlayer = m_grid[lastInsertedDim][lastInsertedCol][lastInsertedRow];
			if(!m_isMill && (checkMillsDim(lastInsertedDim, lastInsertedCol, lastInsertedRow, lastInsertedPlayer)
			|| checkMillsCol(lastInsertedDim, lastInsertedCol, lastInsertedRow, lastInsertedPlayer)
			|| checkMillsRow(lastInsertedDim, lastInsertedCol, lastInsertedRow, lastInsertedPlayer))){
				m_isMill = true;
			}else{
				m_isMill = false;
			}
		}

	// Prüft die Senkrechten und Waagerechten Mühlen in der Mitte des Feldes welche die Dimensionen wechseln (Dimension ===> x00)
	private boolean checkMillsDim(int lastInsertedDim, int lastInsertedCol, int lastInsertedRow, Player lastInsertedPlayer){
		boolean result = false;
		//Player lastInsertedPlayer2 = m_grid[lastInsertedDim][lastInsertedCol][lastInsertedRow];
		int count = 0;
		for (int dim = lastInsertedDim; dim >=0; dim--){
			if(m_grid[dim][lastInsertedCol][lastInsertedRow] == lastInsertedPlayer && (lastInsertedCol+lastInsertedRow)%2==1){
				count++;
			}else{
				break;
			}
		}

		for (int dim = lastInsertedDim+1; dim < m_grid.length; dim++){
			if(m_grid[dim][lastInsertedCol][lastInsertedRow]== lastInsertedPlayer && (lastInsertedCol+lastInsertedRow)%2==1){
				count++;
			}else{
				break;
			}
		} 

		if(count==3){
			result = true;
		}
		return result;
	}
	// Prüft die Waagerechten Mühlen des Spielfeldes welche nicht die Dimension wechseln (Column ===> 0x0)
	private boolean checkMillsCol(int lastInsertedDim, int lastInsertedCol, int lastInsertedRow, Player lastInsertedPlayer){
		boolean result = false;
		int count = 0;
		for (int col = lastInsertedCol; col >=0; col--){
			if (m_grid[lastInsertedDim][col][lastInsertedRow]== lastInsertedPlayer){
				count++;
			}else{
				break;
			}
		}

		for(int col = lastInsertedCol+1; col < m_grid[lastInsertedDim].length; col++){
			if(m_grid[lastInsertedDim][col][lastInsertedRow]== lastInsertedPlayer){
				count++;
			}else{
				break;
			}
		}

		if(count==3){
			result=true;
		}
		return result;
	}

		// Prüft die Senkrechten Mühlen des Spielfeldes welche nicht die Dimension wechseln (Column ===> 0x0)
		private boolean checkMillsRow(int lastInsertedDim, int lastInsertedCol, int lastInsertedRow, Player lastInsertedPlayer){
			boolean result = false;
			int count = 0;
			for (int row = lastInsertedRow; row >=0; row--){
				if (m_grid[lastInsertedDim][lastInsertedCol][row]== lastInsertedPlayer){
					count++;
				}else{
					break;
				}
			}
	
			for(int row = lastInsertedRow+1; row < m_grid[lastInsertedDim][lastInsertedCol].length; row++){
				if(m_grid[lastInsertedDim][lastInsertedCol][row]== lastInsertedPlayer){
					count++;
				}else{
					break;
				}
			}
	
			if(count==3){
				result=true;
			}
			return result;
		}

	// Prüft ob der zu entfernende Stein zu einer aktiven Mühle gehört.
	public boolean isPartOfMill(final int lastInsertedDim, final int lastInsertedCol, final int lastInsertedRow){
		boolean result = false;
		Player lastInsertedPlayer = m_grid[lastInsertedDim][lastInsertedCol][lastInsertedRow];
			if((checkMillsDim(lastInsertedDim, lastInsertedCol, lastInsertedRow, lastInsertedPlayer)
			|| checkMillsCol(lastInsertedDim, lastInsertedCol, lastInsertedRow, lastInsertedPlayer)
			|| checkMillsRow(lastInsertedDim, lastInsertedCol, lastInsertedRow, lastInsertedPlayer))){
				m_isPartOfMill = true;
			}else{
				m_isPartOfMill = false;
			}
		result = m_isPartOfMill;
		return result;
		}
	// Bei aktiver Mühle wird ein Spielstein nach Wahl vom Gegner entfernt.
	public boolean takeStone(int dim, int col, int row){
		boolean result = false;
		// setPlayerInt(m_player);
		if(m_activePlayer==Player.NONE){
			return false;
		}
		if(!m_isMill){
			return false;
		}

		if (dim < 0 || dim > 2) {
			return false;
		}
		if (col < 0 || col > 2) {
			return false;
		}
		if (row < 0 || row > 2) {
			return false;
		}
		if (col == 1 && row == 1) {
			return false;
		}

		if (m_grid[dim][col][row] ==Player.NONE||m_grid[dim][col][row]==m_activePlayer){
			return false;
		}

		isPartOfMill(dim, col, row);

		if (m_isPartOfMill){
			return false;
		}

		m_grid[dim][col][row]=Player.NONE;
		stoneCounterLost();
		m_isMill=false;
		result = true;
		checkGameOver();
		switchPlayer();

		return result;
	}
	/*
	 * Gibt an ob das Spiel vorbei ist.
	 */
	public boolean isGameOver() {

		return m_gameOver;
	}

	public Player getWinner() {
		return m_winner;
	}

	public boolean isActiveMill(){
		return m_isMill;
	}

	// Liest die den Spieler aus dem Grid aus.
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

	public int getStonesLost(){
		int result = 0;
		if(m_activePlayer==Player.WHITE){
			result = m_whitePlayerStonesLost;
		}

		if(m_activePlayer==Player.BLACK){
			result = m_blackPlayerStonesLost;
		}

		return result;
	}

	public void endTurn(){
		m_isMill = false;
		switchPlayer();
	}

	public int getBlackPlayerStones() {
		return m_blackPlayerStones;
	}

	public int getWhitePlayerStones() {
		return m_whitePlayerStones;
	}

	public int getBlackPlayerStonesLost() {
		return m_blackPlayerStonesLost;
	}

	public int getWhitePlayerStonesLost() {
		return m_whitePlayerStonesLost;
	}

	public boolean isMill() {
		return m_isMill;
	}

	public boolean isFirstClickPending() {
		return m_firstClickPending;
	}


	public boolean isTakeClickPending() {
		return m_takeClickPending;
	}

	public boolean isTurnDone() {
		return m_turnDone;
	}
}