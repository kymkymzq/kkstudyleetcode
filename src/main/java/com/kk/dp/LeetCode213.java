package com.kk.dp;

import java.util.Arrays;

class LeetCode213 {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length); 
        // Arrays.copyOfRange 比利用循环复制数组效率要高得多。这个方法要记住~很有用很方便
        // 下层调用了System.arraycopy方法,可以点进去看看,是native method,所以效率高

        int res = Math.max(rob198(nums1), rob198(nums2));

        return res;

    }

    public int rob198(int[] nums) { //同198题

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        }

        return dp[nums.length - 1];
    }

}