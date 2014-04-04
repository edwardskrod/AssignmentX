package SlotMachine;

import java.util.Random;

public class SlotMachineImpl {

	//payout will equal betAmt * Payout.getPayout(spinResult1, spinResult2, spinResult2)
	private double payoutPercentage, payout, betAmt;
	private boolean winner;
	public SlotMachineImpl(Board b) {
		this.winner = false;
		this.payout = this.betAmt = this.payoutPercentage = 0;
		spin(b);
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

	private void setWin(SpinResult result1, SpinResult result2,
			SpinResult result3){
		/*
		 * This function receives three SpinResults from board[][] and determines
		 * whether a particular row or set of three integers is a winner. For
		 * example, we might call isWinner and check the center row in the following
		 * way: isWinner(board[1][0], board[1][1], board[1][2]); This will check the
		 * center row for a winning combination of integers
		 */
		Payout payout = new Payout(result1, result2, result3);
		this.payoutPercentage = payout.getPayoutPercentage();
		this.winner = payout.isWinner();
	}
	public boolean isWinner(SpinResult result1, SpinResult result2,
			SpinResult result3){	
		setWin(result1, result2, result3);
		return this.winner;
	}

	public double getPayout(double betAmt)
	{
		this.payout = betAmt * payoutPercentage;
		return this.payout;
	}
} // end SlotMachineImpl.jav
