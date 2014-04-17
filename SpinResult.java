package SlotMachine;

/*  We are using a virtual reel in order to more accurately control the
* probability of getting any three numbers.  
* This function receives an integer from 0 - 30 
* The number corresponds to a number on the reel, 0 - 8.
* Odds:				    Odds of getting 3 in a row		  				 Payout:
* 
* 12,167
* 
* JAVA       2 / 23     Odds of 3:	  8 / 12,167    1 / 1520	$1350
* LUCKY7     3 / 23     Odds of 3:   27 / 12,167    1 / 450     $405
* BARBARBAR: 4 / 23     Odds of 3:   64 / 12,167  	1 / 190     $171
* BARBAR:    5 / 23     Odds of 3:  125 / 12,167  	1 / 97      $87
* BAR:       6 / 23     Odds of 3:  216 / 12,167  	1 / 56.32	$50
* Any BAR:   15 / 23    Odds of 3: 3375 / 12167   	1 / 3.6	   	$3	 
* BLANK      3 / 23     Odds of 3:   27 / 12,167	1 / 450     nothing
* 
* 
* 
* 
*/

public enum SpinResult {

	LUCKY_SEVEN("LUCKY7", 0, 1), 
	BAR("BAR", 2, 3, 4), 
	BAR_BAR("BARBAR", 5, 6, 7), 
	BAR_BAR_BAR("BARBARBAR", 8, 9, 10), 
	MELON("MELON", 11, 12, 13, 14), 
	GRAPE("GRAPE", 15, 16, 17, 18), 
	BERRY("BERRY", 19, 20, 21, 22), 
	BANANA("BANANA", 23, 24, 25, 26), 
	BLANK("BLANK", 27, 28, 29, 30), 
	UNKNOWN("UNKNOWN");

	private int spinResult1, spinResult2, spinResult3, spinResult4;
	private String name;
	private static final int IMPOSSIBLE_MATCH = 999;
	
	//constructors
	SpinResult(String name) {
		setSpin(name, IMPOSSIBLE_MATCH,IMPOSSIBLE_MATCH,IMPOSSIBLE_MATCH,IMPOSSIBLE_MATCH);
	}

	SpinResult(String name, int spinResult1, int spinResult2) {
		setSpin(name, spinResult1, spinResult2, IMPOSSIBLE_MATCH, IMPOSSIBLE_MATCH);
	}

	SpinResult(String name, int spinResult1, int spinResult2, int spinResult3) {
		setSpin(name, spinResult1, spinResult2, spinResult3, IMPOSSIBLE_MATCH);
	}

	SpinResult(String name, int spinResult1, int spinResult2, int spinResult3,
			int spinResult4) {
		setSpin(name, spinResult1, spinResult2, spinResult3, spinResult4);

	}

	private void setSpin(String name, int spinResult1, int spinResult2, int spinResult3,
			int spinResult4) {
		this.name = name;
		this.spinResult1 = spinResult1;
		this.spinResult2 = spinResult2;
		this.spinResult3 = spinResult3;
		this.spinResult4 = spinResult4;
	}
	
	public String getSpinName(){
		return this.name;
	}

	public static SpinResult getSpinResult(int spin) {
		SpinResult result = UNKNOWN;
		for (SpinResult type : values()) {
			if ((spin == type.spinResult1) || (spin == type.spinResult2)
					|| (spin == type.spinResult3) || (spin == type.spinResult4)) {
				result = type;
				break;
			}
		}
		return result;
	}
}
