package SlotMachine;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
//import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SlotMachineGridBagFrame extends JFrame

{

	private GridBagLayout slotMachineLayout;  	// layout of this frame
	private GridBagConstraints constraints;  	// constraints of the layout
	private JLabel [] labels = new JLabel[ 36 ];;
	
	public SlotMachineGridBagFrame ( )
	{
		
		super ("SlotMachineGridBagFrame");
		slotMachineLayout = new GridBagLayout( );
		setLayout( slotMachineLayout);
		
		JMenu fileMenu = new JMenu( "File" );
		fileMenu.setMnemonic( 'F' );
		
		// Create Save Game menu item
		JMenuItem saveItem = new JMenuItem( "Save game" );
		saveItem.setMnemonic( 'S' );
		fileMenu.add ( saveItem );
		saveItem.addActionListener(
		
		// Action listener saves the game
		// TODO:  we need to put the code here that allows a user to save his/her game
			new ActionListener( ) 
			{
				public void actionPerformed (ActionEvent event )
				{
			     // For testing only
				JOptionPane.showMessageDialog ( null, "Game Saved!", "Game Saved!", JOptionPane.PLAIN_MESSAGE );
				}
			}
		
		);
	
		
		JMenuBar bar = new JMenuBar(); 	// Create the menu bar
		setJMenuBar( bar );
		bar.add( fileMenu );
		
		constraints = new GridBagConstraints( );
		
		// Add the icons 1 - 36   25.9 Layout Managers: BoxLayout and GridBagLayout 1035
		Icon icon1= new ImageIcon ( getClass().getResource( "1.jpg" ));
		
		// put the icons into Jlabels
		//label1 = new JLabel();
		//label1.setIcon( icon1 );
		
		// Populate the array of lables with Icons.  Icons are named 1 - 36.jpg
		for (int lcv = 0; lcv < 36; ++lcv ){
			
			String name = (lcv + 1) + ".jpg";
		    Icon icon = new ImageIcon (getClass().getResource( name ));
			labels[lcv] = new JLabel();
			labels[lcv].setIcon( icon );
		}
		
		
		constraints.fill = GridBagConstraints.BOTH;
		int y;
		int num = 0;  // num will track the total number of icons from 0 - 35
		for (int i = 0; i < 6; ++i ) {
		
			y = 0;
			
			for (int j = 0; j < 6; ++j ){
				
				addComponent ( labels[ num ], i, j, 1, 1);
				++num;
			}
		}
		

		
		// The slot machine reel graphics will occupy
		// row 2, spaces 0, 1, 2
		// row 3, spaces 0, 1, 2
		// row 4, spaces 0, 1, 2
		
	  
		
		
		
		
		
	}
	
	// method to set constraints on
	private void addComponent( Component component, int row, int column, int width, int height) 
	{
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		slotMachineLayout.setConstraints ( component, constraints );
		add (component );
	}
	
	
	public static void main( String [] args ) {
		
		SlotMachineGridBagFrame gridBagFrame = new SlotMachineGridBagFrame ();
		
		gridBagFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		gridBagFrame.setSize( 810, 810 );
		gridBagFrame.setVisible( true );
	}
	
	
	
	
	
}
