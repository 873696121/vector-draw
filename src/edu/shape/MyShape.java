package edu.shape;

import java.awt.*;
import java.io.Serializable;

/**
 *Custom shape class, define the coordinates and colors of graphics, and define the abstract method draw
 */
public abstract class MyShape implements Serializable {

    protected Integer x1, x2,  y1, y2;
    protected Color lineColor;

    public abstract void draw(Graphics g);

    public MyShape(Integer x1, Integer y1, Color lineColor) {
        setX1(x1);
        setY1(y1);
        setLineColor(lineColor);
    }

    public MyShape(Integer x1, Integer y1, Integer x2, Integer y2, Color lineColor) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setLineColor(lineColor);
    }


    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }
}
