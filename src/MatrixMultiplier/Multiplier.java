package src.MatrixMultiplier;

public class Multiplier implements Runnable {

    private static int[][] firstMatrix;
    private static int[][] secondMatrix;
    private static int[][] secondMatrixT;
    private static int[][] productMatrix;
    private static int pointerRow, pointerColumn;
    private static final Object lock = new Object();

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

        pointerRow = 0;
        pointerColumn = 0;
    }
    public static Object getLock(){
        return lock;
    }

    public static int getPointerColumn() {
        return pointerColumn;
    }

    public static int getPointerRow() {
        return pointerRow;
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
    public int[][] multiply() {
        run();
        return productMatrix;
    }

    @Override
    public void run() {
        while(true){
            try {
                synchronized (lock) {
                    lock.notifyAll();
                    Thread.sleep(1000);
                    System.out.println(pointerRow + " " + pointerColumn);
                    pointerColumn = (pointerColumn + 1) % secondMatrix[0].length;

                    if (pointerColumn == 0)
                        pointerRow = (pointerRow + 1);

                    if(pointerRow == firstMatrix.length){
                        for (int[] matrix : productMatrix) {
                            for (int j = 0; j < productMatrix[0].length; j++) {
                                System.out.print(matrix[j] + " ");
                            }
                            System.out.println();
                        }
                        break;
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
