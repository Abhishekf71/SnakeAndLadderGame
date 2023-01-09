package com.example.snakeladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
