
public class Board {

	
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
	
	for (int i = 0; i < 3; ++i) {
				
		for (int j = 0; j < 3; ++j) {
					
			System.out.println( board[i][j] );
					
		}

	}
}
	
	
private int board[][];
//private int boardPositions[][];	
	
}
