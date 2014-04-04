// entrance to program
import java.io.File;
import java.util.Scanner;
import java.util.Formatter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.FormatterClosedException;
import java.io.IOException;


public class SlotMachine {
	
	private static Scanner userInput;

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
				// Open a Scanner to read the file
				userInput = new Scanner ( new File ( fileName ));
				// Read the file
				stringAccountBalance = userInput.next();
				
				// Parse the int
				accountBalance = Integer.parseInt(stringAccountBalance);
				

			}
			catch (FileNotFoundException fileNotFoundException ) {
			
				System.out.println ("The File is not found.");
				// Close the Scanner
			}	
			
			finally
			{
				if (userInput != null)
				userInput.close();	// Close the scanner and file
			}
		}
		else
		{
			System.out.println("fileName is not a file.");
			 accountBalance = 100;
		}

		
		
		
		// Instantiate new Player
		Player thePlayer = new Player(name, accountBalance);
		
		Board b = new Board();
		
		// We're going to have to pass the accountBalance in to spin()
		SlotMachineImpl.spin(b);
		b.printBoardWithTokens();
	
		// Get the string representation of the number
		stringAccountBalance = Integer.toString(thePlayer.getPlayerAccountBalance());
		//System.out.println("String Account Balance is : " + stringAccountBalance );
		
		// Write the account balance to the file
		Formatter output = null;
		try 
		{
			 output = new Formatter ( "test.txt" );
		}

		catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening or creating file.");
			System.exit( 1 );
			
		}
		catch (IOException i)
		{
			System.err.println("Error opening or creating file.");
			System.exit( 1 );
		}
		
		try 
		{
			output.format("%s", "write this to the fucking file bitch");
			//userOutput.write( stringAccountBalance, 0, stringAccountBalance.length() );
			//System.out.println("String Account Balance is : " + stringAccountBalance );
			
		}
		
		catch (FormatterClosedException formatterClosedException) {
			System.err.println( "Error writing to file." );
	         return;
		}
		catch ( NoSuchElementException elementException )
	      {
	         System.err.println( "Invalid input. Please try again." );
	      } // end catch
		
		
		/*
		catch ( IOException i ) 
		{
			System.err.println("Error writing to file." );
			return;
		}*/
		
		System.out.println("User Name: " + name);
		System.out.println("Account Balance: " + stringAccountBalance );			
		
	}

}
