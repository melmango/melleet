package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/9 3:52 PM
 */
public class Q1605 {

    /**
     * 想的高分，就得在输入上改，不能自己去创建变量，输入啥改啥
     * 然后能不算就不算
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        int c;
        for (int r = 0; r < rowSum.length; r++) {
            for (c = 0; c < colSum.length; c++) {
                if (rowSum[r] > 0) {
                    if (colSum[c] > 0) {
                        res[r][c] = Math.min(rowSum[r], colSum[c]);
                        if (res[r][c] > 0) {
                            rowSum[r] = rowSum[r] - res[r][c];
                            colSum[c] = colSum[c] - res[r][c];
                        }
                    }
                }
            }
        }
        return res;
    }

    //    private int rowLeft(int[][] res, int total, int rowNum) {
//        for (int i = 0; i < res[rowNum].length; i++) {
//            total = total - res[rowNum][i];
//        }
//        return total;
//    }
//
//    private int columnLeft(int[][] res, int total, int columnNum) {
//        for (int i = 0; i < res.length; i++) {
//            total = total - res[i][columnNum];
//        }
//        return total;
//    }


    public static void main(String[] args) {
//        int[][] res = new Q1605().restoreMatrix(new int[]{3, 8}, new int[]{4, 7});
//        int[][] res = new Q1605().restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8});
        int[][] res = new Q1605().restoreMatrix(new int[]{14, 9}, new int[]{6, 9, 8});
//        int[][] res = new Q1605().restoreMatrix(new int[]{0}, new int[]{0});
        System.out.println(res);
    }

}
