// entrance to program

public class SlotMachine {


	
	public static void main (String [] args ) {
		
		Board b = new Board();
		
		SlotMachineImpl.spin(b);
		b.printBoard();
	}

}
