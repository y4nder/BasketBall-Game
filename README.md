# Main
## Summary
The `Main` class is responsible for managing a list of basketball players and providing methods to create, modify, and remove players from the list.

## Example Usage
```java
PlayerList playerList = new PlayerList();

// Create a new player with a specified name
playerList.createPlayer("Jordan");

// Modify the attributes of a player
playerList.playerEditor(1);

// Remove a player from the list
playerList.removePlayer("Jordan");
```

## Code Analysis
### Main functionalities
- Create a list of basketball players with a maximum capacity.
- Add players to the list with a specified name.
- Modify the attributes of a player, such as their name, ratings for different skills (e.g., midrange, three-point, dunk), and other attributes (e.g., steal, rebound, contest).
- Remove a player from the list.
___
### Methods
- `PlayerList()`: Constructor method that initializes the player list with default players.
- `getCount()`: Returns the current number of players in the list.
- `getMAX()`: Returns the maximum capacity of the player list.
- `getPlayer(int index)`: Returns the player at the specified index in the list.
- `createPlayer(String name)`: Creates a new player with the specified name and adds them to the list.
- `createPlayer()`: Creates a new player without a specified name and adds them to the list.
- `modifyPlayer()`: Modifies the attributes of the last added player in the list.
- `pickPlayer(int index)`: Returns the player at the specified index in the list.
- `playerEditor(int index)`: Allows the user to edit the attributes of a player at the specified index in the list.
- `edit(char op, int index)`: Edits a specific attribute of a player at the specified index in the list.
- `removePlayer(String name)`: Removes a player with the specified name from the list.
___
### Fields
- `pList`: An array of `Player` objects representing the player list.
- `MAX`: The maximum capacity of the player list.
- `counter`: The current number of players in the list.
___
