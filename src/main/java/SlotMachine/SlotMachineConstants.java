package SlotMachine;

import java.util.Random;

public class SlotMachineConstants {

	/*
	 * These constant numbers correspond to the positions in the
	 * array which is used to form the grid bag frame
	 * Used in SlotMachineGridBagFrame
	 * 
	 */
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


	/*
	 * Directory URL for images
	 */
	public static String IMAGES_URL = "images/";

	/*  Payline Buttons:
	 * The "selected" version are the orange buttons.
	 * The regular versions are blue.
	 */
	public static String STRING_DIAG_ONE_IMAGE_TRUE = IMAGES_URL + "slotMachineSelected_01.jpg";
	public static String STRING_TOP_ROW_IMAGE_TRUE = IMAGES_URL + "slotMachineSelected_09.jpg";
	public static String STRING_MIDDLE_ROW_IMAGE_TRUE = IMAGES_URL + "slotMachineSelected_17.jpg";
	public static String STRING_BOTTOM_ROW_IMAGE_TRUE = IMAGES_URL + "slotMachineSelected_25.jpg";
	public static String STRING_DIAG_TWO_IMAGE_TRUE = IMAGES_URL + "slotMachineSelected_33.jpg";
	public static String STRING_DIAG_ONE_IMAGE_FALSE = IMAGES_URL + "slotMachine_01.jpg";
	public static String STRING_TOP_ROW_IMAGE_FALSE = IMAGES_URL + "slotMachine_09.jpg";
	public static String STRING_MIDDLE_ROW_IMAGE_FALSE = IMAGES_URL + "slotMachine_17.jpg";
	public static String STRING_BOTTOM_ROW_IMAGE_FALSE = IMAGES_URL + "slotMachine_25.jpg";
	public static String STRING_DIAG_TWO_IMAGE_FALSE = IMAGES_URL + "slotMachine_33.jpg";

	/*
	 * HTML for use in the JEditorPane which contains the account balance
	 * 
	 */
	public static String ACCOUNT_VALUE_HTML = "<body style=\"background:#F77517;\"> " +
			"<p style=\"padding:8px; color:white; font-family: sans-serif; font-size: 18px;\">Account Value: ";
	public static String ACCOUNT_VALUE_HTML_END = "</p></body>"; 
	
	
	/* Payouts 
	 * Used by Payout.java
	 */
	public static int DEFAULT_STARTING_BALANCE = 100;
	public static int VIRTUAL_REEL_NUMBER = 24;
	public static double ZERO = 0.0;
	public static double ANY_BAR_PAYOUT = 3.0;
	public static double BAR_PAYOUT = 50.0;
	public static double BAR_BAR_PAYOUT = 80.0;
	public static double BAR_BAR_BAR_PAYOUT = 150.0;
	public static double LUCKY7_PAYOUT = 400.0;
	public static double JAVA_PAYOUT = 1300.0;
	
	/* Slot Machine Icon Images
	 * Used by SpinResult.java
	 */
	public static String JAVA_ICON = IMAGES_URL +"Java-bug.jpg";
	public static String JAVA_ICON_BLURRED = IMAGES_URL +"java-bugBlur.jpg";
	public static String LUCKY7_ICON = IMAGES_URL + "7.jpg";
	public static String LUCKY7_ICON_BLURRED = IMAGES_URL + "7Blur.jpg";
	public static String BAR_ICON = IMAGES_URL + "bar.jpg";
	public static String BAR_ICON_BLURRED = IMAGES_URL + "barBlur.jpg";
	public static String BAR_BAR_ICON = IMAGES_URL + "barbar.jpg";
	public static String BAR_BAR_ICON_BLURRED = IMAGES_URL + "barbarBlur.jpg";
	public static String BAR_BAR_BAR_ICON = IMAGES_URL + "barbarbar.jpg";
	public static String BAR_BAR_BAR_ICON_BLURRED = IMAGES_URL + "barbarbarBlur.jpg";
	public static String BLANK = IMAGES_URL + "BLANK.jpg";

	
	
	public static SpinResult getRandSpinResult() {
		Random r = new Random();
		int num = r.nextInt(1000000);
		num = num % VIRTUAL_REEL_NUMBER;

		SpinResult spinResult = SpinResult.getSpinResult(num);
		return spinResult;
	}
}