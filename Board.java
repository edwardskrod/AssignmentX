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

		// System.out.printf("%s", "Slot Machine:\n");
		// System.out.println();
		// System.out.printf("  %d | %d | %d\n",
		// this.board[0][0],this.board[0][1],this.board[0][2] );
		// System.out.printf("%s\n", divider);
		// System.out.printf("  %d | %d | %d\n",
		// this.board[1][0],this.board[1][1],this.board[1][2]);
		// System.out.printf("%s\n", divider);
		// System.out.printf("  %d | %d | %d\n\n",
		// this.board[2][0],this.board[2][1],this.board[2][2]);
	}

	public void printBoardWithTokens() {

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

	public void setBoard(int x, int y, SpinResult s){
		board[x][y] = s;
	}

	public SpinResult[][] getBoard(){
		return board;
	}
	public SpinResult getBoard(int x, int y){
		return board[x][y];
	}
}
