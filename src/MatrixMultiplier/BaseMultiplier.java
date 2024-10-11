package src.MatrixMultiplier;

import src.Timer;

public class BaseMultiplier implements Runnable{

    private final int step;
    private final int start;

    public BaseMultiplier(int start, int step)
    {
        this.step = step;
        this.start = start;
    }
    public void run() {

        int rowSize = MultiplierNew.getSizeRow();
        int columnSize = MultiplierNew.getSizeColumn();
        int sum = 0;

        for(int i = step; i < rowSize; i+=step){
            for(int j = 0; j < columnSize; j++){

                int []row = MultiplierNew.getRow(i);
                int []column = MultiplierNew.getColumn(j);

                for(int k=0;k<row.length;k++){
                    sum += row[k] * column[k];
                }

                MultiplierNew.setElementProductMatrix(sum, i, j);
            }
        }
    }
}

