package gui.utilities;

import java.util.Scanner;
import javax.swing.JLabel;
import java.util.Timer;
import java.util.TimerTask;

public class CountDown {
    static int interval;
    static Timer timer;

    public static int staticSecond;

    public CountDown(int seconds) {
        System.out.println("Input seconds => : " + seconds);

        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = (seconds);
        System.out.println(seconds);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval());
                staticSecond = setInterval();
                // jLabel.setText(Integer.toString(setInterval()));
            }
        }, delay, period);

    }

    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }
}