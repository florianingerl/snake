package com.zakiriham.nachhilfe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */


public class SnakeApp extends Application {

    @Override
    public void start(Stage stage) {
        

        SnakeGame game = new SnakeGame(30, 30);
        game.buildGUIAndShowStage(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}