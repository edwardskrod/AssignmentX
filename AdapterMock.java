package SlotMachine;

import java.util.Scanner;

public class AdapterMock {
	public static void main(String[] args) {

		Player thePlayer = new Player();
		FileHandler.getAccountInformation(thePlayer);
		SlotMachineImpl play;

		play = new SlotMachineImpl(thePlayer);
		System.out.println("Player account balance before bet = "
				+ thePlayer.getPlayerAccountBalance());
		
		/*
		 * row object will be called from event handler tied to UI
		 */
		
		SelectedRow row = new SelectedRow();
		
		//There will be a button to the left of the top row
		row.toggleTopRow();
		//There will be a button to the left of the top row
		row.toggleMiddleRow();
		row.toggleBottomRow();
		row.toggleDiagOne();
		row.toggleDiagTwo();
		row.toggleTopRow();
		//There will be a button to the left of the top row
		row.toggleMiddleRow();
		row.toggleBottomRow();
		row.toggleDiagOne();
		row.toggleDiagTwo();
		row.toggleTopRow();
		//There will be a button to the left of the top row
		row.toggleMiddleRow();
		row.toggleBottomRow();
		row.toggleDiagOne();
		row.toggleDiagTwo();


//		row.toggleTopRow();
		//There will be a button to the left of the top row

		
		play.spin(1, row.getData());

		play.printBoardWithTokens();
		System.out.println("isWiner = " + play.isWinner());
		System.out.println("Payout = " + play.getPayout());
		System.out.println("Player account balance after bet = " + thePlayer.getPlayerAccountBalance());

		// Save the winning in the file
		FileHandler.saveAccountInformation(thePlayer);

		// Print the player info to console
		thePlayer.printPlayerInfo();

	} // end public static void main()

}
