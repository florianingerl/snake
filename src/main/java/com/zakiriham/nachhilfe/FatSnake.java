package com.zakiriham.nachhilfe;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.util.List;
import java.util.LinkedList;

public class FatSnake extends Snake {

    public FatSnake(int x, int y){
        super(x,y);
    }

    @Override
    public void draw(GraphicsContext gc){
         gc.setFill(Color.BLUE);

        for(Point p : points){
            gc.fillRect(p.x, p.y, 2,2);
        }
    }
    
}