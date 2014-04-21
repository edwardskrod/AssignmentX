AssignmentX
Jesse Hanna
Edward Skrod
April 24, 2014
COP3252, Introduction to Java

/******************    Implementation of a slot machine.    *********************/


Usage Instructions:   Doubleclick the .jar file in Windows or run from the command line by typing java -jar SlotMachine.jar

/******************    Backend / Game Logic:       ******************************/
Board.java:         Creates a 2D array that is an abstraction of the 3 x 3 slot machine window. 
Payout.java:        Allows the developer to change the payouts very quickly and determine whether a line is a winner.
Player.java:        Functions for setting an account balance and player name.  Also implements a JOPtionPane to prompt player for name when a new game is created.
SelectedRow.java:        Toggles a payline row on or off.  
SlotMachineConstants.java:   Provides static constants for use throughout the program.
SlotMachineImpl.java:
SpinResult.java:      Enum which defines the "tokens" (such as Lucky7, Java, BAR, etc.).  Assigns a name of the token, a number on the virtual reel, and strings which correspond to the position of the images.

/******************    Menu Items:       ***************************************/
FileMenu.java:      Extends JMenu.  Constructor adds File to the JMenu.
LoadItem.java:      Extends JMenuItem. Constructor adds "Load game" to the JMenu.  Load's a file with a FileChooser object.
NewGameItem.java:   Extends JMenuItem.  Constructor adds "New game" to the JMenu.  Prompts player for name and creates an opening balance of $100.  
QuitItem.java:    Extends JMenuItem.  Calls System.exit().

/******************   User Interface:       ***********************************/
SlotMachine.java:   Main class for running the game.
SlotMachineGridBagFrame:  extends JFrame.  Provides the UI for the slot machine.  Constructs a gridBagFrame that is 8 x 8 for 64 total, equal 1 inch X 1 inch squares.   Squares at X = 7, Y = 0,1 have been converted into one JEditorPane which displays the Player's current account balance.  We use HTML to set the background of the Pane and light CSS to format the text.

/******************   Testing:       ******************************************/
AdapterMock.java:   Test class for slot machine logic

Extra Credit:  Not only did we implement a save and load game feature using Java's FileChooser, we also used MultiThreading in SlotMachineGridBagFrame.java in order to give the effect of a spinning reel.  
