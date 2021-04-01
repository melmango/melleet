package cn.melman.melleet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author Melman
 * @date 2021/3/28 2:56 PM
 */
public class Q149 {

//            0 = {Integer@616} 1
//            1 = {Integer@617} 34
//            2 = {Integer@618} 36
//            3 = {Integer@619} 21
//            4 = {Integer@620} 25
//            5 = {Integer@621} 46
//            6 = {Integer@622} 62

    /**
     * 思考：在一条直线上，就是y=ax+b，x = (y-b)/a;
     * 第一个坑：-0.0f
     * 第二个坑：去掉重复的点
     * 第三个坑：在一个横线或者竖线上，用Integer.MAX_VALUE暂时补上了
     *
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) throws Exception {
        if (points.length <= 2) {
            return points.length;
        }
        int max = 2;
//        HashSet<Integer> maxSet = null;
//        String maxKey = null;
        HashMap<String, HashSet<Integer>> hash = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double[] param = calcLine(points[i], points[j]);
                String key = String.format("%.10f-%.10f", param[0], param[1]);
//                System.out.println(String.format("[%d,%d],%f-%f", i, j, param[0] + 0.0f, param[1]));
                HashSet<Integer> set = hash.get(key);
                if (set == null) {
                    set = new HashSet<>();
                    set.add(i);
                    set.add(j);
                    hash.put(key, set);
                } else {
                    set.add(i);
                    set.add(j);
                    if (set.size() > max) {
                        max = set.size();
//                        maxSet = set;
//                        maxKey = key;
                    }
                }
            }
        }
        return max;
    }

    private double[] calcLine(int[] left, int[] right) {
        double[] param = new double[2];
        if (left[0] == right[0]) {
            param[0] = left[0];
            param[1] = Integer.MAX_VALUE;
        } else if (left[1] == right[1]) {
            param[0] = 0;
            param[1] = left[1];
        } else {
            param[0] = (double) (left[1] - right[1]) / (left[0] - right[0]);
            param[1] = (double) left[1] - param[0] * left[0];
        }
        return param;
    }

    public static void main(String[] args) throws Exception {
        int res = new Q149().maxPoints(new int[][]{{7, 3}, {19, 19}, {-16, 3}, {13, 17}, {-18, 1}, {-18, -17}, {13, -3}, {3, 7}, {-11, 12}, {7, 19}, {19, -12}, {20, -18}, {-16, -15}, {-10, -15}, {-16, -18}, {-14, -1}, {18, 10}, {-13, 8}, {7, -5}, {-4, -9}, {-11, 2}, {-9, -9}, {-5, -16}, {10, 14}, {-3, 4}, {1, -20}, {2, 16}, {0, 14}, {-14, 5}, {15, -11}, {3, 11}, {11, -10}, {-1, -7}, {16, 7}, {1, -11}, {-8, -3}, {1, -6}, {19, 7}, {3, 6}, {-1, -2}, {7, -3}, {-6, -8}, {7, 1}, {-15, 12}, {-17, 9}, {19, -9}, {1, 0}, {9, -10}, {6, 20}, {-12, -4}, {-16, -17}, {14, 3}, {0, -1}, {-18, 9}, {-15, 15}, {-3, -15}, {-5, 20}, {15, -14}, {9, -17}, {10, -14}, {-7, -11}, {14, 9}, {1, -1}, {15, 12}, {-5, -1}, {-17, -5}, {15, -2}, {-12, 11}, {19, -18}, {8, 7}, {-5, -3}, {-17, -1}, {-18, 13}, {15, -3}, {4, 18}, {-14, -15}, {15, 8}, {-18, -12}, {-15, 19}, {-9, 16}, {-9, 14}, {-12, -14}, {-2, -20}, {-3, -13}, {10, -7}, {-2, -10}, {9, 10}, {-1, 7}, {-17, -6}, {-15, 20}, {5, -17}, {6, -6}, {-11, -8}});
        System.out.println(res);
//        new Q149().calcLine(new int[]{19,19},new int[]{-9,-9});
    }

}
