/**
 * 
 * @author Patrick Maguire, Kasey Bourdier, Leandro Ysiano, Jonathan Doolittle
 *
 */

public enum GameChoice {
	
	NONE {
		public GameChoice wins() {
			return NONE;
		}
	},
	ROCK {
		public GameChoice wins() {
			return SCISSORS;
		}
	},
	PAPER {
		public GameChoice wins() {
			return ROCK;
		}
	},
	
	SCISSORS {
		public GameChoice wins() {
			return PAPER;
		}
	};
	
	/**
	 * 
	 * @return The choice that this option beats
	 */
	abstract GameChoice wins();
	
	/**
	 * 
	 * @param input The string input
	 * @return The mapped output as a GameChoice
	 */
	public static GameChoice mapFromString(String input) {
		try {
			return GameChoice.valueOf(input.trim().toUpperCase());
		} catch (Exception e) {
			return GameChoice.NONE;
		}
	}
	
	/**
	 * Compares two GameChoices to determine a winner
	 * @param a The first GameChoice. -1 indicates this player won
	 * @param b The second GameChoice. 1 indicates this player won
	 * @return -1, 0, or 1. -1 & 1 indicate first or second player's win, respectively. 0 indicates a tie.
	 */
	public static int compareChoice(GameChoice a, GameChoice b) {
		
		if(a.wins() == b) {
			return -1;
		}
		
		if(b.wins() == a) {
			return 1;
		}
		
		return 0;
		
	}
	
}
