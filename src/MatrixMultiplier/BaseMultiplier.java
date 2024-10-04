package src.MatrixMultiplier;

import src.Timer;

public class BaseMultiplier implements Runnable{
    public void run(){
        while (true)
        {
            synchronized (Multiplier.getLock()) {
                try {
                    Multiplier.getLock().wait();

                    int rowPointer = Multiplier.getPointerRow();
                    int columnPointer = Multiplier.getPointerColumn();

                    System.out.println(Thread.currentThread().getName() + " " + rowPointer + " " + columnPointer);

                    int sum = 0;
                    int []row = Multiplier.getRow(rowPointer);
                    int []column = Multiplier.getColumn(columnPointer);

                    for(int i=0;i<row.length;i++)
                    {
                        sum += row[i]*column[i];
                    }
                    Multiplier.setElementProductMatrix(sum, rowPointer, columnPointer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

