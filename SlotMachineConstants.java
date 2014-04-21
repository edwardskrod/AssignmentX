package SlotMachine;

import java.util.Random;

public class SlotMachineConstants {

	public static int GB_TOP_LEFT = 9;
	public static int GB_TOP_MIDDLE = 10;
	public static int GB_TOP_RIGHT = 11;
	public static int GB_MIDDLE_LEFT = 17;
	public static int GB_MIDDLE_MIDDLE = 18;
	public static int GB_MIDDLE_RIGHT = 19;
	public static int GB_BOTTOM_LEFT = 25;
	public static int GB_BOTTOM_MIDDLE = 26;
	public static int GB_BOTTOM_RIGHT = 27;

	public static int SELECTION_DIAG_ONE = 0;
	public static int SELECTION_TOP_ROW = 8;
	public static int SELECTION_MIDDLE_ROW = 16;
	public static int SELECTION_BOTTOM_ROW = 24;
	public static int SELECTION_DIAG_TWO = 32;
	public static int SELECTION_SPIN_PART1 = 59;
	public static int SELECTION_SPIN_PART2 = 60;
	public static int SELECTION_NEW_FILE = 63;
	
	public static int SELECTION_ACCOUNT_VAL1 = 56;
	public static int SELECTION_ACCOUNT_VAL2 = 57;
	
	public static int MAX_ROW_SIZE = 8;
	public static int MAX_COLUMN_SIZE = 8;
	
	public static int GRID_BAG_SIZE = 64;
	
	public static int SPIN_200_TIMES = 200;
	public static int LAST_SPIN = 199;
	
	public static int INDEX_ZERO = 0;
	public static int INDEX_ONE = 1;
	public static int INDEX_TWO = 2;



	public static String STRING_DIAG_ONE_IMAGE_TRUE = "slotMachineSelected_01.jpg";
	public static String STRING_TOP_ROW_IMAGE_TRUE = "slotMachineSelected_09.jpg";
	public static String STRING_MIDDLE_ROW_IMAGE_TRUE = "slotMachineSelected_17.jpg";
	public static String STRING_BOTTOM_ROW_IMAGE_TRUE = "slotMachineSelected_25.jpg";
	public static String STRING_DIAG_TWO_IMAGE_TRUE = "slotMachineSelected_33.jpg";

	public static String STRING_DIAG_ONE_IMAGE_FALSE = "slotMachine_01.jpg";
	public static String STRING_TOP_ROW_IMAGE_FALSE = "slotMachine_09.jpg";
	public static String STRING_MIDDLE_ROW_IMAGE_FALSE = "slotMachine_17.jpg";
	public static String STRING_BOTTOM_ROW_IMAGE_FALSE = "slotMachine_25.jpg";
	public static String STRING_DIAG_TWO_IMAGE_FALSE = "slotMachine_33.jpg";

	public static String ACCOUNT_VALUE_HTML = "<body style=\"background:#F77517;\"> <p style=\"padding:8px; color:white; font-family: sans-serif; font-size: 18px;\">Account Value: ";
	public static String ACCOUNT_VALUE_HTML_END = "</p></body>"; 
	public static SpinResult getRandSpinResult() {
		Random r = new Random();
		int num = r.nextInt(1000000);
		num = num % 24;
		SpinResult spinResult = SpinResult.getSpinResult(num);

		return spinResult;
	}
}