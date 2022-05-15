package com.kk.dp;

/**
 * 413. 等差数列划分 https://leetcode.cn/problems/arithmetic-slices/
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 */

class LeetCode413 {
    /**
     * DP
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices1(int[] nums) {
        int len = nums.length;
        if(len < 3){
            return 0;
        }
        int res = 0;

        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i < nums.length; i++){  //c从第二项开始才有可能构成等差数列
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                dp[i] = 1 + dp[i - 1];
                // 如果符合if()条件,每一个dp[i]都是上一个dp[i - 1] + 1:因为dp[i - 1]的所有都符合,还会多出一个新的(与dp[i]新构成的)
                res += dp[i];
            }
        }
        return res;

    }


    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices2(int[] nums) {
        int len = nums.length;
        if(len < 3){
            return 0;
        }
        int res = 0;
        for(int i = len - 2; i >= 1; i--){   //i 的 index 从 len - 2 到 1

            int d = nums[i] - nums[i + 1];

            for(int j = i - 1; j >= 0; j--){ //j 的 index 从 i - 1 到 0
                if(nums[j] - nums[j + 1] == d){
                    res++;
                }else{
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int i = numberOfArithmeticSlices1(nums);
        System.out.println(i);


    }
}