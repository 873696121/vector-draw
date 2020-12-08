package edu.shape;

import edu.model.Model;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Rectangle extends MyShape implements Serializable {

    public Rectangle(Integer x1, Integer y1, Integer x2, Integer y2, Color lineColor){
        super(x1, y1, x2, y2, lineColor);
    }

    public Rectangle(Integer x1, Integer y1, Color lineColor){
        super(x1, y1, lineColor);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.getLineColor());
        g2.drawRect(x1, y1, x2, y2);
//        System.out.println(x1 + " " + y1 + " " + x2  + " " + y2);
    }
}
