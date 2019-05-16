package gui.utilities;

import java.awt.Font;

public class MyFont {

    // private static Font roboto;
    private Font robotoBold;
    private static Font customFont;

    public MyFont() {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, MyFont.class.getResourceAsStream("Roboto-Thin.ttf"));
            customFont = font.deriveFont(Font.PLAIN, 100);
        } catch (Exception ex) {
            System.out.println("Error on creating font: " + ex);
        }

    }

    public Font roboto() {
        // roboto = new Font("consolas", Font.BOLD, 40);
        return customFont;
    }

    public static Font primaryFont() {
        return new Font("Roboto", Font.PLAIN, 18);
    }

    public static Font headerFont() {
        return new Font("Roboto", Font.BOLD, 35);
    }

    public static Font mediumFont() {
        return new Font("Roboto", Font.PLAIN, 21);
    }

    public static Font smallFont() {
        return new Font("Roboto", Font.PLAIN, 16);
    }

    public static Font bigFont() {
        return new Font("Roboto", Font.PLAIN, 40);
    }

    public static Font bigBigFont() {
        return new Font("Roboto", Font.PLAIN, 200);
    }

    public static Font tinyFont() {
        return new Font("Roboto", Font.PLAIN, 12);
    }

    public static Font montserrat() {
        return new Font("Montserrat", Font.PLAIN, 15);
    }

}