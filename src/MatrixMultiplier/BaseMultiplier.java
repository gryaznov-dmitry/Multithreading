package src.MatrixMultiplier;

public class BaseMultiplier implements Runnable{

    private final int step;
    private final int start;

    public BaseMultiplier(int start, int step)
    {
        this.step = step;
        this.start = start;
    }

    @Override
    public void run() {

        int rowSize = Multiplier.getSizeRow();
        int columnSize = Multiplier.getSizeColumn();

        for(int i = start; i < rowSize * columnSize; i+=step){

            int []row = Multiplier.getRow(i / columnSize);
            int []col = Multiplier.getColumn(i % columnSize);

            int sum = 0;
            for(int j = 0; j < row.length; j++) {
                sum += row[j]*col[j];
            }

//            System.out.println(Thread.currentThread().getName() + ": row=" + (i / columnSize) + ", col=" + (i % columnSize));
//
            Multiplier.setElementProductMatrix(sum, i/columnSize, i % columnSize);
        }
    }
}

