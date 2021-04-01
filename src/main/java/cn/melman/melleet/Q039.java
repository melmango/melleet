package cn.melman.melleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q039 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
//        Arrays.sort(candidates);
        for (int i = 0, len = candidates.length; i < len; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            if (candidates[i] == target) {
                res.add(list);
                continue;
            }
            append(res, candidates[i], list, candidates, target, i);
        }
        return res;
    }

    private void append(List<List<Integer>> res, int tempValue, List<Integer> tempList, int[] candidates, int target, int index) {
        for (int j = index; j < candidates.length; j++) {
            if (candidates[j] + tempValue > target) {
                continue;
            }else if (candidates[j] + tempValue == target) {
                List<Integer> newTempList = new ArrayList<>();
                newTempList.addAll(tempList);
                newTempList.add(candidates[j]);
                res.add(newTempList);
            } else if (candidates[j] + tempValue < target) {
                List<Integer> newTempList = new ArrayList<>();
                newTempList.addAll(tempList);
                newTempList.add(candidates[j]);
                append(res, tempValue + candidates[j], newTempList, candidates, target, j);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Q039().combinationSum(new int[]{1}, 2);
        System.out.println(lists);
    }

}
