package edu.components;

import edu.model.Model;
import edu.shape.*;
import edu.shape.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *The main function of the custom panel component is to bind the listener to get the point where the mouse is pressed
 */
public class MyPanel extends JPanel{
    // save the color currently to draw
    private static Color currentColor;
    private MyShape currentShape;
    private Model model;

    public MyPanel(Model draw){
        this.model = draw;
        this.setBackground(Color.WHITE);
    }

    /**
     * add the listener
     */
    public void addListener(){
        MyListener myListener = new MyListener();
        addMouseMotionListener(myListener);
        addMouseListener(myListener);
    }

    /**
     *Call color selector
     */
    public void chooseColor() {
        currentColor = JColorChooser.showDialog(this, "choose a color", Model.getCurrentColor());
    }


    /**
     * Customize the listener to set the current coordinates of the mouse when the mouse is pressed and raised
     */
    class MyListener extends MouseAdapter implements MouseMotionListener{
        @Override
        public void mousePressed(MouseEvent e) {
            String type = Model.getShapeType();
            if("line".equals(type)){
                currentShape = new Line(e.getX(), e.getY(), currentColor);
            }
            else if("rectangle".equals(type)){
                currentShape = new Rectangle(e.getX(), e.getY(), currentColor);
            }
            else if("ellipse".equals(type)){
                currentShape = new Ellipse(e.getX(), e.getY(), currentColor);
            }
            else if("fivePointedStar".equals(type)){
                currentShape = new FivePointedStar(e.getX(), e.getY(), currentColor);
            }
            else if("square".equals(type)){
                currentShape = new Square(e.getX(), e.getY(), currentColor);
            }
            else if("circle".equals(type)){
                currentShape = new Circle(e.getX(), e.getY(), currentColor);
            }
            else if("triangle".equals(type)){
                currentShape = new Triangle(e.getX(), e.getY(), currentColor);
            }
            else if("parallelogram".equals(type)){
                currentShape = new Parallelogram(e.getX(), e.getY(), currentColor);
            }
            else if("hexagon".equals(type)){
                currentShape = new Hexagon(e.getX(), e.getY(), currentColor);
            }
        }



        @Override
        public void mouseReleased(MouseEvent e) {
            if(currentShape != null){
                String type = Model.getShapeType();
                if("line".equals(type)){
                    deductionForLine(e);
                    model.addLine(currentShape);
                }
                else if("rectangle".equals(type)){
                    deductionForRectangles(e);
                    model.addRectangle(currentShape);
                }
                else if("ellipse".equals(type)){
                    deductionForEllipse(e);
                    model.addEllipse(currentShape);
                }
                else if("fivePointedStar".equals(type)){
                    deductionForFivePointedStars(e);
                    model.addFivePointedStars(currentShape);
                }
                else if("circle".equals(type)){
                    deductionForCircle(e);
                    model.addCircle(currentShape);
                }
                else if("square".equals(type)){
                    deductionForSquare(e);
                    model.addSquare(currentShape);
                }
                else if("hexagon".equals(type)){
                    deductionForHexagon(e);
                    model.addHexagon(currentShape);
                }
                else if("parallelogram".equals(type)){
                    deductionForParallelogram(e);
                    model.addParallelogram(currentShape);
                }
                else if("triangle".equals(type)){
                    deductionForTriangle(e);
                    model.addTriangle(currentShape);
                }
                currentShape = null;
            }
        }


        /**
         * Coordinate processing, the same as below
         * @param e
         */
        private void deductionForTriangle(MouseEvent e) {
            deductionForLine(e);
            coordinateTransform();
        }

        private void deductionForParallelogram(MouseEvent e) {
            deductionForLine(e);
            coordinateTransform();
        }

        private void deductionForHexagon(MouseEvent e) {
            deductionForLine(e);
            coordinateTransform();
        }

        private void deductionForCircle(MouseEvent e) {
            deductionForEllipse(e);
        }

        private void deductionForSquare(MouseEvent e) {
            deductionForEllipse(e);
        }

        private void deductionForFivePointedStars(MouseEvent e) {
            deductionForLine(e);
            coordinateTransform();
        }


        private void deductionForEllipse(MouseEvent e) {
            deductionForLine(e);
            coordinateTransform();
            currentShape.setX2(Math.abs(currentShape.getX1() - currentShape.getX2()));
            currentShape.setY2(Math.abs(currentShape.getY1() - currentShape.getY2()));
        }

        private void deductionForRectangles(MouseEvent e) {
            deductionForLine(e);
            coordinateTransform();
            currentShape.setX2(currentShape.getX2() - currentShape.getX1());
            currentShape.setY2(currentShape.getY2() - currentShape.getY1());
        }

        private void deductionForLine(MouseEvent e) {
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());
        }

        private void coordinateTransform(){

            int x1 = currentShape.getX1(), y1 = currentShape.getY1(), x2 = currentShape.getX2(), y2 = currentShape.getY2();
            int minX = Math.min(x1, x2);
            int minY = Math.min(y1, y2);
            int maxX = Math.max(x1, x2);
            int maxY = Math.max(y1, y2);
            currentShape.setX1(minX);
            currentShape.setY1(minY);
            currentShape.setX2(maxX);
            currentShape.setY2(maxY);
        }
    }
}
