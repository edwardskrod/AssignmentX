package SlotMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class NewGameItem extends JMenuItem{
protected Player player;
	NewGameItem(final Player player){
		super("New game");
		setMnemonic('N');
		this.player = player;
		addActionListener(new ActionListener() {
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
	}
}
