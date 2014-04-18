package SlotMachine;

import java.util.Random;

public class SlotMachineConstants {

	public static SpinResult getRandSpinResult() {
		Random r = new Random();
		int num = r.nextInt(1000000);
		num = num % 24;
		SpinResult spinResult = SpinResult.getSpinResult(num);

		return spinResult;
	}
}