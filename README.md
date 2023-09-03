# Main
## Summary
The `Main` class is the main entry point for the program. It provides a menu-driven interface for creating and managing players and starting a game.

## Example Usage
```java
// Create a new game
showMainMenu();

// Create a player
playerCreate();

// Remove a player
playerRemover();

// Edit a player
editPlayer();

// Start a game
createGameMenu();
pickPlayers();
startGame();
```

## Code Analysis
### Main functionalities
- Displaying a main menu with options to create a new game, create a player, remove a player, edit a player, or exit the program.
- Creating a new game by selecting players from a player list.
- Creating a player by entering a player name.
- Removing a player by entering the player's name.
- Editing a player's attributes such as name, midrange rating, three-point rating, etc.
- Starting a game and displaying game highlights.
___
### Methods
- `showMainMenu()`: Displays the main menu and handles user input for menu options.
- `showSubMenuCreateGame()`: Displays the submenu for creating a new game and handles user input for submenu options.
- `createGameMenu()`: Creates a new game by initializing the `BlacktopOnes` game object and checking if there are enough players in the player list.
- `pickPlayers()`: Allows the user to select players from the player list for the game.
- `playerCreate()`: Creates a new player by getting the player name from the user and calling the `createPlayer()` method of the `PlayerList` class.
- `startGame()`: Starts a game by calling the `startNewGame()` method of the `BlacktopOnes` game object and displaying game highlights.
- `playerRemover()`: Removes a player by getting the player name from the user and calling the `removePlayer()` method of the `PlayerList` class.
- `editPlayer()`: Allows the user to edit a player's attributes by selecting a player from the player list and choosing an attribute to edit.
___
### Fields
- `game`: An instance of the `BlacktopOnes` class representing the current game.
- `list`: An instance of the `PlayerList` class representing the list of players.
- `scan`: A `Scanner` object for user input.
___

