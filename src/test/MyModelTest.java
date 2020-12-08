package test;

import edu.model.Model;
import edu.shape.*;
import edu.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Stack;
import static org.junit.Assert.*;

// test the add function
public class MyModelTest {

    private Model model;
    private Stack<MyShape> currentShapes;
    private Stack<MyShape> removedShapes;

    @Before
    public void init(){
        model = new Model();
        currentShapes = Model.getCurrentShapes();
        removedShapes = Model.getRemovedShapes();
    }

    public void delete(){
        model = null;
        currentShapes = null;
        removedShapes = null;
    }

    @Test
    public void testAddLine(){
        Line line = new Line(22, 33, Color.YELLOW);
        model.addLine(line);
        assertEquals(currentShapes.size(), 1);
        assertEquals(currentShapes.peek(), line);
    }

    @Test
    public void testAddCircle(){
        Circle circle = new Circle(11, 22, Color.WHITE);
        model.addCircle(circle);
        assertEquals(currentShapes.peek(), circle);
    }

    @Test
    public void testAddEllipse(){
        Ellipse ellipse = new Ellipse(22, 33, Color.YELLOW);
        model.addEllipse(ellipse);
        assertEquals(currentShapes.peek(), ellipse);
    }

    @Test
    public void testAddFivePointedStar(){
        FivePointedStar fivePointedStar = new FivePointedStar(22, 33, Color.BLACK);
        model.addFivePointedStars(fivePointedStar);
        assertEquals(currentShapes.peek(), fivePointedStar);
    }

    @Test
    public void testAddRectangle(){
        Rectangle rectangle = new Rectangle(33, 44, Color.YELLOW);
        model.addRectangle(rectangle);
        assertEquals(currentShapes.peek(), rectangle);
    }

    @Test
    public void testSquare(){
        Square square = new Square(22, 33, Color.WHITE);
        model.addSquare(square);
        assertEquals(currentShapes.peek(), square);
    }

    @Test
    public void testTriangle(){
        Triangle triangle = new Triangle(22, 33, Color.WHITE);
        model.addSquare(triangle);
        assertEquals(currentShapes.peek(), triangle);
    }

    @Test
    public void testParallelogram(){
        Parallelogram parallelogram = new Parallelogram(22, 33, Color.WHITE);
        model.addSquare(parallelogram);
        assertEquals(currentShapes.peek(), parallelogram);
    }

    @Test
    public void testHexagon(){
        Hexagon hexagon = new Hexagon(22, 33, Color.WHITE);
        model.addSquare(hexagon);
        assertEquals(currentShapes.peek(), hexagon);
    }

    @Test
    public void testUndo(){
        Square square = new Square(3, 33, Color.YELLOW);
        int n = 300;
        for(int i = 0; i < n; i ++){
            model.addSquare(square);
        }
        for(int i = 1; i <= n; i ++){
            model.undo();
            assertEquals(currentShapes.size(), n - i);
            assertEquals(removedShapes.size(), i);
        }
    }

    @Test
    public void testRedo(){
        Square square = new Square(3, 33, Color.YELLOW);
        int n = 300;
        for(int i = 0; i < n; i ++){
            model.addSquare(square);
        }
        for(int i = 0; i < n; i ++){
            model.undo();
        }
        for(int i = 1; i <= n; i ++){
            model.redo();
            assertEquals(currentShapes.size(), i);
            assertEquals(removedShapes.size(), n - i);
        }
    }
}
