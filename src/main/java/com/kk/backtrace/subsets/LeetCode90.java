package com.kk.backtrace.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetCode90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(nums); //有重复数字的要提前排序!!!!!!!!!!!!!!
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(nums, 0, temp, res);
        
        return res;
    }

    public static void dfs(int[] nums, int begin, List<Integer> temp, List<List<Integer>> res){
        
        res.add(new ArrayList<>(temp)); // 因为求子集没有固定的大小，所以只能隐式的添加

        for(int i = begin; i < nums.length; i++){
            if(i > begin && nums[i] == nums[i - 1]){
                continue;
            }

            temp.add(nums[i]);
            dfs(nums, i + 1, temp, res);  //i + 1   不是 begin + 1!!!!!!!!!
            temp.remove(temp.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        System.out.println(lists);
        /*
        [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
         */
    }

}