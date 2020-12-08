package edu.model;

import edu.shape.MyShape;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;
import java.util.Stack;

/**
 * the model in mvc, give the definition of the data
 */
public class Model {
    // the current color to use
    private static Color currentColor;
    // the current shape to use (Distinguished by the name of the shape)
    private static String ShapeType;
    // the shapes that have been drawn on the drawing board
    private static Stack<MyShape> currentShapes;
    // the shapes that have been drawn and undo
    private static Stack<MyShape> removedShapes;
    // Components of observer pattern
    private PropertyChangeSupport support;
    private String old = null;

    // initialize
    public Model() {
        currentColor = Color.BLACK;
        currentShapes = new Stack<>();
        removedShapes = new Stack<>();
        support = new PropertyChangeSupport(this);
    }

    // Save the graph to be drawn into the array, set shapeType as the current graph, and inform the observer that the attribute changes,
    // so as to draw all the graphics further
    // The following methods are the same
    public void addLine(MyShape line) {
        ShapeType = "line";
        currentShapes.add(line);
        support.firePropertyChange("theText", old, "trigger");
    }

    public void addRectangle(MyShape rectangle) {
        ShapeType = "rectangle";
        currentShapes.add(rectangle);
        support.firePropertyChange("theText", old, "trigger");
    }

    public void addEllipse(MyShape ellipse) {
        ShapeType = "ellipse";
        currentShapes.add(ellipse);
        support.firePropertyChange("theText", old, "trigger");
    }

    public void addFivePointedStars(MyShape fivePointedStars) {
        ShapeType = "fivePointedStar";
        currentShapes.add(fivePointedStars);
        support.firePropertyChange("theText", old, "trigger");
    }

    public void addCircle(MyShape circle) {
        ShapeType = "circle";
        currentShapes.add(circle);
        support.firePropertyChange("theText", old, "trigger");
    }

    public void addSquare(MyShape square) {
        ShapeType = "square";
        currentShapes.add(square);
        support.firePropertyChange("theText", old, "trigger");
    }

    public void addTriangle(MyShape triangle){
        ShapeType = "triangle";
        currentShapes.add(triangle);
        support.firePropertyChange("theText", old, "trigger");
    }

    public void addParallelogram(MyShape parallelogram){
        ShapeType = "parallelogram";
        currentShapes.add(parallelogram);
        support.firePropertyChange("theText", old, "trigger");
    }

    public void addHexagon(MyShape hexagon){
        ShapeType = "hexagon";
        currentShapes.add(hexagon);
        support.firePropertyChange("theText", old, "trigger");
    }

    public void addObserver(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }


    // As long as currentShapes not empty, that means we can undo the last shape we have drew
    public void undo() {
        if(!currentShapes.isEmpty()){
            MyShape delete = currentShapes.pop();
            removedShapes.add(delete);
            support.firePropertyChange("theText", old, "trigger");
        }
    }

    // As long as removedShapes not empty, that means we can redo the last shape we have undo
    public void redo() {
        if(!removedShapes.isEmpty()){
            MyShape delete = removedShapes.pop();
            currentShapes.add(delete);
            support.firePropertyChange("theText", old, "trigger");
        }
    }


    // getter and setter
    public static Color getCurrentColor() {
        return currentColor;
    }

    public static void setCurrentColor(Color currentColor) {
        Model.currentColor = currentColor;
    }

    public static String getShapeType() {
        return ShapeType;
    }

    public static void setShapeType(String shapeType) {
        ShapeType = shapeType;
    }

    public static Stack<MyShape> getCurrentShapes() {
        return currentShapes;
    }

    public static void setCurrentShapes(Stack<MyShape> currentShapes) {
        Model.currentShapes = currentShapes;
    }

    public static Stack<MyShape> getRemovedShapes() {
        return removedShapes;
    }

    public static void setRemovedShapes(Stack<MyShape> removedShapes) {
        Model.removedShapes = removedShapes;
    }

    public PropertyChangeSupport getSupport() {
        return support;
    }

    public void setSupport(PropertyChangeSupport support) {
        this.support = support;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }
}











