package com.example.snakeladder;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle coin;
    private int coinPosition;
    private String name;
    private static Board gameboard = new Board();


    public Player(int tileSize , Color coinColor, String playerName){
        coinPosition = 1;
        this.name = playerName;
        coin = new Circle(tileSize/2);
        coin.setFill(coinColor);
        coin.setTranslateX(20);
        coin.setTranslateY(380);
    }

    public void movePlayer(int diceValue){
        if(coinPosition + diceValue <= 100){
            coinPosition += diceValue;
//            coin.setTranslateX(gameboard.getXCoordinate(coinPosition));
//            coin.setTranslateY(gameboard.getYCoordinate(coinPosition));
            translatePlayer();
            int newPosition = gameboard.getNextPosition(coinPosition);
            if (newPosition != coinPosition){
                coinPosition = newPosition;
                translatePlayer();
            }
        }

    }

    private void translatePlayer(){
        TranslateTransition move = new TranslateTransition(Duration.millis(1000), this.coin);
        move.setToX(gameboard.getXCoordinate(coinPosition));
        move.setToY(gameboard.getYCoordinate(coinPosition));
        move.setAutoReverse(false);
        move.play();

    }

    public String playerWon(){
        if (coinPosition == 100){
            return name + " Won The Game";
        }

        return null;
    }

    public void resetPlayer(){
        coin.setTranslateX(20);
        coin.setTranslateY(380);
    }
    public Circle getCoin() {
        return coin;
    }

    public int getCoinPosition() {
        return coinPosition;
    }

    public String getName() {
        return name;
    }
}
