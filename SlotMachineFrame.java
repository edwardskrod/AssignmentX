package SlotMachine;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SlotMachineFrame extends JFrame implements ActionListener {

	private SelectedRow row;
	private JPanel panel;
	private JButton topRowButton, middleRowButton, bottomRowButton, diagOne,
			diagTwo, spinButton;
	private SlotMachineImpl play;
	private Player thePlayer;

	public SlotMachineFrame(/*SlotMachineImpl play, SelectedRow row*/) {
		super("Slot Machine");
		thePlayer = new Player();
		play = new SlotMachineImpl(thePlayer);

		//		this.row = row;
		//		this.play = play;
		init();
	}

	private void init() {
		setVisible(true);
		panel = new JPanel();
		addButtons();
		panel.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		row = new SelectedRow();
		add(panel);
	}

	private void addButtons() {
		topRowButton = new JButton("TOP ROW");
		middleRowButton = new JButton("MIDDLE ROW");
		bottomRowButton = new JButton("BOTTOM ROW");
		diagOne = new JButton("DIAG ONE");
		diagTwo = new JButton("DIAG TWO");
		spinButton = new JButton("SPIN");

		topRowButton.setVisible(true);
		topRowButton.addActionListener(this);
		middleRowButton.addActionListener(this);
		bottomRowButton.addActionListener(this);
		diagOne.addActionListener(this);
		diagTwo.addActionListener(this);
		spinButton.addActionListener(this);

		panel.add(topRowButton);
		panel.add(middleRowButton);
		panel.add(bottomRowButton);
		panel.add(diagOne);
		panel.add(diagTwo);
		panel.add(spinButton);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("Into ActionPerformed" + event.getActionCommand());
		//		if (event.)
		if ("TOP ROW".equals(event.getActionCommand())) {
			System.out.print("made it into TopRow action listener");
			row.toggleTopRow();
		} else if ("MIDDLE ROW".equals(event.getActionCommand())) {
			System.out.print("made it into middleRow action listener");
			row.toggleMiddleRow();
		} else if ("BOTTOM ROW".equals(event.getActionCommand())) {
			System.out.print("made it into bottomRow action listener");
			row.toggleBottomRow();
		} else if ("DIAG ONE".equals(event.getActionCommand())) {
			row.toggleDiagOne();
			System.out.print("made it into diagOne action listener");

		} else if ("DIAG TWO".equals(event.getActionCommand())) {
			System.out.print("made it into diagTwo action listener");
			row.toggleDiagTwo();
		} else if ("SPIN".equals(event.getActionCommand())) {
			System.out.print("made it into spin action listener");
			play.spin(1, row.getData());
		} else {
			System.out.println("Elsed through ActionPerformed");

		}
	}

	public Player getPlayer() {
		return this.thePlayer;
	}

	public SlotMachineImpl getImpl() {
		return play;
	}

	public static void main(String[] args) {
		SlotMachineFrame slot = new SlotMachineFrame(/*play, row*/);

		FileHandler.getAccountInformation(slot.getPlayer());

		System.out.println("Player account balance before bet = "
				+ slot.getPlayer().getPlayerAccountBalance());

		//			slot.getImpl().printBoardWithTokens();
		System.out.println("isWiner = " + slot.getImpl().isWinner());
		System.out.println("Payout = " + slot.getImpl().getPayout());
		System.out.println("Player account balance after bet = "
				+ slot.getPlayer().getPlayerAccountBalance());

		// Save the winning in the file
		FileHandler.saveAccountInformation(slot.getPlayer());

		// Print the player info to console
		slot.getPlayer().printPlayerInfo();

		while (true) {

		}
	}
}
