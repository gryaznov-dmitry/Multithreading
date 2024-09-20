package src;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void showTask1and2(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите левую границу: ");
        int left = scanner.nextInt();
        System.out.print("Введите правую границу: ");
        int right = scanner.nextInt();
        System.out.print("Введите делитель: ");
        int div = scanner.nextInt();
        if (div == 0) {
            System.out.println("Делитель не должен быть равен 0!");
            return;
        }

        Thread taskOne = new TaskOne(left, right, div);

        System.out.print("Введите левую границу: ");
        left = scanner.nextInt();
        System.out.print("Введите правую границу: ");
        right = scanner.nextInt();
        System.out.print("Введите делитель: ");
        div = scanner.nextInt();

        if (div == 0) {
            System.out.println("Делитель не должен быть равен 0!");
            return;
        }

        Thread taskTwo = new Thread(new TaskTwo(left, right, div));

        taskOne.start();
        taskTwo.start();
}

    public static void showTask3(){
        Scanner scanner = new Scanner(System.in);

        int size;
        int baseTimerInterval;

        System.out.print("Введите интервал основного таймера: ");
        baseTimerInterval = scanner.nextInt()*1000;

        System.out.print("Введите количество дополнительных таймеров: ");
        size = scanner.nextInt();

        int []logInterval = new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Введите интервал для таймера" + i + ": ");
            logInterval[i] = scanner.nextInt()*1000;
        }
        MultiTimer multiTimer = new MultiTimer(baseTimerInterval, logInterval);
        System.out.println("Start");
        multiTimer.start();
    }
    public static void main(String[] args){
       // showTask1and2();
        showTask3();
    }
}
