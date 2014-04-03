// entrance to program

public class SlotMachine {
	
	public static void main (String [] args ) {
		
		int accountBalance = 0;
		// Promt player for name
		String name = Player.promptForPlayerName();
		
		// Perform check to see if player has a file associated with him/her
		// if yes, load the player account information
		// accountBalance = accountBalance from the file;
		
		// if no, create a new Player, set account balance to 100
		// accountBalance = 100;
		
		
		// Instantiate new Player
		Player thePlayer = new Player(name, accountBalance);
		
		Board b = new Board();
		SlotMachineImpl.spin(b);
		b.printBoardWithTokens();

	}

}
