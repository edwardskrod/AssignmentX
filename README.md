AssignmentX  
Jesse Hanna, Edward Skrod  
COP3252, Introduction to Java  
April 24, 2014  

#  IMPLEMENTATION OF A SLOT MACHINE
Usage Instructions:   Doubleclick the .jar file in Windows or run from the 
command line by typing `java -jar SlotMachine.jar`

# DIVISION OF RESPONSIBILITIES
In the very first few days of receiving the assignment, Edward put together a 
rudimentary Backend with a Board.java, Player.java, and Reel (including a virtual 
reel).  Jesse took over the Backend from there and did some heavy lifting by 
implementing the SpinResult Enum, calculating the payouts in SlotMachineImpl, etc.  

Jesse continued to hammer out the Backend while Edward began to design the UI
in Photoshop.  Once the UI was designed, Edward went to work implementing the
GridBagFrame.  Jesse added a considerable amount of Code to the GridBag, such
as the MultiThreading in reelSpin().  

They both did the MouseHandler events while Edward did the Menu Items and associated
action listeners.  It was Jesse's idea to create the SlotMachineConstants.java class.  

# BACKEND / GAME LOGIC
File | Description
-----|------------
Board.java | Creates a 2D array that is an abstraction of the 3 x 3 slot machine window. 
Payout.java | Allows the developer to change the payouts very quickly and determine whether a line is a winner.
Player.java | Functions for setting an account balance and player name. Also implements a JOPtionPane to prompt player for name when a new game is created.
SelectedRow.java | Toggles a payline row on or off.
SlotMachineConstants.java | Provides static constants for use throughout the program.
SlotMachineImpl.java | Receives the spin results from board[][] and determines whether a particular row is a winner.  Then it calculates the payout.
SpinResult.java | Enum which defines the "tokens" (such as Lucky7, Java, BAR, etc.). Assigns a name of the token, a number on the virtual reel, and strings which correspond to the position of the images.

# MENU ITEMS
File | Description
-----|------------
FileMenu.java | Extends JMenu.  Constructor adds File to the JMenu.
LoadItem.java | Extends JMenuItem. Constructor adds "Load game" to the JMenu. Load's a file with a FileChooser object.
NewGameItem.java | Extends JMenuItem.  Constructor adds "New game" to the JMenu. Prompts player for name and creates an opening balance of $100.
QuitItem.java | Extends JMenuItem.  Calls System.exit().

# USER INTERFACE
File | Description
-----|------------
SlotMachine.java | Main class for running the game.
SlotMachineGridBagFrame | extends JFrame.  Provides the UI for the slot machine. Constructs a gridBagFrame that is 8 x 8 for 64 total, equal 1 inch X 1 inch squares. Squares at X = 7, Y = 0,1 have been converted into one JEditorPane which displays the Player's current account balance.  We use HTML to set the background of the Pane and light CSS to format the text.

# TESTING
File | Description
-----|------------
AdapterMock.java | Test class for slot machine logic

# EXTRA CREDIT
Not only did we implement a save and load game feature using Java's FileChooser, we also used MultiThreading in SlotMachineGridBagFrame.java in order to give the effect of a spinning reel.
