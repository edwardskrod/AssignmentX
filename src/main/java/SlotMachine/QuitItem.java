package SlotMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class QuitItem extends JMenuItem {


	QuitItem( ) {
		super("Quit game");
		setMnemonic('Q');
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				System.exit(1);
				
				}
		});
	}
}
