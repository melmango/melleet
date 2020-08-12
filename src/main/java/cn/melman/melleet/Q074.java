package cn.melman.melleet;

public class Q074 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int i = 0;
        for (int len = matrix.length; i < len; i++) {
            if (matrix[i][0] > target) {
                break;
            }
        }
        if (i > 0) {
            i = i - 1;
        } else {
            i = 0;
        }
        if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
            for (int j = 0, len = matrix[i].length; j < len; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        boolean res = new Q074().searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,50}}, 3);
        boolean res = new Q074().searchMatrix(new int[][]{{3}}, 3);
        System.out.println(res);
    }
}
