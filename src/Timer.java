package src;

public class Timer implements Runnable{

    private final int interval;
    private static final Object lock = new Object();
    private static int secondsCounter = 0;
    Timer(int interval) {
        this.interval = interval;
    }

    public static int getSecondsCounter() {
        return secondsCounter;
    }

    public static Object getLock(){
        return lock;
    }

    public void run() {
        while(true){
            try {
                Thread.sleep(this.interval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock) {
                secondsCounter++;
                lock.notifyAll();
                System.out.println();
            }
        }
    }
}
