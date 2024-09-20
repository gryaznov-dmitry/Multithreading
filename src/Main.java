package src;

public class Main {
    public static void showTask1and2(){
        Thread taskOne = new TaskOne();
        taskOne.start();
        Thread taskTwo = new Thread(new TaskTwo());
        taskTwo.start();
    }

    public static void showTask3(){
        MultiTimer multiTimer = new MultiTimer(1000, new int [] {1000, 5000, 7000});
        multiTimer.start();
    }
    public static void main(String[] args){
        showTask3();
    }
}
