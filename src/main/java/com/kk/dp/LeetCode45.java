package com.kk.dp;

/**
 * 45. 跳跃游戏 II https://leetcode.cn/problems/jump-game-ii/
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 */
class LeetCode45 {
    /**
     * dp方法,很慢, O(n^2)
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {

        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] + j >= i){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
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
    public int jump2(int[] nums) {

        int rightMostBoundary = 0;
        int res = 0;
        int end = 0; //记录每次应该跳跃的位置(到了这个位置就要跳跃了,res++)

        //在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，
        //否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，
        //因此我们不必访问最后一个元素。
        for(int i = 0; i < nums.length - 1; i++){//
            rightMostBoundary = Math.max(rightMostBoundary, i + nums[i]);
            if(i == end){ //每次到了这个位置,就说明已经遍历完上一步能到达的所有范围了,这个时候rightMostBoundary也已经更新完成
                res++;
                end = rightMostBoundary;//把这一步中遍历的下一步能到的最大位置作为边界赋给end
            }
            //因为本题默认一定能到达最后,所以每次跳跃一定可以跳出上一次的rightMostBoundary
        }

        return res;

    }
}