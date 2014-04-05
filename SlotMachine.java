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
		
		// Play the game
		Scanner userChoice = new Scanner (System.in);
		System.out.println("Press 'S' to Spin and 'X' to exit: ");
		String c = userChoice.next();
		System.out.println("enter 6 integers (0-2) seperated by spaces to indicate three board[][] positions.");
		System.out.println("p.s. no ID10T check in place. Keep the values between 0 & 2");
		int one = userChoice.nextInt();
		int two = userChoice.nextInt();
		int three = userChoice.nextInt();
		int four = userChoice.nextInt();
		int five = userChoice.nextInt();
		int six = userChoice.nextInt();

		System.out.println(three);
		SlotMachineImpl play;
		while (!"x".equals(c) && !"X".equals(c)){			// While the player has not exited the game 
			if ( "S".equals(c) || "s".equals(c) ) {
				
				/*
				 * TODO:
				 * instead of creating an instance of SlotMachineImpl here, we may want
				 * to create an instance of our adapter/UI component and create an instance of 
				 * SlotMachineImpl inside of that. Then, we could pass an interface type into the 
				 * SlotMachineImpl constructor that includes methods:
				 * getBetAmmount(), getPickOne(), getPickTwo(), getPickThree()
				 * 
				 * Actually... maybe this class should turn into our adapter/UI. YES.
				 */
				
				play = new SlotMachineImpl(thePlayer);
				System.out.println("Player account balance before bet = " + thePlayer.getPlayerAccountBalance());
				play.spin(1);
				
				//TODO clean up
				System.out.println("b.board[one][two] = " +  play.getBoard(one, two).getSpinName());
				System.out.println("b.board[three][four] = " + play.getBoard(three, four).getSpinName());
				System.out.println("b.board[five][six] = " + play.getBoard(five, six).getSpinName());
				System.out.println("isWiner = " + play.isWinner(play.getBoard(one, two), play.getBoard(three, four), play.getBoard(five, six)));
				System.out.println("Payout = " + play.getPayout());
				System.out.println("Player account balance after bet = " + thePlayer.getPlayerAccountBalance());

				play.printBoardWithTokens();
			} // end if
			
			// Prompt user again
			System.out.println("\nPress 'S' to Spin and 'X' to exit: ");
			 c = userChoice.next();
		} // end while
		
		// Save the winning in the file
		FileHandler.saveAccountInformation(thePlayer);
		
		// Print the player info to console
		thePlayer.printPlayerInfo();
		
	}  // end public static void main()

}
