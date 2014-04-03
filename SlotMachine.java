// entrance to program
import java.io.File;
import java.util.Scanner;
import java.util.Formatter;
import java.io.FileNotFoundException;
import java.util.FormatterClosedException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class SlotMachine {
	
	private static Scanner userInput;
	//private static Formatter userOutput;
	private static BufferedWriter userOutput;
	private static int accountBalance = 0;
	private static String stringAccountBalance;
	public static void main (String [] args ) {
		
		// Prompt player for name
		String name = Player.promptForPlayerName();
		String fileName = name + ".txt";
		File userFile = new File ( fileName );
		
		// Perform check to see if player has a file associated with his/her name
		// if yes, load the player account information
		// accountBalance = accountBalance from the file;
		if ( userFile.exists() ) {  // the userFile is a file

			// open the file and read the account information
			try {
				userInput = new Scanner ( new File ( fileName ));
			}
			catch (FileNotFoundException fileNotFoundException ) {
			
				System.out.println ("The File is not found.");
			}	
			
			stringAccountBalance = userInput.next();
			accountBalance = Integer.parseInt(stringAccountBalance);
		}
		else
		{
			System.out.println("fileName is not a file.");
			 accountBalance = 100;
		}

		// close file
		
		
		
		// Instantiate new Player
		Player thePlayer = new Player(name, accountBalance);
		
		Board b = new Board();
		
		// We're going to have to pass the accountBalance in to spin()
		SlotMachineImpl.spin(b);
		b.printBoardWithTokens();
	
		// Get the string representation of the number
		stringAccountBalance = Integer.toString(thePlayer.getPlayerAccountBalance());
		System.out.println("String Account Balance is : " + stringAccountBalance );
		
		// Save the account Balance
		try 
		{
			  userOutput = new BufferedWriter (new FileWriter ( userFile ));
		}
		catch (IOException i)
		{
			System.err.println("Error opening or creating file.");
			System.exit( 1 );
		}
		
		
		try 
		{
			userOutput.write( stringAccountBalance );
			System.out.println("String Account Balance is : " + stringAccountBalance );
			
		}
		catch ( IOException i ) 
		{
			System.err.println("Error writing to file." );
			return;
		}
		
		System.out.println("User Name: " + name);
		System.out.println("Account Balance: " + accountBalance );			
		
	}

}
