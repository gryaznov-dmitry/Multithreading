package src.NewMatrixLab;

public class Matrix {

    private final int[][] matrix;

    public Matrix(int[][] mat) {
        this.matrix = mat;
    }

    public int getRowSize(){
        return matrix.length;
    }

    public int getColumnSize(){
        return matrix[0].length;
    }

    public int[] getRow(int index) {
        return matrix[index];
    }

    public int[] getColumn(int index) {
        int[] column = new int[matrix.length];
        for (int i = 0; i<matrix.length;i++) {
            column[i] = matrix[i][index];
        }
        return column;
    }
}
