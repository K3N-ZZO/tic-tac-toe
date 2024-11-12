# Tic Tac Toe Game Project

This project is a console-based game that allows two players to compete in a classic "X and O" game. It includes both a Player vs. Player (PvP) and Player vs. Computer (PvC) mode, with options to save and load the game state, as well as delete saved games.

## Features

- **Game Modes:** 
  - PvP (Player vs Player) mode for two human players.
  - PvC (Player vs Computer) mode, where a player competes against the computer.
- **Board Sizes:**
  - Supports small (3x3) and large (10x10) board sizes.
- **Game Saving and Loading:**
  - Save game progress and load saved games.
  - Delete saved games if desired.
- **Score Tracking:**
  - Keeps track of wins for each player (Player X, Player O, or Computer).

## Instructions

1. **Start Game:** Run the main class to start the game.
2. **Menu Options:**
   - **0:** Exit the game.
   - **1:** Start a new PvP game on a 3x3 board.
   - **2:** Start a new PvP game on a 10x10 board.
   - **3:** Display instructions on how to play.
   - **4:** Start a new PvC game (allows choosing board size).
   - **5:** Delete the saved game file.
   - **6:** Load a saved game.
3. **Gameplay:**
   - Players take turns marking the board.
   - X always goes first.
   - The game ends when either player wins or the board is full (draw).
4. **Saving Game:**
   - After each game, the current state is saved to a file (`gamestate.ser`).

## Classes and Methods

### Main Classes

- **Game:** The main game loop and menu logic. Manages game flow, score, and player moves.
- **Board:** Represents the game board. Includes methods to clear the board, check for wins, and determine if the board is full.
- **OutputDisplay:** Handles all console output, including instructions, prompts, and game results.
- **PlayerMove and ComputerMove:** Handle player and computer moves, respectively.
- **GameState:** A serializable class to store game state, including board configuration, score, and game mode.

### Key Methods in `Game` Class

- `run()`: The main game loop, handling user input and game flow.
- `isPlayAgain(int playerOneScore, boolean isPvP, int playerTwoScore, int computerScore, Scanner scanner)`: Determines if the players want to play again.
- `chooseBoardSize(Scanner scanner)`: Prompts the user to choose a board size.
- `saveGame(GameState gameState)`: Saves the current game state to `gamestate.ser`.
- `loadGame()`: Loads the saved game state from `gamestate.ser`.
- `deleteSaveFile()`: Deletes the saved game file.

## Saving and Loading

The game state is saved in a file named `gamestate.ser`. This file includes:
- The board configuration and size.
- Player and computer scores.
- The game mode (PvP or PvC).

### Error Handling

- If loading a saved game fails (e.g., file not found or corrupted), an error message is displayed, and a new game can be started instead.

## Requirements

- Java 8 or higher.

## How to Run

1. Compile the project:
   ```bash
   javac -d bin src/com/kodilla/*.java
2. Run the game:
bash
Copy code
java -cp bin com.kodilla.Game
Additional Notes
Serialization: The game state is serialized to allow saving and loading.
Delete Save File: Use option 5 in the main menu to delete the saved game if needed.

## License
This project is open-source and available under the MIT License.
