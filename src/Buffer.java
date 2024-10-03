package src;

public class Buffer implements Runnable{
    private static int []buffer;
    private static int size;
    private static int pointer;
    private final int interval;

    private static int countSec;

    private static final Object lock = new Object();

    public static Object getLock(){
        return lock;
    }

    Buffer(int size){
        this.size = size;
        buffer = new int[size];
        pointer = 0;
        this.interval = 1000;
        countSec = 0;
    }

    public static int getPointer(){
        return pointer;
    }

    public static int getSize(){
        return size;
    }

    public static void addVal(int val){
        pointer++;
        buffer[pointer] = val;
    }

    public static int removeVal(){
        if(pointer > 0){
            pointer--;
            return buffer[pointer+1];
        }
        return -1;
    }

    public static int getSecondsCounter() {
        return countSec;
    }

    public void run() {
        while(true){
            try {
                Thread.sleep(this.interval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock) {
                countSec++;
                lock.notifyAll();
            }
        }
    }
}
