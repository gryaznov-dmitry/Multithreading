package src;

public class MultiTimer {
    private static int interval;
    private static int[] loggersInter;

    MultiTimer(int interval, int[] loggersInter){
        this.interval = interval;
        this.loggersInter = loggersInter;
    }

    void start(){
        Timer timer = new Timer(interval);
        Thread timerThread = new Thread(timer);
        timerThread.start();
        for (int logInter : loggersInter) {
            Logger logger = new Logger(logInter);
            Thread thread = new Thread(logger);
            thread.start();
        }
    }

}
