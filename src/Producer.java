package src;
import java.util.Random;
public class Producer implements Runnable{
    private int interval;

    Producer(int interval) {
        this.interval = interval;
    }

    public void run(){
        while (true) {
            synchronized (Buffer.getLock()) {
                try {
                    Buffer.getLock().wait();
                    if (Buffer.getSecondsCounter()*1000 % interval == 0){
                        if (Buffer.getPointer() + 1 < Buffer.getSize()) {
                            Random rnd = new Random();
                            int newVal = rnd.nextInt(1, 100);
                            Buffer.addVal(newVal);
                            System.out.println(Thread.currentThread().getName() +": Добавлено значение " + newVal);
                        }
                        else System.out.println(Thread.currentThread().getName() +": Буфер переполнен");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
