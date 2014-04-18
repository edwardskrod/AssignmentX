package SlotMachine;

public class Payout {

	/*
	 * There are 10 payout levels This Class allows us to edit the payout
	 * amounts quickly 1 - Lucky7 Lucky7 Lucky7 2 - BAR BAR BAR 3 - BARBAR
	 * BARBAR BARBAR 4 - BARBARBAR BARBARBAR BARABARBAR 5 - Any 3 BARs 6 - MELON
	 * MELON MELON 7 - GRAPE GRAPE GRAPE 8 - BERRY BERRY BERRY 9 - BANANA BANANA
	 * BANANA 10 - Any 3 Fruits
	 * 
	 * Odds of 3 Payout: LUCKY7: 1 / 3723 90% = $3,352 BAR: 1 / 1103 90% = $993
	 * BARBAR: 1 / 1103 90% = $993 BARBARBAR: 1 / 1103 90% = $993 Any BAR: 1 /
	 * 40.86 90% = $36 MELON: 1 / 465.48 90% = $418 GRAPE 1 / 465.48 90% = $418
	 * STRAWBERRY 1 / 465.48 90% = $418 BANANA 1 / 465.48 90% = $418 Any Fruit 1
	 * / 7.27 90% = $6.5
	 */

	private double payoutPercentage;
	boolean winner;

	Payout(SpinResult sr1, SpinResult sr2, SpinResult sr3) {
		payoutPercentage = 0;
		winner = false;
		setPayout(sr1, sr2, sr3);
	}

	public void setPayout(SpinResult sr1, SpinResult sr2, SpinResult sr3) {
		payoutPercentage = 0;
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
		if (payoutPercentage > 0) {
			winner = true;
		}
		System.out.println("Payout percentage = " + getPayoutPercentage());
	}

	private double getSingleBarPayout(SpinResult sr1, SpinResult sr2,
			SpinResult sr3) {
		double result = 0;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = 50.0;
		} else {
			result = getBarPayout(sr1, sr2, sr3);
		}
		return result;
	}

	private double getDoubleBarPayout(SpinResult sr1, SpinResult sr2,
			SpinResult sr3) {
		double result = 0;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = 80.0;
		} else {
			result = getBarPayout(sr1, sr2, sr3);
		}
		return result;
	}

	private double getTripleBarPayout(SpinResult sr1, SpinResult sr2,
			SpinResult sr3) {
		double result = 0;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = 150.0;
			System.out.println("Payout from tripleBar");
		} else {
			result = getBarPayout(sr1, sr2, sr3);
		}
		return result;
	}

	private double getBarPayout(SpinResult sr1, SpinResult sr2, SpinResult sr3) {
		double result = 0;
		if ((SpinResult.BAR_BAR.equals(sr2)
				|| SpinResult.BAR_BAR_BAR.equals(sr2) || SpinResult.BAR
					.equals(sr2))) {
			if ((SpinResult.BAR_BAR.equals(sr3) || SpinResult.BAR_BAR_BAR
					.equals(sr3)) || SpinResult.BAR.equals(sr3)) {
				result = 3.0;
			}

			System.out.println("All not equal");
		}
		return result;
	}

	private double getJavaPayout(SpinResult sr1, SpinResult sr2, SpinResult sr3) {
		double result = 0;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = 1300.0;
		}
		return result;
	}

	private double getLuckySevenPayout(SpinResult sr1, SpinResult sr2,
			SpinResult sr3) {
		double result = 0;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = 400.0;
		}
		return result;
	}

	public boolean isWinner() {
		return winner;
	}

	public double getPayoutPercentage() {
		return payoutPercentage;
	}

	// private static boolean checkForBar()
}