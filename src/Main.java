package src;

import org.w3c.dom.ls.LSOutput;
import src.MatrixMultiplier.BaseMultiplier;
import src.MatrixMultiplier.Multiplier;
import src.NewMatrixLab.Matrix;
import src.NewMatrixLab.MultiplierMatrix;

import javax.swing.plaf.metal.MetalPopupMenuSeparatorUI;
import java.sql.SQLOutput;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

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

    public static void showTask4() {
        Scanner scanner = new Scanner(System.in);

        int size;
        int prodInterval;
        int conInterval;

        System.out.print("Введите размер буфера: ");
        size = scanner.nextInt();

        System.out.print("Введите интервал производителя: ");
        prodInterval = scanner.nextInt()*1000;

        System.out.print("Введите интервал потребителя: ");
        conInterval = scanner.nextInt()*1000;



    }

    public static Matrix inputMatrix(final Scanner scanner) {
        System.out.print("Введите количество строк матрицы:");
        final var rows = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы:");
        final var cols = scanner.nextInt();
        final var matrixA = new int[rows][cols];
        System.out.print("Введите матрицу:");
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }
        return new Matrix(matrixA);
    }

    public static Matrix genMatrix(final Scanner scanner) {
        System.out.print("Введите количество строк матрицы:");
        final var rows = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы:");
        final var cols = scanner.nextInt();
        final var matrixA = new int[rows][cols];
        Random random = new Random();
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                matrixA[i][j] = random.nextInt(-10, 10);
            }
        }
        return new Matrix(matrixA);
    }

    public static void showMatrixTask() throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Matrix a = new Matrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Matrix b = new Matrix(new int[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        });

        a = genMatrix(scanner);
        b = genMatrix(scanner);
        if(a.getColumnSize() != b.getRowSize()){
            System.out.println("Матрицы не приведенные");
            return;
        }

        MultiplierMatrix multiplier = new MultiplierMatrix(a, b, 4);
        long startTime = System.currentTimeMillis();
        int[][] ans = multiplier.multiply();
        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения: " + (endTime - startTime) + "мс");
        System.out.println("Результат: ");
        for (int[] row : ans) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       // showTask1and2();
       // showTask3();
       // showTask4();

        showMatrixTask();
    }
}
