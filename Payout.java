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
			payoutPercentage = getBarPayout(sr1, sr2, sr3);
			break;
		case BAR_BAR:
			payoutPercentage = getBarPayout(sr1, sr2, sr3);
			break;
		case BAR_BAR_BAR:
			payoutPercentage = getBarPayout(sr1, sr2, sr3);
			break;
		case BANANA:
			payoutPercentage = getFruitPayout(sr1, sr2, sr3);
		case BERRY:
			payoutPercentage = getFruitPayout(sr1, sr2, sr3);
		case GRAPE:
			payoutPercentage = getFruitPayout(sr1, sr2, sr3);
		case MELON:
			payoutPercentage = getFruitPayout(sr1, sr2, sr3);
		case LUCKY_SEVEN:
			payoutPercentage = getLuckySevenPayout(sr1, sr2, sr3);
		case BLANK:
			break;
		default:
			break;
		}
		if (payoutPercentage > 0) {
			winner = true;
		}
	}

	private double getBarPayout(SpinResult sr1, SpinResult sr2, SpinResult sr3) {
		double result = 0;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = 1000.0;
		} else if ((SpinResult.BAR_BAR.equals(sr2)
				|| SpinResult.BAR_BAR_BAR.equals(sr2) || SpinResult.BAR
					.equals(sr2))
				&& (SpinResult.BAR_BAR.equals(sr2) || SpinResult.BAR_BAR_BAR
						.equals(sr2)) || SpinResult.BAR.equals(sr3))
			;
		{
			result = 35.0;
		}
		return result;
	}

	private double getFruitPayout(SpinResult sr1, SpinResult sr2, SpinResult sr3) {
		double result = 0;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = 400.0;
		} else if ((SpinResult.BANANA.equals(sr2)
				|| SpinResult.BERRY.equals(sr2) || SpinResult.GRAPE.equals(sr2) || SpinResult.MELON
					.equals(sr2))
				&& (SpinResult.BANANA.equals(sr3)
						|| SpinResult.BERRY.equals(sr3)
						|| SpinResult.GRAPE.equals(sr3) || SpinResult.MELON
							.equals(sr3)))
			;
		{
			result = 5.0;
		}
		return result;
	}

	private double getLuckySevenPayout(SpinResult sr1, SpinResult sr2,
			SpinResult sr3) {
		double result = 0;
		if (sr1.equals(sr2) && sr2.equals(sr3)) {
			result = 3000.0;
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