package src;

public class TaskOne extends Thread {

    private static int left, right, div;
    TaskOne(int left, int right, int div){
        this.left = left;
        this.right = right;
        this.div = div;
    }
    @Override
    public void run() {
        for (int i = left; i <= right; i++) {
            if (i%div==0) {
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
