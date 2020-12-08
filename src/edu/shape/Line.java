package edu.shape;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.Serializable;

public class Line extends MyShape implements Serializable {

    public Line(Integer startX, Integer startY, Color lineColor){
        super(startX, startY, lineColor);
    }

    public Line(Integer x1, Integer y1, Integer x2, Integer y2, Color lineColor){
        super(x1, y1, x2, y2, lineColor);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(lineColor);
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
    }
}
