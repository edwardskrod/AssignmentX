package SlotMachine;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/*  We are using a virtual reel in order to more accurately control the
* probability of getting any three numbers.  
* This function receives an integer from 0 - 23 
* The number corresponds to a number on the reel, 0 - 8.
*            Odds:	    Odds of getting 3 	Payout:
* JAVA       2 / 23      1 / 1520       	$1300
* LUCKY7     3 / 23        1 / 450         	$400
* BARBARBAR: 4 / 23      1 / 190     	    $150
* BARBAR:    5 / 23      1 / 97              $80
* BAR:       6 / 23      1 / 56.32           $50
* BLANK      3 / 23      1 / 450          nothing
*/


public enum SpinResult {
//	new ImageIcon (getClass().getResource( "Java-bug.jpg" ))

	JAVA("JAVA", 0, 1, "Java-bug.jpg", "java-bugBlur.jpg"),
	LUCKY_SEVEN("LUCKY7", 2, 3, 4, "7.jpg", "7Blur.jpg"), 
	BAR("BAR", 5, 6, 7, 8, 9, 10, "bar.jpg", "barBlur.jpg"), 
	BAR_BAR("BARBAR", 11, 12, 13, 14, 15, "barbar.jpg", "barbarBlur.jpg"), 
	BAR_BAR_BAR("BARBARBAR", 16, 17, 18, 19, "barbarbar.jpg", "barbarbarBlur.jpg"), 
	BLANK("BLANK", 20, 21, 22, 23, "BLANK.jpg", "BLANK.jpg"), 
	UNKNOWN("UNKNOWN");

	private int spinResult1, spinResult2, spinResult3, spinResult4,
			spinResult5, spinResult6;
	private String icon, blurredIcon;
	private String name;
	private static final int IMPOSSIBLE_MATCH = 999;

	// constructors
	SpinResult(String name) {
		setSpin(name, IMPOSSIBLE_MATCH, IMPOSSIBLE_MATCH, IMPOSSIBLE_MATCH,
				IMPOSSIBLE_MATCH, IMPOSSIBLE_MATCH, IMPOSSIBLE_MATCH, "",
				"");
	}

	SpinResult(String name, int spinResult1, int spinResult2, String icon,
			String blurredIcon) {
		setSpin(name, spinResult1, spinResult2, IMPOSSIBLE_MATCH,
				IMPOSSIBLE_MATCH, IMPOSSIBLE_MATCH, IMPOSSIBLE_MATCH, icon,
				blurredIcon);
	}

	SpinResult(String name, int spinResult1, int spinResult2, int spinResult3,
			String icon, String blurredIcon) {
		setSpin(name, spinResult1, spinResult2, spinResult3, IMPOSSIBLE_MATCH,
				IMPOSSIBLE_MATCH, IMPOSSIBLE_MATCH, icon, blurredIcon);
	}

	SpinResult(String name, int spinResult1, int spinResult2, int spinResult3,
			int spinResult4, String icon, String blurredIcon) {
		setSpin(name, spinResult1, spinResult2, spinResult3, spinResult4,
				IMPOSSIBLE_MATCH, IMPOSSIBLE_MATCH, icon, blurredIcon);
	}

	SpinResult(String name, int spinResult1, int spinResult2, int spinResult3,
			int spinResult4, int spinResult5, String icon, String blurredIcon) {
		setSpin(name, spinResult1, spinResult2, spinResult3, spinResult4,
				spinResult5, IMPOSSIBLE_MATCH, icon, blurredIcon);
	}

	SpinResult(String name, int spinResult1, int spinResult2, int spinResult3,
			int spinResult4, int spinResult5, int spinResult6, String icon,
			String blurredIcon) {
		setSpin(name, spinResult1, spinResult2, spinResult3, spinResult4,
				spinResult5, spinResult6, icon, blurredIcon);
	}

	private void setSpin(String name, int spinResult1, int spinResult2,
			int spinResult3, int spinResult4, int spinResult5, int spinResult6,
			String icon, String blurredIcon) {
		this.name = name;
		this.spinResult1 = spinResult1;
		this.spinResult2 = spinResult2;
		this.spinResult3 = spinResult3;
		this.spinResult4 = spinResult4;
		this.spinResult5 = spinResult5;
		this.spinResult6 = spinResult6;
		this.icon = icon;
		this.blurredIcon = blurredIcon;
//		this.icon = new ImageIcon (getClass().getResource( icon ));
//		this.blurredIcon = new ImageIcon (getClass().getResource( blurredIcon ));
	}

	public String getSpinName() {
		return this.name;
	}

	public String getIcon() {
		return this.icon;
	}

	public String getBlurredIcon() {
		return this.blurredIcon;
	}

	public static SpinResult getSpinResult(int spin) {
		SpinResult result = UNKNOWN;
		for (SpinResult type : values()) {
			if ((spin == type.spinResult1) || (spin == type.spinResult2)
					|| (spin == type.spinResult3) || (spin == type.spinResult4)
					|| (spin == type.spinResult5) || (spin == type.spinResult6)) {
				result = type;
				break;
			}
		}
		return result;
	}
}
