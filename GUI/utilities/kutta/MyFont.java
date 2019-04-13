package kutta;

import java.awt.Font;

public class MyFont {

    // private static Font roboto;
    private Font robotoBold;
    private static Font customFont;

    public MyFont() {
        // try {
        // Font font = Font.createFont(Font.TRUETYPE_FONT,
        // MyFont.class.getResourceAsStream("DAGGERSQUARE.otf"));
        // roboto = font.deriveFont(Font.BOLD, 100);
        // } catch (Exception ex) {
        // System.err.println("Excetion on creating font: " + ex);
        // // roboto = new Font("arial ", Font.BOLD, 25);
        // }
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, MyFont.class.getResourceAsStream("Roboto-Thin.ttf"));
            customFont = font.deriveFont(Font.PLAIN, 100);
        } catch (Exception ex) {
        }

    }

    public Font roboto() {
        // roboto = new Font("consolas", Font.BOLD, 40);
        return customFont;
    }

}