package edu.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyButton extends JButton {
    public MyButton(){
        super();
    }

    public MyButton(String text, String iconName, String tip){
        this.setText(text);
        this.setBackground(Color.GRAY);
        this.setToolTipText(tip);
        this.setBorder(null);
        String origin = MyButton.class.getResource("").getPath();
        String path = origin + "../icon/" + iconName;
//        System.out.println(path);
        try {
            Image image = ImageIO.read(new File(path)).getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING);
            this.setIcon(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
