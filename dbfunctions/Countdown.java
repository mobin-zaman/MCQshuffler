import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
    static int interval;
    static Timer timer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String secs = sc.nextLine();

        timer = new Timer();
        interval = Integer.parseInt(secs);
        System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval());

            }
        }, 1000, 1000);
    }

    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }

}