package SlotMachine;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.io.*;

import javax.swing.JFileChooser;

public class SlotMachineGridBagFrame extends JFrame

{
	private SlotMachineImpl slot;
	private GridBagLayout slotMachineLayout; // layout of this frame
	private GridBagConstraints constraints; // constraints of the layout
	private JLabel[] labels = new JLabel[64];
	private String stringAccountBalance;
	private Player player;
	private JFileChooser fc;
	private Buttons buttons;
	protected SelectedRow selections;
	protected JTextArea accountValue;
	public SlotMachineGridBagFrame() {

		super("SlotMachineGridBagFrame");
		selections = new SelectedRow();
		slotMachineLayout = new GridBagLayout();
		setLayout(slotMachineLayout);
		player = new Player();
		fc = new JFileChooser();
		buttons = new Buttons();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		// Create New Game menu item
		JMenuItem newGameItem = new JMenuItem("New game");
		newGameItem.setMnemonic('N');
		fileMenu.add(newGameItem);
		newGameItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				// Instantiate a new Player
				player.setPlayerName(Player.promptForPlayerName());
				player.setPlayerAccountBalance(100);
				JOptionPane.showMessageDialog(null,
						"Welcome to JavaSlots " + player.getPlayerName()
								+ "! Your beginning account balance is: $"
								+ player.getPlayerAccountBalance(),
						"Welcome to JavaSlots!", JOptionPane.PLAIN_MESSAGE);
			}
		});

		slot = new SlotMachineImpl(player);

		JMenuItem loadItem = new JMenuItem("Load game");
		loadItem.setMnemonic('L');
		fileMenu.add(loadItem);

		loadItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				BufferedReader in;
				int returnVal = fc.showOpenDialog(SlotMachineGridBagFrame.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File file = fc.getSelectedFile();

					// Update the stringAccountBalance
					try {

						in = new BufferedReader(new FileReader(file));
						String playerName = in.readLine();
						player.setPlayerName(playerName);

						stringAccountBalance = in.readLine();
						player.setPlayerAccountBalance(Integer
								.parseInt(stringAccountBalance));
						in.close();

						JOptionPane.showMessageDialog(
								null,
								"Welcome back to JavaSlots"
										+ player.getPlayerName()
										+ "! Your Account Balance is: "
										+ stringAccountBalance + "\n",
								"Welcome Back to JavaSlots!",
								JOptionPane.PLAIN_MESSAGE);

					} catch (IOException e) {
						System.out
								.println("There was a problem loading the file: "
										+ e);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Load File Cancelled.",
							"The Load command cancelled by user." + "\n",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		// Create Save Game menu item
		JMenuItem saveItem = new JMenuItem("Save game");
		saveItem.setMnemonic('S');
		fileMenu.add(saveItem);

		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				BufferedWriter out;
				int returnVal = fc.showSaveDialog(SlotMachineGridBagFrame.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File file = fc.getSelectedFile();

					// Update the stringAccountBalance
					stringAccountBalance = Integer.toString((int) player
							.getPlayerAccountBalance());
					try {
						out = new BufferedWriter(new FileWriter(file));

						out.write(player.getPlayerName());
						out.write("\n");
						out.write(stringAccountBalance);
						out.close();
						JOptionPane.showMessageDialog(null,
								"Saving: " + file.getName() + "." + "\n",
								"Game Successfully Saved!",
								JOptionPane.PLAIN_MESSAGE);
					} catch (IOException e) {
						System.out
								.println("There was a problem saving the file: "
										+ e);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Save Cancelled.",
							"Save command cancelled by user." + "\n",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		JMenuBar bar = new JMenuBar(); // Create the menu bar
		setJMenuBar(bar);
		bar.add(fileMenu);
		constraints = new GridBagConstraints();
		// slot = new SlotMachineImpl(player);

		// Add the icons 1 - 64 25.9 Layout Managers: BoxLayout and
		// GridBagLayout 1035
		// Icon icon1 = new ImageIcon ( getClass().getResource( "1.jpg" ));

		// put the icons into Jlabels

		// Populate the array of lables with Icons. Icons are named 1 - 36.jpg

		for (int lcv = 0; lcv < 64; ++lcv) {
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
		
		accountValue = new JTextArea("Account Value: ", 10, 5);
		accountValue.setEditable(false);
        addComponent(accountValue, 7, 0, 2, 1);
        
	}

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

	// TODO
	// this is only called from action listener when someone hits spin button
	private void reelSpin() {

		// slot.spin(1, selection.getData());

		try {
			new Thread() {
				public void run() {
					for (int i = 0; i < 200; i++) {
						if (i == 199) {
							try {
								SwingUtilities.invokeAndWait(new Runnable() {

									@Override
									public void run() {
										realSpinResults();
										// realSpinResults();
										repaint();
										try {
											Thread.sleep(5);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
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
										// realSpinResults();
										setAll();
										repaint();
										try {
											Thread.sleep(5);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								});
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
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
		// TODO this is called in spin button action listener
		slot = new SlotMachineImpl(player);
		slot.spin(1, selections.getData());
		labels[SlotMachineConstants.GB_TOP_LEFT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(new int[] { 0, 0 }).getIcon())));
		labels[SlotMachineConstants.GB_TOP_MIDDLE].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(new int[] { 0, 1 }).getIcon())));
		labels[SlotMachineConstants.GB_TOP_RIGHT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(new int[] { 0, 2 }).getIcon())));

		labels[SlotMachineConstants.GB_MIDDLE_LEFT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(new int[] { 1, 0 }).getIcon())));
		labels[SlotMachineConstants.GB_MIDDLE_MIDDLE].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(new int[] { 1, 1 }).getIcon())));
		labels[SlotMachineConstants.GB_MIDDLE_RIGHT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(new int[] { 1, 2 }).getIcon())));

		labels[SlotMachineConstants.GB_BOTTOM_LEFT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(new int[] { 2, 0 }).getIcon())));
		labels[SlotMachineConstants.GB_BOTTOM_MIDDLE].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(new int[] { 2, 1 }).getIcon())));
		labels[SlotMachineConstants.GB_BOTTOM_RIGHT].setIcon(new ImageIcon(
				getClass().getResource(
						slot.getBoardPosition(new int[] { 2, 2 }).getIcon())));

	}

	private void swapAll() {
		setRowThree(labels[SlotMachineConstants.GB_MIDDLE_LEFT],
				labels[SlotMachineConstants.GB_MIDDLE_MIDDLE],
				labels[SlotMachineConstants.GB_MIDDLE_RIGHT]);
		swapRowTwo();
	}

	private void swapRowTwo() {
		setRowTwo(labels[SlotMachineConstants.GB_TOP_LEFT],
				labels[SlotMachineConstants.GB_TOP_MIDDLE],
				labels[SlotMachineConstants.GB_TOP_RIGHT]);
		setRowOne();
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

	private void setRowTwo(JLabel label1, JLabel label2, JLabel label3) {
		labels[SlotMachineConstants.GB_MIDDLE_LEFT] = label1;
		labels[SlotMachineConstants.GB_MIDDLE_MIDDLE] = label2;
		labels[SlotMachineConstants.GB_MIDDLE_RIGHT] = label3;
	}

	private void setRowThree(JLabel label1, JLabel label2, JLabel label3) {
		labels[SlotMachineConstants.GB_BOTTOM_LEFT] = label1;
		labels[SlotMachineConstants.GB_BOTTOM_MIDDLE] = label2;
		labels[SlotMachineConstants.GB_BOTTOM_RIGHT] = label3;
	}

	public static void main(String[] args) {

		SlotMachineGridBagFrame gridBagFrame = new SlotMachineGridBagFrame();

		gridBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridBagFrame.setSize(752, 792);
		gridBagFrame.setVisible(true);

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

				System.out
						.println("labels[SlotMachineConstants.SELECTION_TOP_ROW]");
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

				System.out.println("labels[SELECTION_MIDDLE_ROW]");
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
				System.out.println("labels[SELECTION_BOTTOM_ROW]");
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
				System.out.println("labels[SELECTION_DIAG_TWO]");
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
				accountValue.setText("Account Value: " + slot.getPlayerAccountBalance());
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

}
