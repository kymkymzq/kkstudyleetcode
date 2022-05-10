package com.kk.backtrace.permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */

class LeetCode47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(nums); //有重复数字的数组 一定要排序！！！！！！

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(temp, res, nums, 0, visited);

        return res;
    }
    
    public static void dfs(List<Integer> temp, List<List<Integer>> res, int[] nums, int index, boolean[] visited){
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1])){
                continue;
            }

            visited[i] = true;
            temp.add(nums[i]);
            dfs(temp, res, nums, index + 1, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
        /*
        [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
         */
    }
}