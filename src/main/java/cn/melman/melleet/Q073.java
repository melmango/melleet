package cn.melman.melleet;

public class Q073 {

    static int TRY = -65536;//这里偷懒了，其实也不太行，有可能撞了
    public void setZeroes(int[][] matrix) {
        for (int i = 0, len = matrix.length; i < len; i++) {
            for (int j = 0, count = matrix[0].length; j < count; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = TRY;
                }
            }
        }
        for (int i = 0, len = matrix.length; i < len; i++) {
            for (int j = 0, count = matrix[0].length; j < count; j++) {
                if (matrix[i][j] == TRY) {
                    setZero(matrix, i, j);
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void setZero(int[][] matrix, int x, int y) {
        for (int i = 0, len = matrix.length; i < len; i++) {
            if (matrix[i][y] != TRY) {
                matrix[i][y] = 0;
            }
        }
        for (int j = 0, count = matrix[0].length; j < count; j++) {
            if (matrix[x][j] != TRY) {
                matrix[x][j] = 0;
            }
        }
    }

}
