package com.kk.backtrace.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetCode40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        int begin = 0;
        dfs(temp, res, candidates, target, sum, begin);
        return res;

    }

    public static void dfs(List<Integer> temp, List<List<Integer>> res, int[] candidates, int target, int sum, int begin){
        if(sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = begin; i < candidates.length; i++){
            if(i > begin && candidates[i] == candidates[i - 1]){
                continue;
            }

            int tempSum = sum + candidates[i];
            if(tempSum <= target){
                temp.add(candidates[i]);
                dfs(temp, res, candidates, target, tempSum, i + 1);//注意这里i + 1,与39题不同,因为每一个数字只能用一次
                temp.remove(temp.size() - 1);
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = combinationSum2(nums, 8);
        System.out.println(lists);
        /*
        [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
         */

    }

}