package SlotMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class NewGameItem extends JMenuItem{
protected Player player;
protected SlotMachineGridBagFrame frame;
	NewGameItem(final Player player, final SlotMachineGridBagFrame frame){
		super("New game");
		setMnemonic('N');
		this.player = player;
		this.frame = frame;
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.setSpin(true);
				System.out.println("frame.setSpin(true);");
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
	}
	public void newGame(){
		frame.setSpin(true);
		player.setPlayerName(Player.promptForPlayerName());
		player.setPlayerAccountBalance(SlotMachineConstants.DEFAULT_STARTING_BALANCE);
		JOptionPane.showMessageDialog(null,
				"Welcome to JavaSlots " + player.getPlayerName()
						+ "! Your beginning account balance is: $"
						+ player.getPlayerAccountBalance(),
				"Welcome to JavaSlots!", JOptionPane.PLAIN_MESSAGE);

		// Display the player's account balance with HTML
		frame.accountValue.setText(SlotMachineConstants.ACCOUNT_VALUE_HTML
				+ player.getPlayerAccountBalance()
				+ SlotMachineConstants.ACCOUNT_VALUE_HTML_END);


	}
}
