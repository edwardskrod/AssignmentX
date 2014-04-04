package SlotMachine;

import java.util.Random;

public class SlotMachineImpl {

	public SlotMachineImpl() {

	}

	public static void spin(Board b) {
		Random r = new Random();
		for (int i = 0; i < 3; ++i) {

			for (int j = 0; j < 3; ++j) {

				int num = r.nextInt(1000000);
				num = num % 31;

				// Call the method that maps the virtual machine
				// to the regular machine
				SpinResult spinResult = SpinResult.getSpinResult(num);
				b.board[i][j] = spinResult;
			} // end inner for loop
		} // end outer for loop
	} // end spin()

	public static boolean isWinner(SpinResult result1, SpinResult result2,
			SpinResult result3)
	/*
	 * This function receives three SpinResults from board[][] and determines
	 * whether a particular row or set of three integers is a winner. For
	 * example, we might call isWinner and check the center row in the following
	 * way: isWinner(board[1][0], board[1][1], board[1][2]); This will check the
	 * center row for a winning combination of integers
	 */

	{
		/*
		 * We might want to implement a lookup table here where the three digits
		 * correspond to a certain pay out (or pay out level.) 000 corresponds
		 * to payout level 1. 111, 222, 333 correspond to payout level 2. If we
		 * have each set of winning numbers correspond to a payout level, then
		 * we can adjust the payout in another structure or switch statement
		 * without having to change the underlying data structure.
		 * 
		 * We might want this function to return an integer that corresponds to
		 * the payout level. Then we can run that integer through a switch
		 * statement to return the $$.
		 * 
		 * Winning Combinations Lucky 7s: 0 0 0 BAR BAR BAR: 1 1 1 BARBAR BARBAR
		 * BARBAR 2 2 2 BARBARBAR BARBARBAR BARABARBAR 3 3 3 MELON MELON MELON 4
		 * 4 4 GRAPE GRAPE GRAPE 5 5 5 BERRY BERRY BERRY 6 6 6 BANANA BANANA
		 * BANANA 7 7 7
		 * 
		 * BAR Combos (3 ^ 3) - 3 = 24 combos { 1 1 2, 1 1 3, 1 2 1, 1 2 2, 1 2
		 * 3, 1 3 1, 1 3 2, 1 3 3, 2 1 1, 2 1 2, 2 1 3, 2 2 1, 2 2 3, 2 3 1, 2 3
		 * 2, 2 3 3, 3 1 1, 3 1 2, 3 1 3, 3 2 1, 3 2 2, 3 2 3, 3 3 1, 3 3 2 }
		 * 
		 * Fruit Combos (3 ^ 4) - 3 = 78 combos { There's got to be an easier
		 * way to do this }
		 */

		return false;
	}

	private int getPayout(int payoutLevel)
	/*
	 * There are 10 payout levels This function allows us to edit the payout
	 * amounts quickly 1 - Lucky7 Lucky7 Lucky7 2 - BAR BAR BAR 3 - BARBAR
	 * BARBAR BARBAR 4 - BARBARBAR BARBARBAR BARABARBAR 5 - Any 3 BARs 6 - MELON
	 * MELON MELON 7 - GRAPE GRAPE GRAPE 8 - BERRY BERRY BERRY 9 - BANANA BANANA
	 * BANANA 10 - Any 3 Fruits
	 * 
	 * Odds of 3 Payout: LUCKY7: 1 / 3723 90% = $3,352 BAR: 1 / 1103 90% = $993
	 * BARBAR: 1 / 1103 90% = $993 BARBARBAR: 1 / 1103 90% = $993 Any BAR: 1 /
	 * 40.86 90% = $36 MELON: 1 / 465.48 90% = $418 GRAPE 1 / 465.48 90% = $418
	 * STRAWBERRY 1 / 465.48 90% = $418 BANANA 1 / 465.48 90% = $418 Any Fruit 1
	 * / 7.27 90% = $6.5
	 */
	{
		int payout = 0;
		switch (payoutLevel) {
		case 1:
			payout = 3000;
			break;
		case 2:
			payout = 1000;
			break;
		case 3:
			payout = 1000;
			break;
		case 4:
			payout = 1000;
			break;
		case 5:
			payout = 35;
			break;
		case 6:
			payout = 400;
			break;
		case 7:
			payout = 400;
			break;
		case 8:
			payout = 400;
			break;
		case 9:
			payout = 400;
			break;
		case 10:
			payout = 5;
			break;
		}
		return payout;
	}
} // end SlotMachineImpl.jav
