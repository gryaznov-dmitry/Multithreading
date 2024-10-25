package src.MatrixMultiplier;

public class Multiplier {
    private static int[][] firstMatrix;

    private static int[][] secondMatrix;

    private static int[][] secondMatrixT;

    private static int[][] productMatrix;


    public Multiplier(int[][] matrix1, int[][] matrix2){
        firstMatrix = matrix1;
        secondMatrix = matrix2;
        productMatrix = new int[matrix1.length][matrix2[0].length];
        secondMatrixT = new int[matrix2[0].length][matrix2.length];

        for(int i = 0; i < secondMatrix[0].length; i++) {
            for(int j = 0; j < secondMatrix.length; j++){
                secondMatrixT[i][j] = secondMatrix[j][i];
            }
        }
    }

    public static int getSizeRow(){
        return firstMatrix.length;
    }

    public static int getSizeColumn(){
        return secondMatrixT.length;
    }

    public static int[] getRow(int ind){
        return firstMatrix[ind];
    }

    public static int[] getColumn(int ind){
        return secondMatrixT[ind];
    }

    public static void setElementProductMatrix(int val, int indRow, int indColumn){
        productMatrix[indRow][indColumn] = val;
    }

    public void showMatrix(){
        for(int i=0;i<productMatrix.length;i++){
            for(int j=0;j<productMatrix[0].length;j++){
                System.out.print(productMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void multiply(int numProc)
    {
        Thread []threads = new Thread[numProc];
        for(int i = 0; i < numProc; i++) {
            threads[i] = new Thread(new BaseMultiplier(i, numProc));
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                if(t != null)
                    t.join();
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }

}