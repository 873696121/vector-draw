package test;

import edu.components.MyButton;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyButtonTest {

    public MyButton myButton;

    @Test
    public void testMyButton(){
        myButton = new MyButton("rectangle","Rectangle.png", "Rectangle");
        assertNotNull(myButton);
        assertEquals(myButton.getText(), "rectangle");
    }
}
