package com.amirtaylor.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    int counter = 0;
    Button[][] gridArray = new Button[3][3];  // Store Buttons directly

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Create the Buttons to add X or O
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        Button button5 = new Button();
        Button button6 = new Button();
        Button button7 = new Button();
        Button button8 = new Button();
        Button button9 = new Button();
        Button playAgainButton = new Button();
        
        // Store Buttons in 2D array
        gridArray[0][0] = button1;
        gridArray[0][1] = button2;
        gridArray[0][2] = button3;
        gridArray[1][0] = button4;
        gridArray[1][1] = button5;
        gridArray[1][2] = button6;
        gridArray[2][0] = button7;
        gridArray[2][1] = button8;
        gridArray[2][2] = button9;

        // Create the Board Using GridPane Layout Manager
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);

        // Add the Buttons to the Board (Column #, Row #)
        gridpane.add(button1, 0, 0);
        gridpane.add(button2, 0, 1);
        gridpane.add(button3, 0, 2);
        gridpane.add(button4, 1, 0);
        gridpane.add(button5, 1, 1);
        gridpane.add(button6, 1, 2);
        gridpane.add(button7, 2, 0);
        gridpane.add(button8, 2, 1);
        gridpane.add(button9, 2, 2);
        
        // Show Board Lines
        gridpane.setGridLinesVisible(true);

        //Place playAgain button but make it invisible
        GridPane playAgain = new GridPane();
        playAgain.add(playAgainButton,0,0);
        playAgain.setAlignment(Pos.BOTTOM_CENTER);
        playAgain.setPadding(new Insets(15));
        playAgainButton.setPrefSize(300,50);
        playAgainButton.setVisible(false);
        playAgainButton.setText("Play Again");
        playAgainButton.setStyle("-fx-font-size: 30; -fx-font-weight: bold;");

        // Tic Tac Toe Title/Win Message
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        Text title = new Text("Tic Tac Toe");
        title.setStyle("-fx-font-size: 40; -fx-font-weight: bold;");
        vbox.getChildren().addAll(title, gridpane,playAgain);


        // Set common font style for all buttons and Add Functionality and Check buttons for Win Condition
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[i].length; j++) {
                Button button = gridArray[i][j];
                button.setPrefSize(100, 100);
                button.setFont(javafx.scene.text.Font.font("Arial", 30));
                button.setStyle("-fx-font-weight: bold;");

                button.setOnAction(e -> {
                    if (button.getText().isEmpty()) {
                        if (counter % 2 == 0) {
                            button.setText("X");
                            button.setStyle("-fx-text-fill: red;-fx-font-size: 30px; -fx-font-weight: bold;");
                        } else {
                            button.setText("O");
                            button.setStyle("-fx-text-fill: blue;-fx-font-size: 30px; -fx-font-weight: bold;");
                        }
                        button.setMouseTransparent(true);  // Disable the button after click
                        counter++;
                        if (checkWin(button.getText())) {
                            title.setText(button.getText() + " Wins!!");
                            playAgainButton.setVisible(true);
                            disableAllButtons();
                        }
                        else if (counter==9){
                            title.setText("Its a Draw");
                            playAgainButton.setVisible(true);
                            disableAllButtons();
                        }
                    }
                });
            }
        }
        playAgainButton.setOnAction(e -> {
            resetBoard();
            title.setText("Tic Tac Toe");
            playAgainButton.setVisible(false);
        });

        // Adding Board and Title to the scene
        Scene scene = new Scene(vbox);

        // Configuring the Stage
        stage.setHeight(500);
        stage.setWidth(500);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }

    // Getting the Text from Button
    private String getButtonText(Button button) {
        return button.getText();
    }

    // Checking for Win
    private boolean checkWin(String player) {
        // Check Columns
        for (int col = 0; col < 3; col++) {
            if (getButtonText(gridArray[0][col]).equals(player) &&
                getButtonText(gridArray[1][col]).equals(player) &&
                getButtonText(gridArray[2][col]).equals(player)) {
                return true;
            }
        }

        // Check Rows
        for (int row = 0; row < 3; row++) {
            if (getButtonText(gridArray[row][0]).equals(player) &&
                getButtonText(gridArray[row][1]).equals(player) &&
                getButtonText(gridArray[row][2]).equals(player)) {
                return true;
            }
        }

        // Check Diagonal
        if (getButtonText(gridArray[0][0]).equals(player) &&
            getButtonText(gridArray[1][1]).equals(player) &&
            getButtonText(gridArray[2][2]).equals(player)) {
            return true;
        }
        if (getButtonText(gridArray[0][2]).equals(player) &&
            getButtonText(gridArray[1][1]).equals(player) &&
            getButtonText(gridArray[2][0]).equals(player)) {
            return true;
        }

        return false; // No win condition met
    }
    private void disableAllButtons() {//Disable All Buttons
        for (Button[] row : gridArray) {
            for (Button btn : row) {
                btn.setMouseTransparent(true);
            }
        }
    }
    private void resetBoard() {
        counter = 0;
        for (Button[] row : gridArray) {
            for (Button btn : row) {
                btn.setText("");
                btn.setStyle("-fx-text-fill: black; -fx-font-size: 30px; -fx-font-weight: bold;");
                btn.setMouseTransparent(false);
            }
        }
    }
}
