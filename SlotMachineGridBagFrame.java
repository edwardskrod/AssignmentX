package SlotMachine;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
//import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
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
	private JLabel [] labels = new JLabel[ 64 ];;
	
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
		
		// Add the icons 1 - 64   25.9 Layout Managers: BoxLayout and GridBagLayout 1035
		//Icon icon1 = new ImageIcon ( getClass().getResource( "1.jpg" ));
		
		// put the icons into Jlabels
		//label1 = new JLabel();
		//label1.setIcon( icon1 );
		
		// Populate the array of lables with Icons.  Icons are named 1 - 36.jpg
		for (int lcv = 0; lcv < 64; ++lcv ){
			String name;
			if (lcv < 9){
				
				name = "slotMachine_0" + (lcv + 1) + ".jpg";
				System.out.println(name);
			}
			else {
				name = "slotMachine_" + (lcv + 1) + ".jpg";
				System.out.println(name);

				
			}
			
		    Icon icon = new ImageIcon (getClass().getResource( name ));

			labels[lcv] = new JLabel();
			labels[lcv].setIcon( icon );
		}
		
		
		constraints.fill = GridBagConstraints.BOTH;
		int y;
		int num = 0;  // num will track the total number of icons from 0 - 64
		for (int i = 0; i < 8; ++i ) {
		
			y = 0;
			
			for (int j = 0; j < 8; ++j ){
				
				addComponent ( labels[ num ], i, j, 1, 1);
				++num;
			}
		}
		

		
		// The slot machine reel graphics will occupy
		// row 2, spaces 0, 1, 2
		// row 3, spaces 0, 1, 2
		// row 4, spaces 0, 1, 2
		
		for (int i = 0 ; i < 100; i++){
			
		}
//	    Icon icon = new ImageIcon (getClass().getResource( SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
//		labels[10] = new JLabel();
//		labels[9] = new JLabel();
//		labels[11] = new JLabel();
//		labels[10].setIcon( icon );
//		labels[11].setIcon( icon );
//		labels[12].setIcon( icon );
//
//
		
		
		
		
		
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
		gridBagFrame.setSize( 1000, 1000 );
		gridBagFrame.setVisible( true );
		
	}
	
	private void setAll(){
		setRowOne();
		setRowTwo();
		setRowThree();
	}
	private void setRowOne(){
	    Icon icon = new ImageIcon (getClass().getResource( SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
	    Icon icon2 = new ImageIcon (getClass().getResource( SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
	    Icon icon3 = new ImageIcon (getClass().getResource( SlotMachineConstants.getRandSpinResult().getBlurredIcon()));

		labels[9] = new JLabel();
		labels[10] = new JLabel();
		labels[11] = new JLabel();
		labels[9].setIcon( icon );
		labels[10].setIcon( icon2 );
		labels[11].setIcon( icon3 );
	}
	private void setRowTwo(){
	    Icon icon = new ImageIcon (getClass().getResource( SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
	    Icon icon2 = new ImageIcon (getClass().getResource( SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
	    Icon icon3 = new ImageIcon (getClass().getResource( SlotMachineConstants.getRandSpinResult().getBlurredIcon()));

		labels[17] = new JLabel();
		labels[18] = new JLabel();
		labels[19] = new JLabel();
		labels[17].setIcon( icon );
		labels[18].setIcon( icon2 );
		labels[19].setIcon( icon3 );

	}
	private void setRowThree(){
	    Icon icon = new ImageIcon (getClass().getResource( SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
	    Icon icon2 = new ImageIcon (getClass().getResource( SlotMachineConstants.getRandSpinResult().getBlurredIcon()));
	    Icon icon3 = new ImageIcon (getClass().getResource( SlotMachineConstants.getRandSpinResult().getBlurredIcon()));

		labels[25] = new JLabel();
		labels[26] = new JLabel();
		labels[27] = new JLabel();
		labels[25].setIcon( icon );
		labels[26].setIcon( icon2 );
		labels[27].setIcon( icon3 );

	}
	private void setRowTwo(Icon icon1, Icon icon2, Icon icon3){
		
	}
	private void setRowThree(Icon icon1, Icon icon2, Icon icon3){
		
	}
}
