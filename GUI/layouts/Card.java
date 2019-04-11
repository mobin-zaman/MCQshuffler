package layouts;

import java.awt.GridLayout;

import javax.swing.*;

public class Card extends JFrame {

    private JPanel panel1;
    private JPanel panel2;
    private GridLayout g1;
    private JLabel t1, t2, t3, t4, t5, t6;

    Card() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setTitle("This is the fucking Title");

        g1 = new GridLayout(2, 2);

        panel1 = new JPanel();
        panel1.setLayout(g1);

        t1 = new JLabel("Kire kuttarbassa");
        t1.setBounds(0, 0, 100, 20);
        panel1.add(t1);

        t2 = new JLabel("Kire kuttarbassa");
        t2.setBounds(0, 0, 100, 20);
        panel1.add(t2);

        t3 = new JLabel("Kire kuttarbassa");
        t3.setBounds(0, 0, 100, 20);
        panel1.add(t3);

        t4 = new JLabel("Kire kuttarbassa");
        t4.setBounds(0, 0, 100, 20);
        panel1.add(t4);

        this.add(panel1);

    }

    public static void main(String[] args) {
        Card c = new Card();
        c.setLocationRelativeTo(null);
        c.setVisible(true);
    }
}
