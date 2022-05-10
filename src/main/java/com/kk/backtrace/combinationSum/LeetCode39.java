package com.kk.backtrace.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetCode39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        int sum = 0;
        dfs(temp, res, candidates, target, sum, 0);
        return res;

    }

    public static void dfs(List<Integer> temp, List<List<Integer>> res, int[] candidates, int target, int sum, int begin){
        if(sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = begin; i < candidates.length; i++){
            int tempSum = sum + candidates[i];
            if(tempSum <= target){
                temp.add(candidates[i]);
                dfs(temp, res, candidates, target, tempSum, i); //注意这里还是i，因为每一个数字可以用无数次
                temp.remove(temp.size() - 1);
            }else{
                break; // 如果这里用break剪枝，那么前面必须排序。   不剪枝则相当于遍历，前面可以不排序
            }

        }

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> lists = combinationSum(nums, 7);
        System.out.println(lists);
        /*
        [[2, 2, 3], [7]]
         */
    }

}