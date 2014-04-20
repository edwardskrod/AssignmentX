package SlotMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class LoadItem extends JMenuItem{

	protected SlotMachineGridBagFrame frame;
	protected JFileChooser fileChooser;
	protected Player player;
	LoadItem(final Player player, final SlotMachineGridBagFrame frame, final JFileChooser fileChooser){
		super("Load game");
		setMnemonic('L');
		this.player = player;
		this.frame = frame;
		this.fileChooser = fileChooser;
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				BufferedReader in;
				int returnVal = fileChooser.showOpenDialog(frame);

				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File file = fileChooser.getSelectedFile();

					// Update the stringAccountBalance
					try {

						in = new BufferedReader(new FileReader(file));
						String playerName = in.readLine();
						player.setPlayerName(playerName);

						frame.setStringAccountBalance(in.readLine());
						player.setPlayerAccountBalance(Integer
								.parseInt(frame.getStringAccountBalance()));
						in.close();

						JOptionPane.showMessageDialog(
								null,
								"Welcome back to JavaSlots"
										+ player.getPlayerName()
										+ "! Your Account Balance is: "
										+ frame.getStringAccountBalance() + "\n",
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
	}
}
