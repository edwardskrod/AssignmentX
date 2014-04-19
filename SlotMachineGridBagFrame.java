package SlotMachine;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingUtilities;
import java.io.*;
import javax.swing.JFileChooser;

public class SlotMachineGridBagFrame extends JFrame

{

	private GridBagLayout slotMachineLayout; // layout of this frame
	private GridBagConstraints constraints; // constraints of the layout
	private JLabel[] labels = new JLabel[64];
	private String stringAccountBalance;
	private Player player;
	private JFileChooser fc;

	public SlotMachineGridBagFrame() {

		super("SlotMachineGridBagFrame");
		slotMachineLayout = new GridBagLayout();
		setLayout(slotMachineLayout);
		player = new Player();

		fc = new JFileChooser();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

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
						out.write(stringAccountBalance);
						out.close();
						JOptionPane.showMessageDialog(null, "Game Saved!",
								"Saving: " + file.getName() + "." + "\n",
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

		JMenuItem loadItem = new JMenuItem("Load game");
		saveItem.setMnemonic('L');
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
						stringAccountBalance = in.readLine();
						in.close();
						JOptionPane.showMessageDialog(null,
								"AccountBalance is: " + stringAccountBalance
										+ "\n", "Game Loaded",
								JOptionPane.PLAIN_MESSAGE);
					} catch (IOException e) {
						System.out
								.println("There was a problem loading the file: "
										+ e);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Load Cancelled.",
							"Load command cancelled by user." + "\n",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		JMenuBar bar = new JMenuBar(); // Create the menu bar
		setJMenuBar(bar);
		bar.add(fileMenu);

		constraints = new GridBagConstraints();

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
		// Icon icon = new ImageIcon (getClass().getResource(
		// SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
		// labels[10] = new JLabel();
		// labels[10].setIcon( icon );

		spinMock();
		constraints.fill = GridBagConstraints.BOTH;
		int y;
		int num = 0; // num will track the total number of icons from 0 - 64
		for (int i = 0; i < 8; ++i) {

			y = 0;

			for (int j = 0; j < 8; ++j) {

				addComponent(labels[num], i, j, 1, 1);
				++num;
			}
		}

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

	private void spinMock() {
		try {
			new Thread() {
				public void run() {
					for (int i = 0; i < 200; i++) {
						try {
							SwingUtilities.invokeAndWait(new Runnable() {

								@Override
								public void run() {
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
			}.start();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private void paint() {
		labels[SlotMachineConstants.GB_TOP_LEFT].repaint();
		labels[SlotMachineConstants.GB_TOP_MIDDLE].repaint();
		labels[SlotMachineConstants.GB_TOP_RIGHT].repaint();

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

		// labels[SlotMachineConstants.GB_TOP_LEFT] = new JLabel();
		// labels[SlotMachineConstants.GB_TOP_MIDDLE] = new JLabel();
		// labels[SlotMachineConstants.GB_TOP_RIGHT] = new JLabel();
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

		// labels[SlotMachineConstants.GB_MIDDLE_LEFT] = new JLabel();
		// labels[SlotMachineConstants.GB_MIDDLE_MIDDLE] = new JLabel();
		// labels[SlotMachineConstants.GB_MIDDLE_RIGHT] = new JLabel();
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

		// labels[25] = new JLabel();
		// labels[26] = new JLabel();
		// labels[27] = new JLabel();
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
		gridBagFrame.setSize(1000, 1000);
		gridBagFrame.setVisible(true);

	}

}
