package SlotMachine;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class FileHandler {
	
	private static BufferedReader in;
	private static BufferedWriter out;
	private static int playerAccountBalance = 0;
	private static String stringAccountBalance;		// We need a string of account balance to read and write to file
	private static String playerName;
	private static String fileName;
	private static File userFile;
	
	public static void getAccountInformation( Player p ) {
		
		// Prompt player for name
		playerName = Player.promptForPlayerName();
		
		// Create fileName from playerName + .txt
		fileName = playerName + ".txt";
		
		// Instantiate File object using fileName
		userFile = new File ( fileName );
		
		// Check if the File already exists
		// If yes, read the accountBalance
		if ( userFile.exists() ) {
			
			try 
			{
				in = new BufferedReader ( new FileReader( userFile ) );
				stringAccountBalance = in.readLine();
				in.close();
			}
		
			catch (IOException e){
				System.out.println("There was a problem opening the file: " + e);
			}
			
			// Parse the int
			playerAccountBalance = Integer.parseInt(stringAccountBalance);
			
			
		} // end if (userFile.exists() ) 
		
		else {
			
			System.out.println("fileName is not a file.");
			playerAccountBalance = 100;
			
		}
		
		// Save information to Player object
		p.setPlayerName(playerName);
		p.setPlayerAccountBalance(playerAccountBalance);
	}
	
	public static void saveAccountInformation (Player p ) 
	/** Takes a Player p as a parameter
	 *  Saves the account balance to the file
	 * 
	 */
	{
		// Update the stringAccountBalance
		stringAccountBalance = Integer.toString((int)p.getPlayerAccountBalance());
				
		try {
			out = new BufferedWriter (new FileWriter ( userFile ));
			out.write(stringAccountBalance);
			out.close( );
		}
		catch (IOException e){
			System.out.println("There was a problem saving the file: " + e);
		}
	}

	public int getPlayerAccountBalance ( ) {
		return playerAccountBalance;
	}
	
	public void setPlayerAccountBalance ( int balance ) {
		playerAccountBalance = balance;
	}
	
}
