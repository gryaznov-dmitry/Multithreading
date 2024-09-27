package src;
import java.util.Random;
public class Consumer implements Runnable{
    private int interval;
    Consumer(int interval) {
        this.interval = interval;
    }

    public void run(){
        while (true) {
            synchronized (Buffer.getLock()) {
                try {
                    Buffer.getLock().wait();
                    if (Buffer.getSecondsCounter()*1000 % interval == 0){
                        if(Buffer.getPointer() > 0){
                            int remVal = Buffer.removeVal();
                            if(remVal != -1)
                                System.out.println(Thread.currentThread().getName() +": Удалено значение " + remVal);
                        }
                        else System.out.println(Thread.currentThread().getName() +": Буфер пуст");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
