package SlotMachine;

import java.util.Map;
import java.util.Random;

import org.omg.CORBA.UNKNOWN;

public class SlotMachineImpl {

	// payout will equal betAmt * Payout.getPayout(spinResult1, spinResult2,
	// spinResult2)
	private double payoutPercentage, payout, betAmt;
	private boolean winner;
	private Map<String, int[][]> userSelections;
	Board theBoard;
	Player thePlayer;

	public SlotMachineImpl(Player p) {
		this.winner = false;
		this.payout = this.betAmt = this.payoutPercentage = 0;
		this.theBoard = new Board();
		this.thePlayer = p;
	}

	public void spin(int betAmt, Map<String, int[][]> userSelections) {
		
		this.userSelections = userSelections;
		System.out.println("userSelections.isEmpty() = " + userSelections.isEmpty());
		this.betAmt = betAmt;
		System.out.println(this.betAmt);

		int linesSelected = 1;
		SpinResult position1, position2, position3;
		generateSpinAndSetBoard();
		int[][] singleRow;
		for (Map.Entry<String, int[][]> winningCombo : userSelections
				.entrySet()) {
			singleRow = winningCombo.getValue();

			setWin(getRow(singleRow));
			linesSelected++;
		}
		System.out.println("this.betAmt * userSelections.size() = " + this.betAmt * userSelections.size());
		thePlayer.subrtractFromPlayerAccountBalance((int) this.betAmt * userSelections.size());

		if (isWinner()){
			thePlayer.addToPlayerAccountBalance(this.payout);
			thePlayer.addToPlayerAccountBalance(this.betAmt);
		}

	} // end spin()

	public boolean isWinner() {
		return this.winner;
	}

//	private void setPayout(SpinResult result1, SpinResult result2,
//			SpinResult result3) {
//
//	}

	private void setWin(SpinResult[] spinResult) {
		setWin(spinResult[0], spinResult[1], spinResult[2]);
	}

	private void setWin(SpinResult result1, SpinResult result2,
			SpinResult result3) {
		/*
		 * This function receives three SpinResults from board[][] and
		 * determines whether a particular row or set of three integers is a
		 * winner. For example, we might call isWinner and check the center row
		 * in the following way: isWinner(board[1][0], board[1][1],
		 * board[1][2]); This will check the center row for a winning
		 * combination of SpinResults
		 */
		Payout payout = new Payout(result1, result2, result3);
		this.payoutPercentage = payout.getPayoutPercentage();
		// adding betAmt to payout because betAmt was subtracted during spin
		if (!winner) {
			this.winner = payout.isWinner();
		}
		if (winner) {
			this.payout += (this.payoutPercentage * this.betAmt);
		}
	}

	private void generateSpinAndSetBoard() {
		Random r = new Random();
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				int num = r.nextInt(1000000);
				num = num % 24;

				// Call the method that maps the virtual machine
				// to the regular machine
				SpinResult spinResult = SpinResult.getSpinResult(num);
				theBoard.setBoardPosition(i, j, spinResult);
			} // end inner for loop
		} // end outer for loop
	}

	public double getPayout() {
		return this.payout;
	}

	public SpinResult[][] getBoard() {
		return theBoard.getBoard();
	}

	public SpinResult getBoardPosition(int[] xy) {
		// xy[0] = x, xy[1] = y;
		SpinResult result = SpinResult.UNKNOWN;
		if (xy.length == 2) {
			result = theBoard.getBoardPosition(xy[0], xy[1]);
		}
		return result;
	}

	public SpinResult[] getRow(int[][] selection) {
		SpinResult[] winningCombo = new SpinResult[3];
		winningCombo[0] = theBoard.getBoardPosition(selection[0][0], selection[0][1]);
		winningCombo[1] = theBoard.getBoardPosition(selection[1][0], selection[1][1]);
		winningCombo[2] = theBoard.getBoardPosition(selection[2][0], selection[2][1]);

		return winningCombo;
	}

	public void printBoardWithTokens() {
		theBoard.printBoardWithTokens();
	}
} // end SlotMachineImpl.jav
