
public class Board {

	// Constructor creates a new Board 
	// 0 | 0 | 0
	// 0 | 0 | 0
	// 0 | 0 | 0
	
	public Board( )
	{
		
		board = new int [3][3];
		
		for (int i = 0; i < 3; ++i) {
			
			for (int j = 0; j < 3; ++j) {
				
				board[i][j] = 0;
			}
		}
			
	}
			
	
	public void printBoard() {
		
		final String divider = "------------";
		
		System.out.printf("%s", "Slot Machine:\n");
		System.out.println();
		System.out.printf("  %d | %d | %d\n",
				this.board[0][0],this.board[0][1],this.board[0][2] );
		System.out.printf("%s\n", divider);
		System.out.printf("  %d | %d | %d\n",
				this.board[1][0],this.board[1][1],this.board[1][2]);
		System.out.printf("%s\n", divider);
		System.out.printf("  %d | %d | %d\n\n",
				this.board[2][0],this.board[2][1],this.board[2][2]);	
}

	
public int board[][];
//private int boardPositions[][];	
	
}
