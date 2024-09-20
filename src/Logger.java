package src;

public class Logger implements Runnable{
    private int interval;
    Logger(int interval){
        this.interval = interval;
    }

    public void run(){
        while (true)
        {
            synchronized (Timer.getLock()) {
                try {
                    Timer.getLock().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (Timer.getSecondsCounter()*1000 % interval == 0) {
                    System.out.println(Thread.currentThread().getName() + ": Прошло "+ Timer.getSecondsCounter() +" секунд!");
                }
            }
        }
    }
}
