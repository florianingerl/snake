package com.zakiriham.nachhilfe;


import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.util.List;
import java.util.LinkedList;


public class Snake {

    private int x;
    private int y;

    protected LinkedList<Point> points;

    public Snake(int x, int y){
        this.x = x;
        this.y = y;

        points = new LinkedList<Point>();
        points.add(new Point(x,y) );
        points.add(new Point(x-1,y) );
        points.add(new Point(x-2,y) );
    }

    public void draw(GraphicsContext gc){
        gc.setFill(Color.RED);

        for(Point p : points){
            gc.fillRect(p.x, p.y, 1,1);
        }
    }

    public void moveToTheRight(){
       Point head = points.get(0);
        points.addFirst(new Point(head.x +1, head.y ) );

        points.removeLast();
    }
    public void moveToTheLeft(){
        Point head = points.get(0);
        points.addFirst(new Point(head.x -1, head.y  ) );

        points.removeLast();
    }
    public void moveUpwards(){

        Point head = points.get(0);
        points.addFirst(new Point(head.x, head.y -1 ) );

        points.removeLast();
        
    }
    public void moveDownwards(){
        Point head = points.get(0);
        points.addFirst(new Point(head.x, head.y +1 ) );

        points.removeLast();
    }
}