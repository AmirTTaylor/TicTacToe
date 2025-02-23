# Tic Tac Toe

A simple Tic Tac Toe game implemented in Java using JavaFX for the graphical user interface.

## Features
- Two-player mode
- Graphical user interface (GUI) built with JavaFX
- Win detection for rows, columns, and diagonals
- Reset functionality to play again

## Prerequisites
Ensure you have the following installed:
- Java Development Kit (JDK) 11 or later
- JavaFX SDK

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/AmirTTaylor/TicTacToe.git
   cd TicTacToe
   ```
2. Compile and run the application:
   ```sh
   javac --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml *.java
   java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml Main
   ```
   Replace `/path/to/javafx/lib` with the actual path to your JavaFX SDK.

## How to Play
1. Run the game.
2. Players take turns clicking on an empty cell to place their mark (X or O).
3. The game checks for a win or a draw after each move.
4. Click the reset button to start a new game.

## Future Enhancements
- Implement AI for single-player mode
- Improve UI design with animations
- Add sound effects

## Contributing
Feel free to fork the repository and submit pull requests for improvements.

## License
This project is licensed under the MIT License.

---

Enjoy playing Tic Tac Toe!
