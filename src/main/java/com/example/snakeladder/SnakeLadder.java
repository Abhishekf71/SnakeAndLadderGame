package com.example.snakeladder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public static final int tileSize = 40, height=10, width=10;
    int lowerLine = tileSize*height+10;
    Player firstPlayer = new Player(tileSize, Color.BLACK, "Amit");
    Player secondPlayer = new Player(tileSize-10, Color.WHITE, "Sumit");

    public Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize, height*tileSize+50);
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
        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(250);
        playerTwoButton.setTranslateY(lowerLine+10);




        root.getChildren().addAll(boardImage,playerOneButton,playerTwoButton, firstPlayer.getCoin(), secondPlayer.getCoin());


//        root.getChildren().add(new Tile(tileSize));
        return root;
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