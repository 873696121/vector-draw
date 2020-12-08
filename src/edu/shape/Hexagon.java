package edu.shape;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.io.Serializable;

public class Hexagon extends MyShape implements Serializable {
    public Hexagon(Integer x1, Integer y1, Color lineColor) {
        super(x1, y1, lineColor);
    }

    public Hexagon(Integer x1, Integer y1, Integer x2, Integer y2, Color lineColor) {
        super(x1, y1, x2, y2, lineColor);
    }

    @Override
    public void draw(Graphics g) {
        double len = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double X1, X2, Y1, Y2, x3, y3, x4, y4, x5, y5, x6, y6;
        X1 = (double) x1;
        X2 = (double) x2;
        Y1 = (double) y1;
        Y2 = (double) y2;

        x4 = X2;
        y4 = Y2;

        X2 = x4;
        Y2 = Y1;
        x5 = X1;
        y5 = y4;
        double midX, midY;
        midX = (X1 + x4) / 2;
        midY = (Y1 + y4) / 2;
        x3 = midX + len / 2;
        y3 = midY;
        x6 = midX - len / 2;
        y6 = midY;


        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(lineColor);
        GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,6);
        polygon.moveTo(X1, Y1);
        polygon.lineTo(X2, Y2);
        polygon.lineTo(x3, y3);
        polygon.lineTo(x4, y4);
        polygon.lineTo(x5, y5);
        polygon.lineTo(x6, y6);
        polygon.lineTo(X1, Y1);
        polygon.closePath();
        g2.draw(polygon);
    }
}
