package com.example.snakeladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public static final int tileSize = 40, height=10, width=10;
    int diceValue;
    int lowerLine = tileSize*height+10;
    Player firstPlayer = new Player(tileSize, Color.BLACK, "Amit");
    Player secondPlayer = new Player(tileSize-10, Color.WHITE, "Sumit");
    Label rolledDiceValueLabel;
    boolean firstPlayerTurn = true, secondPlayerTurn = false,  gameStarted = false , anyPlayerWon = false;
    Button startGameButton;

    public Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize, height*tileSize+100);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                root.getChildren().add(tile);
            }
        }
        Image img = new Image("C:\\Users\\Abhishekf\\IdeaProjects\\SnakeLadder\\src\\main\\istockphoto-531466314-612x612.jpg");
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitWidth(tileSize*width);
        boardImage.setFitHeight(tileSize*height);

        Button playerOneButton = new Button("Player One");
        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(lowerLine+10);
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (gameStarted){
                    if (firstPlayerTurn){
                        setDiceValue();
                        firstPlayer.movePlayer(diceValue);
                        if (firstPlayer.playerWon() != null){
                            rolledDiceValueLabel.setText(firstPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                            startGameButton.setDisable(false);
                            startGameButton.setText("Start");
                            anyPlayerWon = true;
                        }
                        firstPlayerTurn = false;
                        secondPlayerTurn = true;
                    }
                }

            }
        });


        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(250);
        playerTwoButton.setTranslateY(lowerLine+10);
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (gameStarted){
                    if (secondPlayerTurn){
                        setDiceValue();
                        secondPlayer.movePlayer(diceValue);
                        if (secondPlayer.playerWon() != null){
                            rolledDiceValueLabel.setText(secondPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                            startGameButton.setDisable(false);
                            startGameButton.setText("Start");
                            anyPlayerWon = true;
                        }
                        secondPlayerTurn = false;
                        firstPlayerTurn = true;

                    }
                }
            }
        });

        startGameButton = new Button("Start");
        startGameButton.setTranslateX(130);
        startGameButton.setTranslateY(lowerLine+50);
        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted = true;
                startGameButton.setText("Ongoing Game");
                startGameButton.setDisable(true);

            }
        });

        rolledDiceValueLabel = new Label("Start the Game");
        rolledDiceValueLabel.setTranslateY(lowerLine+10);
        rolledDiceValueLabel.setTranslateX(130);


        root.getChildren().addAll(boardImage,playerOneButton,playerTwoButton, firstPlayer.getCoin(), secondPlayer.getCoin(),rolledDiceValueLabel, startGameButton);


//        root.getChildren().add(new Tile(tileSize));
        return root;
    }

    private void setDiceValue(){
        diceValue = (int)(Math.random()*6+1);
        rolledDiceValueLabel.setText("Dice Value: "+ diceValue);
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}