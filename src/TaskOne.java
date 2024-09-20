package src;

public class TaskOne extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i%10==0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
