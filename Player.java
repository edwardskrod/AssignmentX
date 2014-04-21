package SlotMachine;

import javax.swing.JOptionPane;

public class Player {

	private String playerName;
	private double playerAccountBalance;
	
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
	
	public double getPlayerAccountBalance ( ) {
		return playerAccountBalance;
	}
	
	public void setPlayerAccountBalance ( double balance ) {
		playerAccountBalance = balance;
	}
	public void addToPlayerAccountBalance(double addAmt){
		playerAccountBalance += addAmt;
	}
	
	public void subrtractFromPlayerAccountBalance(double subAmt){
		playerAccountBalance -= subAmt;
	}
	
	public static String promptForPlayerName( ) 
	// When this function is called, a JOptionPane Dialog Box will open 
	// and ask the player to enter their name
	{
		String name = JOptionPane.showInputDialog("Please enter your name");
		return name;
	}
	
	public void incrementAccountBalance(){
		playerAccountBalance++;
	}
	public void decrementAccountBalance(){
		playerAccountBalance--;
	}
	
	public void printPlayerInfo( ) {
		
		System.out.println("Player Name: " + getPlayerName() );
		System.out.println("Account Balance: " + getPlayerAccountBalance() );	
	}
}
