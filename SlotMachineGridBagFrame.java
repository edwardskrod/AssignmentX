package SlotMachine;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import javax.swing.JEditorPane;

import javax.swing.JFileChooser;

public class SlotMachineGridBagFrame extends JFrame

{
	private SlotMachineImpl slot;
	private GridBagLayout slotMachineLayout; // layout of this frame
	private GridBagConstraints constraints; // constraints of the layout
	private JLabel[] labels = new JLabel[64];
	private String stringAccountBalance;
	protected Player player;
	private JFileChooser fc;
	private Buttons buttons;
	private FileMenu fileMenu;
	private NewGameItem newGameItem;
	private SaveItem saveItem;
	private LoadItem loadItem;
	protected SelectedRow selections;
	protected JEditorPane accountValue;

	public SlotMachineGridBagFrame() {

		super("SlotMachineGridBagFrame");
		selections = new SelectedRow();
		slotMachineLayout = new GridBagLayout();
		setLayout(slotMachineLayout);
		player = new Player();
		fc = new JFileChooser();
		buttons = new Buttons();
		fileMenu = new FileMenu();

		newGameItem = new NewGameItem(player);
		fileMenu.add(newGameItem);
		slot = new SlotMachineImpl(player);

		loadItem = new LoadItem(player, this, fc);
		fileMenu.add(loadItem);

		// Create Save Game menu item
		saveItem = new SaveItem(player, this, fc);
		fileMenu.add(saveItem);

		JMenuBar bar = new JMenuBar(); // Create the menu bar
		setJMenuBar(bar);
		bar.add(fileMenu);
		constraints = new GridBagConstraints();

		// Add the icons 1 - 64 25.9 Layout Managers: BoxLayout and
		// GridBagLayout 1035
		// put the icons into Jlabels
		// Populate the array of lables with Icons. Icons are named 1 - 36.jpg

		for (int lcv = 0; lcv < SlotMachineConstants.GRID_BAG_SIZE; ++lcv) {
			String name;
			if (lcv < 9) {
				name = "slotMachine_0" + (lcv + 1) + ".jpg";
			} else {
				name = "slotMachine_" + (lcv + 1) + ".jpg";
			}
			Icon icon = new ImageIcon(getClass().getResource(name));
			labels[lcv] = new JLabel();
			labels[lcv].setIcon(icon);
		}

		setInitialImages();
		addMouseListeners();

		constraints.fill = GridBagConstraints.BOTH;
		int num = 0; // num will track the total number of icons from 0 - 64
		for (int row = 0; row < SlotMachineConstants.MAX_ROW_SIZE; ++row) {

			for (int column = 0; column < SlotMachineConstants.MAX_COLUMN_SIZE; ++column) {

				if ((num == SlotMachineConstants.SELECTION_ACCOUNT_VAL1)
						|| (num == SlotMachineConstants.SELECTION_ACCOUNT_VAL2)) {
					++num;
					continue;
				}
				addComponent(labels[num], row, column, 1, 1);
				++num;
			}
		}

		// Create an editable, JEditorPane which will accept strings
		// made out of HTML
		accountValue = new JEditorPane("text/html", null);
		accountValue.setText("<b>Account Value: "
				+ player.getPlayerAccountBalance() + "</b>");
		addComponent(accountValue, 7, 0, 2, 1);
	} // end constructor

	private void setInitialImages() {
		labels[SlotMachineConstants.GB_TOP_LEFT].setIcon(new ImageIcon(
				getClass().getResource(SpinResult.JAVA.getIcon())));
		labels[SlotMachineConstants.GB_TOP_MIDDLE].setIcon(new ImageIcon(
				getClass().getResource(SpinResult.JAVA.getIcon())));
		labels[SlotMachineConstants.GB_TOP_RIGHT].setIcon(new ImageIcon(
				getClass().getResource(SpinResult.JAVA.getIcon())));
		labels[SlotMachineConstants.GB_MIDDLE_LEFT].setIcon(new ImageIcon(
				getClass().getResource(SpinResult.JAVA.getIcon())));
		labels[SlotMachineConstants.GB_MIDDLE_MIDDLE].setIcon(new ImageIcon(
				getClass().getResource(SpinResult.JAVA.getIcon())));
		labels[SlotMachineConstants.GB_MIDDLE_RIGHT].setIcon(new ImageIcon(
				getClass().getResource(SpinResult.JAVA.getIcon())));
		labels[SlotMachineConstants.GB_BOTTOM_LEFT].setIcon(new ImageIcon(
				getClass().getResource(SpinResult.JAVA.getIcon())));
		labels[SlotMachineConstants.GB_BOTTOM_MIDDLE].setIcon(new ImageIcon(
				getClass().getResource(SpinResult.JAVA.getIcon())));
		labels[SlotMachineConstants.GB_BOTTOM_RIGHT].setIcon(new ImageIcon(
				getClass().getResource(SpinResult.JAVA.getIcon())));
	}

