package src.NewMatrixLab;

import java.util.TreeMap;
import java.util.concurrent.Callable;

public class MultiplierRowColumn implements Callable<Integer> {

    private final int[] row;
    private final int[] column;

    public MultiplierRowColumn(int[] row, int[] column) {
        this.row = row;
        this.column = column;
    }


    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < row.length; i++) {
            result += row[i] * column[i];
        }
        return result;
    }
}
