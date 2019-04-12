package gui.components;

import java.awt.*;
import java.lang.*;

public class MyFont {

    private Font primaryFont;
    private Font headerFont;
    private Font smallFont;
    private Font mediumFont;
    private Font bigFont;
    private Font bigBigFont;
    private Font tinyFont;

    public MyFont() {

        primaryFont = new Font("Roboto", Font.PLAIN, 18);
        mediumFont = new Font("Roboto", Font.PLAIN, 21);
        headerFont = new Font("Roboto", Font.PLAIN, 25);
        smallFont = new Font("Roboto", Font.PLAIN, 16);
        tinyFont = new Font("Roboto", Font.PLAIN, 10);
        bigFont = new Font("Roboto", Font.PLAIN, 40);
        bigBigFont = new Font("Roboto", Font.PLAIN, 200);
    }

    public Font getprimaryFont() {
        return this.primaryFont;
    }

    public Font getHeaderFont() {
        return this.headerFont;
    }

    public Font getMediumFont() {
        return this.mediumFont;
    }

    public Font getSmallFont() {
        return this.smallFont;
    }

    public Font getBigFont() {
        return this.bigFont;
    }

    public Font getBigBigFont() {
        return this.bigBigFont;
    }

    public Font getTinyFont() {
        return this.tinyFont;
    }

}