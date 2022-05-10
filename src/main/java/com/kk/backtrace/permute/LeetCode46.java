package com.kk.backtrace.permute;

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

class LeetCode46 {
    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(temp, res, nums, 0, visited);
        return res;

    }

//    public static void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> res, boolean[] visited){
    public static void dfs(List<Integer> temp, List<List<Integer>> res, int[] nums, int index, boolean[] visited){
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){ //全排列需要每次都从0开始,因为即使从后面的数开始,也会选到前面的排列,所以利用visit[i]做判断是否访问过。
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            temp.add(nums[i]);
            dfs(temp, res, nums, index + 1, visited);//index + 1 :因为每次取完一个数，下一次dfs是从下一个数开始取
            visited[i] = false;
            temp.remove(temp.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
        /*
        [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
         */
    }

}