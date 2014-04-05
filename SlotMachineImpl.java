package SlotMachine;

import java.util.Random;

public class SlotMachineImpl {

	//payout will equal betAmt * Payout.getPayout(spinResult1, spinResult2, spinResult2)
	private double payoutPercentage, payout, betAmt;
	private boolean winner;
	Board theBoard;
	Player thePlayer;
	public SlotMachineImpl(Player p) {
		this.winner = false;
		this.payout = this.betAmt = this.payoutPercentage = 0;
		this.theBoard = new Board();
		this.thePlayer = p;
	}

	public void spin(int betAmt) {
		this.betAmt = betAmt;
		thePlayer.subrtractFromPlayerAccountBalance((int)this.betAmt);
		Random r = new Random();
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				int num = r.nextInt(1000000);
				num = num % 31;

				// Call the method that maps the virtual machine
				// to the regular machine
				SpinResult spinResult = SpinResult.getSpinResult(num);
				theBoard.setBoard(i, j, spinResult);
			} // end inner for loop
		} // end outer for loop
	} // end spin()

	public boolean isWinner(SpinResult result1, SpinResult result2,
			SpinResult result3){	
		setWin(result1, result2, result3);
		return this.winner;
	}

	private void setWin(SpinResult result1, SpinResult result2,
			SpinResult result3){
		/*
		 * This function receives three SpinResults from board[][] and determines
		 * whether a particular row or set of three integers is a winner. For
		 * example, we might call isWinner and check the center row in the following
		 * way: isWinner(board[1][0], board[1][1], board[1][2]); This will check the
		 * center row for a winning combination of SpinResults
		 */
		Payout payout = new Payout(result1, result2, result3);
		this.payoutPercentage = payout.getPayoutPercentage();
		//adding betAmt to payout because betAmt was subtracted during spin
		this.winner = payout.isWinner();
		if (winner){
			this.payout = (this.payoutPercentage * this.betAmt );
			thePlayer.addToPlayerAccountBalance(this.payout);
			thePlayer.addToPlayerAccountBalance(this.betAmt);
		}
	}

	public double getPayout()
	{
		return this.payout;
	}
	public SpinResult[][] getBoard(){
		return theBoard.getBoard();
	}
	public SpinResult getBoard(int x, int y){
		return theBoard.getBoard(x, y);
	}
	
	public void printBoardWithTokens(){
		theBoard.printBoardWithTokens();
	}
} // end SlotMachineImpl.jav
