package src.NewMatrixLab;

import java.util.concurrent.*;

public class MultiplierMatrix {

    private final Matrix firstMatrix;
    private final Matrix secondMatrix;

    private final int sizeFixedTreadPool;

    public MultiplierMatrix(Matrix firstMat, Matrix secondMat, int sizePool){
        this.firstMatrix = firstMat;
        this.secondMatrix = secondMat;
        this.sizeFixedTreadPool = sizePool;
    }

    public int[][] multiply() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(this.sizeFixedTreadPool);

        Future<Integer> [][] f = new Future[secondMatrix.getRowSize()][secondMatrix.getColumnSize()];

        for(int i=0;i<firstMatrix.getRowSize();i++){
            for(int j=0;j<secondMatrix.getColumnSize();j++){
                Callable<Integer> callable = new MultiplierRowColumn(firstMatrix.getRow(i), secondMatrix.getColumn(j));
                f[i][j] = executor.submit(callable);
            }
        }

        int [][] ans = new int[secondMatrix.getRowSize()][secondMatrix.getColumnSize()];
        for(int i=0;i<firstMatrix.getRowSize();i++){
            for(int j=0;j<secondMatrix.getColumnSize();j++){
                ans[i][j] = f[i][j].get();
            }
        }

        executor.shutdown();
        return ans;
    }

}

