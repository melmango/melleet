package cn.melman.melleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Melman
 * @date 2021/4/25 9:40 AM
 */
public class Q040 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (candidates[i] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                res.add(list);
                continue;
            } else if (candidates[i] < target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, list);
            }
        }
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> temp) {
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (candidates[i] == target) {
                List<Integer> list = new ArrayList<>();
                list.addAll(temp);
                list.add(candidates[i]);
                res.add(list);
                continue;
            } else if (candidates[i] < target) {
                List<Integer> list = new ArrayList<>();
                list.addAll(temp);
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, list);
            }
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> res = new Q040().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        List<List<Integer>> res = new Q040().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        System.out.println(res);
    }
}
