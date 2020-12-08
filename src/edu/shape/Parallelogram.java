package edu.shape;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.io.Serializable;

public class Parallelogram extends MyShape implements Serializable {
    public Parallelogram(Integer x1, Integer y1, Color lineColor) {
        super(x1, y1, lineColor);
    }

    public Parallelogram(Integer x1, Integer y1, Integer x2, Integer y2, Color lineColor) {
        super(x1, y1, x2, y2, lineColor);
    }

    @Override
    public void draw(Graphics g) {
        double len = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double x3, y3, x4, y4;
        x3 = (double)x2 + len;
        y3 = (double) y2;
        x4 = (double) x1 + len;
        y4 = (double) y1;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(lineColor);
        GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,3);
        polygon.moveTo(x1, y1);
        polygon.lineTo(x2, y2);
        polygon.lineTo(x3, y3);
        polygon.lineTo(x4, y4);
        polygon.lineTo(x1, y1);
        polygon.closePath();
        g2.draw(polygon);
    }
}
