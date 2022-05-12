package com.kk.dp;

/**
 * 55. 跳跃游戏 https://leetcode.cn/problems/jump-game/
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */

class LeetCode55 {
    /**
     * dp方法,很慢, O(n^2)
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){  //遍历i之前的每一个位置j,判断j位置处是否可以到达i 可以的话就break
                if(dp[j] && nums[j] + j >= i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
    /**
     * 贪心方法, O(n)
     * @param nums
     * @return
     */

    public boolean canJump2(int[] nums) {

        int rightMostBoundary = 0; //能到达的最右侧边界

        for(int i = 0; i < nums.length; i++){

            if(i <= rightMostBoundary){  //这个判断很重要,控制了i必须在可以到达rightMostBoundary的范围内才有效
                rightMostBoundary = Math.max(rightMostBoundary, i + nums[i]);
                if(rightMostBoundary >= nums.length - 1){
                    return true;
                }
            }
        }
        return false;
    }
}