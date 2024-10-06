package com.zakiriham.nachhilfe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import javafx.application.Platform;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.LinkedList;

/**
 * JavaFX App
 */
public class SnakeGame {

    private int width;
    private int height;

    private Thread t = null;
    private volatile boolean interrupted;

    public static final int UNIT = 20;

    private Snake snake;
    private List<Snake> snakes = new LinkedList<Snake>();
    private GraphicsContext gc;

    public SnakeGame(int width, int height){
        this.width = width;
        this.height = height;

        snake = new Snake(width/2, height/2 );

        snakes.add(new FatSnake(0,0) );
        snakes.add(new Snake(width/2, height/2 ) );
        
    }

    private void gameLoop(){
        while(!interrupted){
            try{
                Thread.sleep(400);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }

            System.out.println("The game loop works!");
            gc.setFill(Color.WHITE);
            gc.fillRect(0,0, width, height);

            for(Snake snake: snakes){
                snake.draw(gc);
            }

        }
    }

    public void buildGUIAndShowStage(Stage primaryStage) {
        primaryStage.setTitle("Snake");
       
        MenuBar menuBar = new MenuBar();

        Menu menu1 = new Menu("Game");

        menuBar.getMenus().add(menu1);

        Menu menu = new Menu("Menu 1");
        MenuItem menuItem1 = new MenuItem("New Game");
        MenuItem menuItem2 = new MenuItem("Exit");

        menuItem2.setOnAction(e -> {
            System.out.println("Menu Item Exit was clicked");
            interrupted = true;
            Platform.exit();
        });

        menu1.getItems().add(menuItem1);
        menu1.getItems().add(menuItem2);

        VBox vBox = new VBox(menuBar);

        Canvas canvas = new Canvas(width * UNIT, height * UNIT);
        canvas.setFocusTraversable(true);
        canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                System.out.println("Key event handled!");
                Snake snake = snakes.get(0);
                 switch (event.getCode()) {
                    case UP:    snake.moveUpwards(); break;
                    case DOWN:  snake.moveDownwards(); break;
                    case LEFT:  snake.moveToTheLeft(); break;
                    case RIGHT: snake.moveToTheRight(); break;
                    default: System.out.println("Don't react to this key!");
                }
            }
        });
        gc = canvas.getGraphicsContext2D();
        gc.scale(UNIT,UNIT);
        //drawShapes(gc);
        vBox.getChildren().add(canvas);
        primaryStage.setScene(new Scene(vBox));

        t = new Thread(){
            @Override
            public void run(){
                gameLoop();
            }
        };
        t.start();

        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
    }

   
}