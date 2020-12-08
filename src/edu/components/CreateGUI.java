package edu.components;

import edu.components.MyButton;
import edu.components.MyPanel;
import edu.model.Model;
import edu.shape.MyShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.Stack;

public class CreateGUI extends JFrame implements ActionListener, PropertyChangeListener {

    private MyButton color;
    private MyButton line;
    private MyButton rectangles;
    private MyButton ellipses;
    private MyButton fivePointedStars;
    private MyButton circle;
    private MyButton square;
    private MyButton triangle;
    private MyButton parallelogram;
    private MyButton hexagon;
    private MyButton undo;
    private MyButton redo;

    /**
     * the panel contains the buttons
     */
    private JPanel buttonArea;

    private MyPanel panel;

    /**
     * Provide data carrier for Sketchpad
     */
    private Model model;


    /**
     * initializing
     * @param model The listener inside the sketchpad needs to get the model
     */
    public CreateGUI(Model model){
        this.model = model;
        buttonArea = new JPanel();
        buttonArea.setBackground(Color.WHITE);
        buttonArea.setSize(100, 100);

        initButtons();
        addButtons();


        panel = new MyPanel(model);
        panel.addListener();
        panel.setBackground(Color.WHITE);

        drawFrame();
        model.addObserver(this);
        addListenersForButtons(this::actionPerformed);
    }

    /**
     * Rendering Sketchpad
     */
    private void drawFrame() {
        add(buttonArea, BorderLayout.NORTH);
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        pack();
        setBackground(Color.GRAY);
        setTitle("My painter");
        setVisible(true);
    }


    /**
     * initial the buttons
     */
    void initButtons(){
//        color = new MyButton("color","fill.png", "Fill Color");
//        line = new MyButton("line","LineSegment.png", "Line");
//        rectangles = new MyButton("rectangle","Rectangle.png", "Rectangle");
//        ellipses = new MyButton("ellipse","Ellipse.png", "Ellipse");
//        fivePointedStars = new MyButton("fivePointedStar","resize.png", "Five Pointed Star");
//        circle = new MyButton("circle", "Circle.png", "circle");
//        square = new MyButton("square", "Square.png", "square");
//        triangle = new MyButton("triangle", "Triangle.png", "triangle");
//        parallelogram = new MyButton("parallelogram", "resize.png", "parallelogram");
//        hexagon = new MyButton("hexagon", "resize.png", "hexagon");
//        undo = new MyButton("undo","undo.png", "Undo");
//        redo = new MyButton("redo", "redo.png", "Redo");

        color = new MyButton("color","color.png", "Fill Color");
        line = new MyButton("line","line.png", "Line");
        rectangles = new MyButton("rectangle","rectangle.png", "Rectangle");
        ellipses = new MyButton("ellipse","ellipse.png", "Ellipse");
        fivePointedStars = new MyButton("fivePointedStar","fivePointedStar.png", "Five Pointed Star");
        circle = new MyButton("circle", "circle.png", "circle");
        square = new MyButton("square", "square.png", "square");
        triangle = new MyButton("triangle", "triangle.png", "triangle");
        parallelogram = new MyButton("parallelogram", "parallelogram.png", "parallelogram");
        hexagon = new MyButton("hexagon", "hexagon.png", "hexagon");
        undo = new MyButton("undo","undo.png", "Undo");
        redo = new MyButton("redo", "redo.png", "Redo");
    }


    /**
     * add the buttons to the panel
     */
    void addButtons(){
        buttonArea.add(color);
        buttonArea.add(line);
        buttonArea.add(rectangles);
        buttonArea.add(ellipses);
        buttonArea.add(fivePointedStars);
        buttonArea.add(circle);
        buttonArea.add(square);
        buttonArea.add(triangle);
        buttonArea.add(parallelogram);
        buttonArea.add(hexagon);
        buttonArea.add(undo);
        buttonArea.add(redo);
    }

    /**
     * add the listeners to the buttons
     * @param listener
     */
    void addListenersForButtons(ActionListener listener){
        color.addActionListener(listener);
        line.addActionListener(listener);
        rectangles.addActionListener(listener);
        ellipses.addActionListener(listener);
        fivePointedStars.addActionListener(listener);
        circle.addActionListener(listener);
        square.addActionListener(listener);
        triangle.addActionListener(listener);
        parallelogram.addActionListener(listener);
        hexagon.addActionListener(listener);
        undo.addActionListener(listener);
        redo.addActionListener(listener);
    }

    /**
     *Listen to the properties of the model and redraw all graphics once they change
     * @param event
     */
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getSource() == model && "theText".equals(event.getPropertyName())) {
            panel.repaint();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Graphics g = panel.getGraphics();
                    g.setColor(Model.getCurrentColor());
                    Stack<MyShape> currentShapes = Model.getCurrentShapes();
                    for(MyShape shape : currentShapes){
                        shape.draw(g);
                    }
                }
            });
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == line){
            Model.setShapeType("line");
        }
        else if(source == rectangles){
            Model.setShapeType("rectangle");
        }
        else if(source == ellipses){
            Model.setShapeType("ellipse");
        }
        else if(source == fivePointedStars){
            Model.setShapeType("fivePointedStar");
        }
        else if(source == circle){
            Model.setShapeType("circle");
        }
        else if(source == square){
            Model.setShapeType("square");
        }
        else if(source == hexagon){
            Model.setShapeType("hexagon");
        }
        else if(source == parallelogram){
            Model.setShapeType("parallelogram");
        }
        else if(source == triangle){
            Model.setShapeType("triangle");
        }
        else if(source == undo){
            model.undo();
        }
        else if(source == redo){
            model.redo();
        }
        else if(source == color){
            panel.chooseColor();
        }
    }
}
