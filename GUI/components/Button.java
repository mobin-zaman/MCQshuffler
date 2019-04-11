package gui.components;

import java.awt.Color;
import javax.swing.*;

public class Button {

    Color primaryColor;
    JButton pBtn;

    Button() {
        primaryColor = new Color(63, 81, 181);
        pBtn = new JButton("Khali Button");
        pBtn.setBounds(0, 0, 100, 40);
    }

    public JButton getPrimaryColor() {
        return pBtn;
    }
}