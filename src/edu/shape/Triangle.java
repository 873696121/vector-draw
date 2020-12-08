package edu.shape;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.io.Serializable;

public class Triangle extends MyShape implements Serializable {

    public Triangle(Integer x1, Integer y1, Color lineColor) {
        super(x1, y1, lineColor);
    }

    public Triangle(Integer x1, Integer y1, Integer x2, Integer y2, Color lineColor) {
        super(x1, y1, x2, y2, lineColor);
    }

    @Override
    public void draw(Graphics g) {
        int x3 = x1, y3 = y2;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(lineColor);
        GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,3);
        polygon.moveTo(x1, y1);
        polygon.lineTo(x2, y2);
        polygon.lineTo(x3, y3);
        polygon.lineTo(x1, y1);
        polygon.closePath();
        g2.draw(polygon);
    }
}
