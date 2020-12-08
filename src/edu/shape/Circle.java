package edu.shape;

import java.awt.*;
import java.io.Serializable;

public class Circle extends Ellipse implements Serializable {
    public Circle(Integer x1, Integer y1, Integer x2, Integer y2, Color lineColor) {
        super(x1, y1, x2, y2, lineColor);
    }

    public Circle(int x, int y, Color currentColor) {
        super(x, y, currentColor);
    }

    @Override
    public void draw(Graphics g) {
        int len = Math.max(x2, y2);
        x2 = len;
        y2 = len;
        super.draw(g);
    }
}
