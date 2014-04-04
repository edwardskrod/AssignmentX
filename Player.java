package SlotMachine;

import javax.swing.JOptionPane;

public class Player {

	private String playerName;
	private int playerAccountBalance;
	
	
	// Default Constructor
	Player ( ) {
		
		playerName = "";
		playerAccountBalance = 0;
		
	}

	Player (String name, int balance ) {
		
		playerName = name;
		playerAccountBalance = balance;
	
	}
		
	public String getPlayerName( ) {
		return playerName;
	}
	
	public void setPlayerName( String name ) {
		playerName = name;
	}
	
	public int getPlayerAccountBalance ( ) {
		return playerAccountBalance;
	}
	
	public void setPlayerAccountBalance ( int balance ) {
		playerAccountBalance = balance;
	}
	
	public static String promptForPlayerName( ) 
	// When this function is called, a JOptionPane Dialog Box will open 
	// and ask the player to enter their name
	{
		String name = JOptionPane.showInputDialog("Please enter your name");
		return name;
	}
	
	public void printPlayerInfo( ) {
		
		System.out.println("Player Name: " + getPlayerName() );
		System.out.println("Account Balance: " + getPlayerAccountBalance() );	
	}
}
