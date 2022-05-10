package com.kk.backtrace.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和 https://leetcode.cn/problems/combination-sum/
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和
 * 为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。candidates 中的
 * 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。对于给定的输入，
 * 保证和为 target 的不同组合数少于 150 个。
 *
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都 互不相同
 * 1 <= target <= 500
 */

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