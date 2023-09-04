# Player Class
## Summary
The `Player` class represents a player in a game. It has fields to store player attributes such as midRange, threePoint, dunk, layUp, steal, rebound, and contest. It also has methods to set and get these attributes, as well as methods for offense and defense actions such as shooting, stealing, and rebounding.

## SHOT MECHANICS
The players shooting is affected by the players attributes. A random number is generated emulating a dice roll, if the number generated is in range with the attribute then the shot is succesful, otherwhise fails.
```java
    //shooting mechanic
    private int shoot(Player p2, String shotType, int rating, int cntstRate, int points){ 
        int contestRating;
        if(cntstRate != 0)
            contestRating = cntstRate;
        else contestRating = 0;

        ShotStrategy strategy;
        if((getPct() - ( rating - (contestRating * 0.2) ) ) < 0){
            strategy = new MadeShotStrategy();
        }
        else {
            strategy = new MissedShotStrategy();
        }
        return strategy.shoot(p2, shotType,points);
    }
```

## Example Usage
```java
Player player1 = new Player("Lebron");
player1.setMidRange(70);
player1.setThreePoint(80);
player1.setDunk(90);
player1.setLayUp(85);
player1.setSteal(75);
player1.setRebound(80);
player1.setContest(70);
player1.showPlayerInfo();
player1.showPlayerOverall();
```

### Main functionalities
- The `Player` class represents a player in a game.
- It has fields to store player attributes such as midRange, threePoint, dunk, layUp, steal, rebound, and contest.
- It has methods to set and get these attributes.
- It has methods for offense actions such as shooting and driving to the basket.
- It has methods for defense actions such as stealing and contesting shots.
- It has methods for rebounding and gaining possession of the ball.
___
### Methods
- `setPlayerName(String name)`: Sets the player's name.
- `setMidRange(int mid)`: Sets the player's midRange attribute and updates the overall attribute.
- `setDunk(int dunk)`: Sets the player's dunk attribute and updates the overall attribute.
- `setLayUp(int layUp)`: Sets the player's layUp attribute and updates the overall attribute.
- `setThreePoint(int three)`: Sets the player's threePoint attribute and updates the overall attribute.
- `setSteal(int stl)`: Sets the player's steal attribute and updates the overall attribute.
- `setRebound(int reb)`: Sets the player's rebound attribute and updates the overall attribute.
- `setContest(int contest)`: Sets the player's contest attribute and updates the overall attribute.
- `setHasBall(boolean ball)`: Sets whether the player has the ball.
- `setScore(int num)`: Sets the player's score.
- `addScore(int num)`: Adds to the player's score.
- `resetDetail()`: Resets the detailed actions.
- `updateOVR()`: Updates the overall attribute based on the player's attributes.
- `getPlayerName()`: Returns the player's name.
- `getStealRt()`: Returns the player's steal attribute.
- `getContest()`: Returns the player's contest attribute.
- `getMidRange()`: Returns the player's midRange attribute.
- `getThreePoint()`: Returns the player's threePoint attribute.
- `getDunk()`: Returns the player's dunk attribute.
- `getLayUp()`: Returns the player's layUp attribute.
- `getSteal()`: Returns the player's steal attribute.
- `getRebound()`: Returns the player's rebound attribute.
- `getHasBall()`: Returns whether the player has the ball.
- `getActionDetails()`: Returns the detailed actions.
- `getScore()`: Returns the player's score.
- `getOverall()`: Returns the player's overall attribute.
- `showActions()`: Prints the detailed actions.
- `showScore()`: Prints the player's score.
###Player Actions
- `chooseOffense(Player p2)`: Chooses an offense action for the player.
- `chooseShot(Player p2)`: Chooses a shot action for the player.
- `chooseLayOrDunk(Player p2)`: Chooses a layup or dunk action for the player.
- `midrangeShot(Player p2)`: Performs a midrange shot action for the player.
- `threePoint(Player p2)`: Performs a three-point shot action for the player.
- `layUpBall(Player p2)`: Performs a layup action for the player.
- `dunkBall(Player p2)`: Performs a dunk action for the player.
- `shoot(Player p2, String shotType, int rating, int cntstRate, int points)`: Performs a shooting action for the player.
- `reboundBall(Player p2)`: Performs a rebound action for the player.
- `defend(Player p2, int defStrat, int points)`: Performs a defense action for the player.
- `trySteal(Player p2, int stl)`: Attempts to steal the ball from the opponent player.
- `stealBall(Player p2)`: Performs a steal action for the player.
- `gainPossessionDef(Player p2)`: Gains possession of the ball in a defensive action.
___

