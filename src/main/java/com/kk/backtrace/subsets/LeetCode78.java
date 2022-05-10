package com.kk.backtrace.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */

class LeetCode78 {
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        // Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> stack = new ArrayList<>();

        dfs(stack, res, nums, 0);
        return res;

    }

    public static void dfs(List<Integer> temp, List<List<Integer>> res, int[] nums, int begin){
        res.add(new ArrayList<>(temp));

        for(int i = begin; i < nums.length; i++){
            temp.add(nums[i]);
            dfs(temp, res, nums, i + 1);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
        /*
        [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
         */

    }


}