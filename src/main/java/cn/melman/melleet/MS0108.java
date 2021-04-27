package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/14 9:32 AM
 */
public class MS0108 {


    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        int i, j;
        for (i = 0; i < row.length; i++) {
            for (j = 0; j < column.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for (i = 0; i < row.length; i++) {
            if (row[i]) {
                for (j = 0; j < column.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (j = 0; j < column.length; j++) {
            if (column[j]) {
                for (i = 0; i < row.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