# BlacktopOnes Class
## Summary
The `BlacktopOnes` class represents a game where two players compete to reach a maximum score. It manages the game setup, player actions, and determines the winner.

## Example Usage
```java
BlacktopOnes game = new BlacktopOnes(15); // Create a game with a maximum score of 15
Player player1 = new Player("James"); // Create a player named John
Player player2 = new Player("Curry"); // Create a player named Jane
game.setupGame(player1); // Add player1 to the game
game.setupGame(player2); // Add player2 to the game
Player winner = game.startNewGame(); // Start the game and determine the winner
game.showHightlights(); // Display the game highlights
game.showParticipants(); // Display the names of the players
```
#
### Main functionalities
- Set up a game with a maximum score and two players.
- Manage the game setup by adding players and checking for duplicates.
- Start a new game and determine the winner based on player actions.
- Keep track of game details and player scores.
- Display the game highlights and participant names.
___
### Methods
- `BlacktopOnes()`: Constructor that sets default values for the game.
- `BlacktopOnes(int max)`: Constructor that allows setting a custom maximum score for the game.
- `getMAX()`: Get the maximum score for the game.
- `getGameDetails()`: Get the details of the game.
- `setupGame(Player player)`: Add a player to the game and check for duplicates.
- `checkDuplicate(Player player)`: Check if a player is already added to the game.
- `setGame(boolean x)`: Set the game status to indicate if it is ready to start.
- `gameIsSet()`: Check if the game is set and ready to start.
- `getPlayerCount()`: Get the number of players added to the game.
- `startNewGame()`: Start a new game and determine the winner.
- `ballPossession(Player p1, Player p2)`: Simulate ball possession and player actions during the game.
- `determineWinner(Player p[])`: Determine the winner based on player scores.
- `detailAdd(String message)`: Add a message to the game details.
- `showPlayerScores(Player p[])`: Display the scores of the players.
- `showHightlights()`: Display the highlights of the game.
- `showParticipants()`: Display the names of the players.
___
### Fields
- `MAX_SCORE`: The maximum score required to win the game.
- `gameDetails`: A string that stores the details of the game.
- `p`: An array of Player objects representing the players in the game.
- `MAX`: The maximum number of players allowed in the game.
- `counter`: A counter to keep track of the number of players added to the game.
- `gameSet`: A boolean flag indicating if the game is set and ready to start.

# PlayerList Class
## Summary
The `PlayerList` class represents a list of players in a game. It allows for creating, modifying, and removing players from the list. It also provides methods to retrieve player information and display the list of players.

## Example Usage
```java
PlayerList playerList = new PlayerList();
playerList.createPlayer("Jordan");
playerList.modifyPlayer();
Player player = playerList.pickPlayer(1);
playerList.playerEditor(1);
playerList.removePlayer("Jordan");
playerList.removAllPlayers();
playerList.displayList();
```

## 
### Main functionalities
- Creating a player list with a default set of players.
- Adding a player to the list.
- Modifying a player's attributes.
- Retrieving a player from the list.
- Editing a player's attributes.
- Removing a player from the list.
- Removing all players from the list.
- Displaying the list of players.
___
### Methods
- `public PlayerList()`: Constructor that initializes the player list with default players.
- `public int getCount()`: Returns the current number of players in the list.
- `public int getMAX()`: Returns the maximum number of players allowed in the list.
- `public Player getPlayer(int index)`: Returns the player at the specified index.
- `public boolean createPlayer(String name)`: Creates a new player with the given name and adds it to the list.
- `public boolean createPlayer()`: Creates a new player by prompting the user for input and adds it to the list.
- `public void modifyPlayer()`: Modifies the attributes of the last added player in the list.
- `public Player pickPlayer(int index)`: Returns the player at the specified index.
- `public void playerEditor(int index)`: Allows the user to edit the attributes of a player at the specified index.
- `private void edit(char op, int index)`: Edits the specified attribute of a player at the specified index.
- `public boolean removePlayer(String name)`: Removes a player with the given name from the list.
- `public boolean removAllPlayers()`: Removes all players from the list.
- `private void remove(int index)`: Removes a player at the specified index from the list.
- `public void displayList()`: Displays the list of players.
___
### Fields
- `static Scanner scan`: Scanner object for user input.
- `private Player[] pList`: Array to store the players.
- `private int MAX`: Maximum number of players allowed in the list.
- `private int counter`: Current number of players in the list.
___
