// entrance to program

public class SlotMachine {
	

	public static void main (String [] args ) {
		
		Player thePlayer = new Player();

		// Prompt user for name
		// If a saved file exists, read the account information
		// If not, set initial account balance to 100
		FileHandler.getAccountInformation(thePlayer);
		
		// Play the game
/*		
		Board b = new Board();
		// We're going to have to pass the accountBalance in to spin()
		SlotMachineImpl.spin(b);
		b.printBoardWithTokens();

*/		
		// For testing;  Pretend there were winnings
		thePlayer.setPlayerAccountBalance(12999);
		
		FileHandler.saveAccountInformation(thePlayer);
		
		// Print the player info to console
		thePlayer.printPlayerInfo();
		
	}  // end public static void main()

}
