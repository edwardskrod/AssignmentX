package SlotMachine;

// entrance to program
import java.util.Scanner;

public class SlotMachine {
	

	public static void main (String [] args ) {
		
		Player thePlayer = new Player();

		// Prompt user for name
		// If a saved file exists, read the account information
		// If not, set initial account balance to 100
		FileHandler.getAccountInformation(thePlayer);
		
		
		// Instantiate a new Board
		Board board = new Board();
		
		// Play the game
		Scanner userChoice = new Scanner (System.in);
		System.out.println("Press 'S' to Spin and 'X' to exit: ");
		String c = userChoice.next();
		System.out.println("choose your boxes ");
		int one = userChoice.nextInt();
		int two = userChoice.nextInt();
		int three = userChoice.nextInt();
		int four = userChoice.nextInt();
		int five = userChoice.nextInt();
		int six = userChoice.nextInt();

		SlotMachineImpl play;
		while (!"x".equals(c) && !"X".equals(c)){			// While the player has not exited the game 
			if ( "S".equals(c) || "s".equals(c) ) {
				play = new SlotMachineImpl(board);
				board.printBoardWithTokens();
			} // end if
			
			// Prompt user again
			System.out.println("\nPress 'S' to Spin and 'X' to exit: ");
			 c = userChoice.next();
		} // end while
		
		// For testing;  Pretend there were winnings
		thePlayer.setPlayerAccountBalance(12999);
		
		
		// Save the winning in the file
		FileHandler.saveAccountInformation(thePlayer);
		
		// Print the player info to console
		thePlayer.printPlayerInfo();
		
	}  // end public static void main()

}
