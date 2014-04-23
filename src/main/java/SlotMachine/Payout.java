package SlotMachine;

/*
* There are 6 payout levels This Class allows us to edit the payout
* amounts quickly 
* 1 - Java Java Java 
* 2- Lucky7 Lucky7 Lucky7 
* 3 - BARBARBAR BARBARBAR BARABARBAR 
 * 4 - BARBAR BARBAR BARBAR 
* 5 - BAR BAR BAR 	 
* 6 - Any 3 BARs 
* 
* We are using a virtual reel in order to more accurately control the
* probability of getting any three numbers.  
* This function receives an integer from 0 - 23 
* The number corresponds to a number on the reel, 0 - 8.
* 
*            Odds:	    Odds of getting 3 	Payout:
* JAVA       2 / 23      1 / 1520       	$1300
* LUCKY7     3 / 23        1 / 450         	$400
* BARBARBAR: 4 / 23      1 / 190     	    $150
* BARBAR:    5 / 23      1 / 97              $80
* BAR:       6 / 23      1 / 56.32           $50
* BLANK      3 / 23      1 / 450          nothing
 */

public class Payout {

	private double payoutPercentage;
	boolean winner;

	Payout(SpinResult sr1, SpinResult sr2, SpinResult sr3) {
		payoutPercentage = SlotMachineConstants.ZERO;
		winner = false;
		setPayout(sr1, sr2, sr3);
	}

	public void setPayout(SpinResult sr1, SpinResult sr2, SpinResult sr3) {
		payoutPercentage = SlotMachineConstants.ZERO;
		switch (sr1) {
		case BAR:
			payoutPercentage = getSingleBarPayout(sr1, sr2, sr3);
			break;
		case BAR_BAR:
			payoutPercentage = getDoubleBarPayout(sr1, sr2, sr3);
			break;
		case BAR_BAR_BAR:
			payoutPercentage = getTripleBarPayout(sr1, sr2, sr3);
			break;
		case JAVA:
			payoutPercentage = getJavaPayout(sr1, sr2, sr3);
		case LUCKY_SEVEN:
			payoutPercentage = getLuckySevenPayout(sr1, sr2, sr3);
			break;
		case BLANK:
			break;
		default:
			break;
		}
		if (payoutPercentage > SlotMachineConstants.ZERO) {
			winner = true;
		}
		System.out.println("Payout percentage = " + getPayoutPercentage());
	}

	
	private double getSingleBarPayout(SpinResult sr1, SpinResult sr2,
			SpinResult sr3) {
		double result = SlotMachineConstants.ZERO;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = SlotMachineConstants.BAR_PAYOUT;
		} else {
			result = getBarPayout(sr1, sr2, sr3);
		}
		return result;
	}

	private double getDoubleBarPayout(SpinResult sr1, SpinResult sr2,
			SpinResult sr3) {
		double result = SlotMachineConstants.ZERO;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = SlotMachineConstants.BAR_BAR_PAYOUT;
		} else {
			result = getBarPayout(sr1, sr2, sr3);
		}
		return result;
	}

	private double getTripleBarPayout(SpinResult sr1, SpinResult sr2,
			SpinResult sr3) {
		double result = SlotMachineConstants.ZERO;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = SlotMachineConstants.BAR_BAR_BAR_PAYOUT;
			System.out.println("Payout from tripleBar");
		} else {
			result = getBarPayout(sr1, sr2, sr3);
		}
		return result;
	}

	private double getBarPayout(SpinResult sr1, SpinResult sr2, SpinResult sr3) {
		double result = SlotMachineConstants.ZERO;
		if ((SpinResult.BAR_BAR.equals(sr2)
				|| SpinResult.BAR_BAR_BAR.equals(sr2) || SpinResult.BAR
					.equals(sr2))) {
			if ((SpinResult.BAR_BAR.equals(sr3) || SpinResult.BAR_BAR_BAR
					.equals(sr3)) || SpinResult.BAR.equals(sr3)) {
				result = SlotMachineConstants.ANY_BAR_PAYOUT;
			}

			System.out.println("All not equal");
		}
		return result;
	}

	private double getJavaPayout(SpinResult sr1, SpinResult sr2, SpinResult sr3) {
		double result = SlotMachineConstants.ZERO;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = SlotMachineConstants.JAVA_PAYOUT;
		}
		return result;
	}

	private double getLuckySevenPayout(SpinResult sr1, SpinResult sr2,
			SpinResult sr3) {
		double result = SlotMachineConstants.ZERO;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = SlotMachineConstants.LUCKY7_PAYOUT;
		}
		return result;
	}

	public boolean isWinner() {
		return winner;
	}

	public double getPayoutPercentage() {
		return payoutPercentage;
	}
}