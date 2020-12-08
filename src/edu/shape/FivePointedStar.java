package edu.shape;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.io.Serializable;

public class FivePointedStar extends MyShape implements Serializable {
    public Double[] X;
    public Double[] Y;

    public FivePointedStar(Integer x1, Integer y1, Color lineColor) {
        super(x1, y1, lineColor);
        X = new Double[6];
        Y = new Double[6];
        X[0] = (double)x1;
        Y[0] = (double)y1;
    }


    public FivePointedStar(Integer x1, Integer y1, Integer x2, Integer y2, Color lineColor) {
        super(x1, y1, x2, y2, lineColor);
        X[4] = (double) x2;
        Y[4] = (double) y2;
    }

    @Override
    public void draw(Graphics g) {
        int startX = x1, startY = y1, endX = x2, endY = y2;
        double len = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        X[4] = (double) x2;
        Y[4] = (double) y2;
        X[3] = (double) startX + len;
        Y[3] = (double) startY;
        X[2] = (double) startX + X[3] - X[4];
        Y[2] = (double) endY;
        X[1] = (X[0] + X[3]) / 2;
        Y[1] = endY - len * Math.cos(Math.toRadians(15));

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(lineColor);
        GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,X.length);
        polygon.moveTo(X[0],Y[0]);
        polygon.lineTo(X[4],Y[4]);
        polygon.lineTo(X[1],Y[1]);
        polygon.lineTo(X[2],Y[2]);
        polygon.lineTo(X[3],Y[3]);
        polygon.lineTo(X[0],Y[0]);
        polygon.closePath();
        g2.draw(polygon);
    }
}
