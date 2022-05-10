package com.kk.backtrace.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II https://leetcode.cn/problems/combination-sum-ii/
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */

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