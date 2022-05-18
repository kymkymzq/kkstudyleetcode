package com.kk.dichotomy;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */

class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        if(firstPosition == -1){
            return new int[]{-1, -1};
        }
        int lastPosition = findLastPosition(nums, target);
        
        return new int[]{firstPosition, lastPosition};

    }

    public int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right + 1) >>> 1; //这种取终值很经典,如果只有两个数字,这样求的结果可以让中值变成第二个数
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) >>> 1; //如果只有两个数字,这样求的结果是让中值变成第一个数
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target){
                right = mid;
            }else{
                right = mid - 1;
            }
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }
}