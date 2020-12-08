package edu.shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.Serializable;

public class Ellipse extends MyShape implements Serializable {

    public Ellipse(Integer x1, Integer y1, Integer x2, Integer y2, Color lineColor){
        super(x1, y1, x2, y2, lineColor);
    }

    public Ellipse(int x, int y, Color currentColor) {
        super(x, y, currentColor);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(lineColor);
        g2.draw(new Ellipse2D.Double(x1, y1, x2, y2));
    }
}
