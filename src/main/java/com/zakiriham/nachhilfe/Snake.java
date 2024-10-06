package com.zakiriham.nachhilfe;


import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


public class Snake {

    private int x;
    private int y;

    public Snake(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(10,10,1,1);
    }
}