	private void addMouseListeners() {
		labels[SlotMachineConstants.SELECTION_DIAG_ONE]
				.addMouseListener(buttons);
		labels[SlotMachineConstants.SELECTION_TOP_ROW]
				.addMouseListener(buttons);
		labels[SlotMachineConstants.SELECTION_MIDDLE_ROW]
				.addMouseListener(buttons);
		labels[SlotMachineConstants.SELECTION_BOTTOM_ROW]
				.addMouseListener(buttons);
		labels[SlotMachineConstants.SELECTION_DIAG_TWO]
				.addMouseListener(buttons);
		labels[SlotMachineConstants.SELECTION_SPIN_PART1]
				.addMouseListener(buttons);
		labels[SlotMachineConstants.SELECTION_SPIN_PART2]
				.addMouseListener(buttons);
	}

	// method to set constraints on
	private void addComponent(Component component, int row, int column,
			int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		slotMachineLayout.setConstraints(component, constraints);
		add(component);
	}

	private void reelSpin() {

		try {
			new Thread() {
				public void run() {
					for (int i = 0; i < SlotMachineConstants.SPIN_200_TIMES; i++) {
						if (i == SlotMachineConstants.LAST_SPIN) {
							try {
								SwingUtilities.invokeAndWait(new Runnable() {

									@Override
									public void run() {
										realSpinResults();
										repaint();
										try {
											Thread.sleep(5);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
								});
							} catch (Exception e) {

							}
						} else {
							try {
								SwingUtilities.invokeAndWait(new Runnable() {

									@Override
									public void run() {
										setAll();
										repaint();
										try {
											Thread.sleep(5);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
								});
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void realSpinResults() {
		// this is called in spin button action listener
		slot = new SlotMachineImpl(player);
		slot.spin(1, selections.getData());
		labels[SlotMachineConstants.GB_TOP_LEFT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(
								new int[] { SlotMachineConstants.INDEX_ZERO,
										SlotMachineConstants.INDEX_ZERO })
								.getIcon())));
		labels[SlotMachineConstants.GB_TOP_MIDDLE].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(
								new int[] { SlotMachineConstants.INDEX_ZERO,
										SlotMachineConstants.INDEX_ONE })
								.getIcon())));
		labels[SlotMachineConstants.GB_TOP_RIGHT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(
								new int[] { SlotMachineConstants.INDEX_ZERO,
										SlotMachineConstants.INDEX_TWO })
								.getIcon())));

		labels[SlotMachineConstants.GB_MIDDLE_LEFT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(
								new int[] { SlotMachineConstants.INDEX_ONE,
										SlotMachineConstants.INDEX_ZERO })
								.getIcon())));
		labels[SlotMachineConstants.GB_MIDDLE_MIDDLE].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(
								new int[] { SlotMachineConstants.INDEX_ONE,
										SlotMachineConstants.INDEX_ONE })
								.getIcon())));
		labels[SlotMachineConstants.GB_MIDDLE_RIGHT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(
								new int[] { SlotMachineConstants.INDEX_ONE,
										SlotMachineConstants.INDEX_TWO })
								.getIcon())));

		labels[SlotMachineConstants.GB_BOTTOM_LEFT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(
								new int[] { SlotMachineConstants.INDEX_TWO,
										SlotMachineConstants.INDEX_ZERO })
								.getIcon())));
		labels[SlotMachineConstants.GB_BOTTOM_MIDDLE].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(
								new int[] { SlotMachineConstants.INDEX_TWO,
										SlotMachineConstants.INDEX_ONE })
								.getIcon())));
		labels[SlotMachineConstants.GB_BOTTOM_RIGHT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(
								new int[] { SlotMachineConstants.INDEX_TWO,
										SlotMachineConstants.INDEX_TWO })
								.getIcon())));
	}

	private void setAll() {
		setRowOne();
		setRowTwo();
		setRowThree();
	}

	private void setRowOne() {
		Icon icon = new ImageIcon(getClass().getResource(
				SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
		Icon icon2 = new ImageIcon(getClass().getResource(
				SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
		Icon icon3 = new ImageIcon(getClass().getResource(
				SlotMachineConstants.getRandSpinResult().getBlurredIcon()));

		labels[SlotMachineConstants.GB_TOP_LEFT].setIcon(icon);
		labels[SlotMachineConstants.GB_TOP_MIDDLE].setIcon(icon2);
		labels[SlotMachineConstants.GB_TOP_RIGHT].setIcon(icon3);
	}

	private void setRowTwo() {
		Icon icon = new ImageIcon(getClass().getResource(
				SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
		Icon icon2 = new ImageIcon(getClass().getResource(
				SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
		Icon icon3 = new ImageIcon(getClass().getResource(
				SlotMachineConstants.getRandSpinResult().getBlurredIcon()));

		labels[SlotMachineConstants.GB_MIDDLE_LEFT].setIcon(icon);
		labels[SlotMachineConstants.GB_MIDDLE_MIDDLE].setIcon(icon2);
		labels[SlotMachineConstants.GB_MIDDLE_RIGHT].setIcon(icon3);

	}

	private void setRowThree() {
		Icon icon = new ImageIcon(getClass().getResource(
				SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
		Icon icon2 = new ImageIcon(getClass().getResource(
				SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
		Icon icon3 = new ImageIcon(getClass().getResource(
				SlotMachineConstants.getRandSpinResult().getBlurredIcon()));

		labels[SlotMachineConstants.GB_BOTTOM_LEFT].setIcon(icon);
		labels[SlotMachineConstants.GB_BOTTOM_MIDDLE].setIcon(icon2);
		labels[SlotMachineConstants.GB_BOTTOM_RIGHT].setIcon(icon3);
	}

	public void setStringAccountBalance(String balance) {
		stringAccountBalance = balance;
	}

	public String getStringAccountBalance() {
		return this.stringAccountBalance;
	}

	private class Buttons implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			if (e.getComponent().equals(
					labels[SlotMachineConstants.SELECTION_DIAG_ONE])) {
				selections.toggleDiagOne();

				if (selections.isDiagOne()) {
					labels[SlotMachineConstants.SELECTION_DIAG_ONE]
							.setIcon(new ImageIcon(
									getClass()
											.getResource(
													SlotMachineConstants.STRING_DIAG_ONE_IMAGE_TRUE)));
				} else {

					labels[SlotMachineConstants.SELECTION_DIAG_ONE]
							.setIcon(new ImageIcon(
									getClass()
											.getResource(
													SlotMachineConstants.STRING_DIAG_ONE_IMAGE_FALSE)));
				}

			} else if (e.getComponent().equals(
					labels[SlotMachineConstants.SELECTION_TOP_ROW])) {
				selections.toggleTopRow();

				if (selections.isTopRow()) {
					labels[SlotMachineConstants.SELECTION_TOP_ROW]
							.setIcon(new ImageIcon(
									getClass()
											.getResource(
													SlotMachineConstants.STRING_TOP_ROW_IMAGE_TRUE)));
				} else {
					labels[SlotMachineConstants.SELECTION_TOP_ROW]
							.setIcon(new ImageIcon(
									getClass()
											.getResource(
													SlotMachineConstants.STRING_TOP_ROW_IMAGE_FALSE)));
				}

			} else if (e.getComponent().equals(
					labels[SlotMachineConstants.SELECTION_MIDDLE_ROW])) {

				selections.toggleMiddleRow();
				if (selections.isMiddleRow()) {
					labels[SlotMachineConstants.SELECTION_MIDDLE_ROW]
							.setIcon(new ImageIcon(
									getClass()
											.getResource(
													SlotMachineConstants.STRING_MIDDLE_ROW_IMAGE_TRUE)));
				} else {
					labels[SlotMachineConstants.SELECTION_MIDDLE_ROW]
							.setIcon(new ImageIcon(
									getClass()
											.getResource(
													SlotMachineConstants.STRING_MIDDLE_ROW_IMAGE_FALSE)));
				}

			} else if (e.getComponent().equals(
					labels[SlotMachineConstants.SELECTION_BOTTOM_ROW])) {
				selections.toggleBottomRow();
				if (selections.isBottomRow()) {
					labels[SlotMachineConstants.SELECTION_BOTTOM_ROW]
							.setIcon(new ImageIcon(
									getClass()
											.getResource(
													SlotMachineConstants.STRING_BOTTOM_ROW_IMAGE_TRUE)));
				} else {
					labels[SlotMachineConstants.SELECTION_BOTTOM_ROW]
							.setIcon(new ImageIcon(
									getClass()
											.getResource(
													SlotMachineConstants.STRING_BOTTOM_ROW_IMAGE_FALSE)));
				}

			} else if (e.getComponent().equals(
					labels[SlotMachineConstants.SELECTION_DIAG_TWO])) {
				selections.toggleDiagTwo();
				if (selections.isDiagTwo()) {
					labels[SlotMachineConstants.SELECTION_DIAG_TWO]
							.setIcon(new ImageIcon(
									getClass()
											.getResource(
													SlotMachineConstants.STRING_DIAG_TWO_IMAGE_TRUE)));
				} else {
					labels[SlotMachineConstants.SELECTION_DIAG_TWO]
							.setIcon(new ImageIcon(
									getClass()
											.getResource(
													SlotMachineConstants.STRING_DIAG_TWO_IMAGE_FALSE)));
				}

			} else if (e.getComponent().equals(
					labels[SlotMachineConstants.SELECTION_SPIN_PART1])
					|| (e.getComponent()
							.equals(labels[SlotMachineConstants.SELECTION_SPIN_PART2]))) {
				reelSpin();
				long bal = (long) slot.getPlayerAccountBalance();
				String balance = Long.toString(bal);
				accountValue.setText("<b>Account Value: " + balance + "</b>");
			} else {
				System.out.println("elsed out");
			}
			// repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args) {

		SlotMachineGridBagFrame gridBagFrame = new SlotMachineGridBagFrame();
		gridBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridBagFrame.setSize(752, 792);
		gridBagFrame.setVisible(true);
	}

}
