package cn.melman.melleet;

public class Q486 {

    public boolean PredictTheWinner(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (right < 2) {
            return true;
        }
        int sum1 = 0, sum2 = 0;
        boolean leftTurn = true;
        int temp = 0;

        return sum1 >= sum2;
    }

    public static void main(String[] args) {
        boolean res = new Q486().PredictTheWinner(new int[]{1, 2, 234, 5});
        System.out.println(res);
    }
}
