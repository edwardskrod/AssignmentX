package SlotMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SelectedRow {

	private static final int[][] TOP_ROW = new int[][] { { 0, 0 }, { 0, 1 },
			{ 0, 2 } };
	private static final int[][] MIDDLE_ROW = new int[][] { { 1, 0 }, { 1, 1 },
			{ 1, 2 } };
	private static final int[][] BOTTOM_ROW = new int[][] { { 2, 0 }, { 2, 1 },
			{ 2, 2 } };
	private static final int[][] DIAG_ONE = new int[][] { { 0, 0 }, { 1, 1 },
			{ 2, 2 } }; // top rt-bottom left
	private static final int[][] DIAG_TWO = new int[][] { { 0, 2 }, { 1, 1 },
			{ 2, 0 } }; // top left-bottom rt
	private static final String TOP_ROW_KEY = "Top Row";
	private static final String MIDDLE_ROW_KEY = "Middle Row";
	private static final String BOTTOM_ROW_KEY = "Bottom Row";
	private static final String DIAG_ONE_KEY = "Diag One"; // top rt-bottom left
	private static final String DIAG_TWO_KEY = "Diag Two"; // top left-bottom rt
	private Map<String, int[][]> selections = new HashMap<String, int[][]>();

	private boolean topRow, middleRow, bottomRow, diagOne, diagTwo;

	public SelectedRow() {
		init();
	}

	public void toggleTopRow() {
		this.topRow = !this.topRow; // if selected deselect
		if (topRow) {
			selections.put(TOP_ROW_KEY, TOP_ROW);
		} else {
			if (selections.containsKey(TOP_ROW_KEY)) {
				selections.remove(TOP_ROW_KEY);
			}
		}
	}

	public void toggleMiddleRow() {
		this.middleRow = !this.middleRow; // if selected deselect
		if (this.middleRow) {
			selections.put(MIDDLE_ROW_KEY, MIDDLE_ROW);
		} else {
			if (selections.containsKey(MIDDLE_ROW_KEY)) {
				selections.remove(MIDDLE_ROW_KEY);
			}
		}
	}

	public void toggleBottomRow() {
		this.bottomRow = !this.bottomRow; // if selected deselect
		if (bottomRow) {
			selections.put(BOTTOM_ROW_KEY, BOTTOM_ROW);
		} else {
			if (selections.containsKey(BOTTOM_ROW_KEY)) {
				selections.remove(BOTTOM_ROW_KEY);
			}
		}
	}

	public void toggleDiagOne() {
		this.diagOne = !this.diagOne; // if selected deselect
		if (diagOne) {
			selections.put(DIAG_ONE_KEY, DIAG_ONE);
		} else {
			if (selections.containsKey(DIAG_ONE_KEY)) {
				selections.remove(DIAG_ONE_KEY);
			}
		}
	}

	public void toggleDiagTwo() {
		this.diagTwo = !this.diagTwo; // if selected deselect
		if (diagTwo) {
			selections.put(DIAG_TWO_KEY, DIAG_TWO);
		} else {
			if (selections.containsKey(DIAG_TWO_KEY)) {
				selections.remove(DIAG_TWO_KEY);
			}
		}
	}
	

	public Map<String, int[][]> getData() {
		return selections;
	}

	public boolean isTopRow() {
		return topRow;
	}

	public boolean isMiddleRow() {
		return middleRow;
	}

	public boolean isBottomRow() {
		return bottomRow;
	}

	public boolean isDiagOne() {
		return diagOne;
	}

	public boolean isDiagTwo() {
		return diagTwo;
	}

	private void init() {
		topRow = false;
		middleRow = false;
		bottomRow = false;
		diagOne = false;
		diagTwo = false;
	}
}
