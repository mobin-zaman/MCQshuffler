package components;

import java.awt.*;

public class MyFont {

    private Font primaryFont;
    private Font headerFont;
    private Font smallFont;

    public MyFont() {

        primaryFont = new Font("Roboto", Font.PLAIN, 18);
        headerFont = new Font("Roboto", Font.PLAIN, 25);
        smallFont = new Font("Roboto", Font.PLAIN, 14);
    }

    public Font getprimaryFont() {
        return this.primaryFont;
    }

    public Font getHeaderFont() {
        return this.headerFont;
    }

    public Font getSmallFont() {
        return this.smallFont;
    }

}