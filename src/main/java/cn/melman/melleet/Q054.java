package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

public class Q054 {

    public static final int RIGHT = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;

    //速度击败100%，内存击败98%
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        if (matrix[0].length == 0) {
            return res;
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                res.add(matrix[i][0]);
            }
            return res;
        }
        int x = 0, y = 0, left = 0, top = 1, bottom = matrix.length, right = matrix[0].length;
        int direction = RIGHT;
        while (true) {
            if (x < 0 || y < 0) {
                break;
            }
            res.add(matrix[x][y]);
            if (direction == RIGHT) {
                y++;
                if (y == right - 1) {
                    direction = DOWN;
                    right--;
                } else if (y == right) {
                    break;
                }

            } else if (direction == DOWN) {
                x++;
                if (x == bottom - 1) {
                    direction = LEFT;
                    bottom--;
                } else if (x == bottom) {
                    break;
                }

            } else if (direction == LEFT) {
                y--;
                if (y == left) {
                    direction = UP;
                    left++;
                } else if (y < left) {
                    break;
                }

            } else if (direction == UP) {
                x--;
                if (x == top) {
                    direction = RIGHT;
                    top++;
                } else if (x < top) {
                    break;
                }
            }

        }
        return res;
    }

    public static final void main(String[] args) {
//        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        int[][] arr = new int[][]{{1, 2, 3, 4}};
//        int[][] arr = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] arr = new int[][]{{1, 2}, {3, 4}};
        System.out.println(new Q054().spiralOrder(arr));
    }
}
