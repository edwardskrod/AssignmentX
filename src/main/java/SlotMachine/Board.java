package SlotMachine;

public class Board {
	SpinResult board[][];

	/*
	 *  Constructor creates a new board which is a 2D array of SpinResults
	 */

	public Board() {
		board = new SpinResult[3][3];
	}

	public void printBoard() {

		final String divider = "------------";
	}

	public void printBoardWithTokens() {

		//FOR CONSOLE TESTING
		final String divider = "------------";
		final String divider2 = "-------------------------------------------------";

		System.out.printf("%s", "Slot Machine:\n");
		System.out.println();

		System.out.printf("%10s | %10s | %10s\n",
				this.board[0][0].getSpinName(), this.board[0][1].getSpinName(),
				this.board[0][2].getSpinName());

		System.out.printf("%s\t\t\t%s\n", divider, divider2);
		System.out.printf("%10s | %10s | %10s\n",
				this.board[1][0].getSpinName(), this.board[1][1].getSpinName(),
				this.board[1][2].getSpinName());

		System.out.printf("%s\t\t\t%s\n", divider, divider2);
		System.out.printf("%10s | %10s | %10s\n\n",
				this.board[2][0].getSpinName(), this.board[2][1].getSpinName(),
				this.board[2][2].getSpinName());
	}

	public void setBoardPosition(int x, int y, SpinResult s){
		board[x][y] = s;
	}

	public SpinResult[][] getBoard(){
		return board;
	}
	public SpinResult getBoardPosition(int x, int y){
		return board[x][y];
	}
}
