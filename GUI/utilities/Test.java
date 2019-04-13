import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

import kutta.MyColor;
import kutta.MyFont;

public class Test {

    MyFont fffsdfsd;

    MyFont baba;

    public Test() {
        fffsdfsd = new MyFont();
        baba = fffsdfsd.roboto();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Button Example");
        final JTextField tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        JButton b = new JButton("Click Here");
        b.setForeground(MyColor.textColor());

        b.setFont(baba);

        b.setBackground(MyColor.primaryColor());
        b.setBounds(50, 100, 95, 30);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("Welcome to Javatpoint.");
            }
        });

        JLabel dog = new JLabel("Tor mayre bap seven up");
        dog.setBounds(150, 20, 500, 500);
        dog.setBackground(Color.BLACK);
        dog.setFont(MyFont.roboto());
        f.add(dog);

        f.add(b);
        f.add(tf);
        f.setSize(1000, 1000);
        f.setLayout(null);
        f.setVisible(true);
    }
}