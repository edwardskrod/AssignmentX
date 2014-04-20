package SlotMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class SaveItem extends JMenuItem {
	protected JFileChooser fc;
	protected SlotMachineGridBagFrame frame;
	protected Player player;

	SaveItem(final Player player, final SlotMachineGridBagFrame frame,
			final JFileChooser fc) {
		super("Save game");
		setMnemonic('S');
		this.fc = fc;
		this.frame = frame;
		this.player = player;

		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				BufferedWriter out;
				int returnVal = fc.showSaveDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File file = fc.getSelectedFile();

					// Update the stringAccountBalance
					frame.setStringAccountBalance(Integer.toString((int) player
							.getPlayerAccountBalance()));
					try {
						out = new BufferedWriter(new FileWriter(file));

						out.write(player.getPlayerName());
						out.write("\n");
						out.write(frame.getStringAccountBalance());
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
	}
}
