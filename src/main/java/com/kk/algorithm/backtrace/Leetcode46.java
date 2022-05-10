package com.kk.algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列  https://leetcode.cn/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */

class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(nums, 0, temp, res, visited);
        return res;

    }

    public void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> res, boolean[] visited){
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            temp.add(nums[i]);
            dfs(nums, index + 1, temp, res, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);

        }

    }

}