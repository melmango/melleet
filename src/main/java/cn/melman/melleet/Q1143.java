package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/5 1:47 PM
 */
public class Q1143 {

    /**
     * 动态规划，二位数组！极其重要！！！
     * 解题思路
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

}
