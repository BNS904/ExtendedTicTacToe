package com.example.tictactoegame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Controller {

    public Button resetButton;
    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private Button b10;

    @FXML
    private Button b11;

    @FXML
    private Button b12;

    @FXML
    private Button b13;

    @FXML
    private Button b14;

    @FXML
    private Button b15;

    @FXML
    private Button b16;

    @FXML
    private Button b17;

    @FXML
    private Button b18;

    @FXML
    private Button b19;

    @FXML
    private Button b20;

    @FXML
    private Button b21;

    @FXML
    private Button b22;

    @FXML
    private Button b23;

    @FXML
    private Button b24;

    @FXML
    private Button b25;

    @FXML
    private Label resultText;

    @FXML
    private Label subText;

    ArrayList<Button> buttons;

    int turn = 0;
    int markedButton = 0;

    public void initialize() {
        buttons = new ArrayList<>(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11,
                b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25));
        buttons.forEach(button -> {
            checkButton(button);
            button.setFocusTraversable(false);
        });
    }

    private void checkButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
                showSymbol(button);
                anyWinner();
        });
    }

    public void showSymbol(Button button) {
        if(turn % 2 == 0){
            button.setTextFill(Color.RED);
            button.setFont(Font.font(25));
            button.setText("X");
        } else {
            button.setTextFill(Color.BLUE);
            button.setFont(Font.font(25));
            button.setText("O");
        }
        turn++;
        button.setDisable(true);

    }

    public void anyWinner() {
        markedButton++;
        for(int i = 1; i < 13; i++) {
             String winCondition = switch (i) {
                case 1 -> b1.getText() + b2.getText() + b3.getText() + b4.getText() + b5.getText();
                case 2 -> b6.getText() + b7.getText() + b8.getText() + b9.getText() + b10.getText();
                case 3 -> b11.getText() + b12.getText() + b13.getText() + b14.getText() + b15.getText();
                case 4 -> b16.getText() + b17.getText() + b18.getText() + b19.getText() + b20.getText();
                case 5 -> b21.getText() + b22.getText() + b23.getText() + b24.getText() + b25.getText();
                case 6 -> b1.getText() + b6.getText() + b11.getText() + b16.getText() + b21.getText();
                case 7 -> b2.getText() + b7.getText() + b12.getText() + b17.getText() + b22.getText();
                case 8 -> b3.getText() + b8.getText() + b13.getText() + b18.getText() + b23.getText();
                case 9 -> b4.getText() + b9.getText() + b14.getText() + b19.getText() + b24.getText();
                case 10 -> b5.getText() + b10.getText() + b15.getText() + b20.getText() + b25.getText();
                case 11 -> b1.getText() + b7.getText() + b13.getText() + b19.getText() + b25.getText();
                case 12 -> b21.getText() + b17.getText() + b13.getText() + b9.getText() + b5.getText();
                default -> null;
            };

             //System.out.println("Test:" + winCondition);


            if(Objects.equals(winCondition, "XXXXX")) {
                resultText.setText("Player \"X\" has won!");
                endGame();
            }
            else if (Objects.equals(winCondition, "OOOOO")) {
                resultText.setText("Player \"O\" has won!");
                endGame();
            }
            else if (markedButton == 25) {
                resultText.setText("It's a tie!");
                endGame();
            }
        }

    }

    public void endGame() {
        buttons.forEach(button -> button.setDisable(true));
        subText.setText("Click reset to play again");
    }

    public void resetGame() {
        resultText.setText("Welcome to 5x5 TicTacToe!");
        subText.setText("Click a square to start");
        markedButton = 0;
        turn = 0;
        buttons.forEach(button -> {
            button.setDisable(false);
            button.setText("");
        });
    }
}