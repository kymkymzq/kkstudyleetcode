package com.kk.backtrace;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 473. 火柴拼正方形 https://leetcode.cn/problems/matchsticks-to-square/
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，
 * 但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。如果你能使这个正方形，则返回 true ，否则返回 false 。
 *
 * 示例 1:
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 *
 * 示例 2:
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 *
 * 提示:
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 108
 */

class LeetCode473 {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum(); //流式写法求和
        if(totalLen % 4 != 0){
            return false;
        }
        Arrays.sort(matchsticks);
        for(int i = 0, j = matchsticks.length - 1; i < j; i++, j--){ //按从大大小排序, 这样在进行dfs时, 先判断大的可以提前终值不合理的枝
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] edges = new int[4];

        return dfs(matchsticks, edges, totalLen/4, 0);
    }
    //int[] matchsticks = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
    public boolean dfs(int[] matchsticks, int[] edges, int len, int index){
        if(index == matchsticks.length){ //说明所有的火柴都能摆进去, 则返回true
            return true;
        }

        for(int i = 0; i < edges.length; i++){
            edges[i] += matchsticks[index];//在每条边摆火柴
            if(edges[i] <= len && dfs(matchsticks, edges, len, index + 1)){ //如果这根火柴摆进去<=len,说明可以尝试edge[i]边上, 再进入dfs()后续判断
                return true;
            }
            edges[i] -= matchsticks[index]; //如果这根火柴摆进去>len了,说明这根不能摆在edge[i]边上, 需要回溯
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,45,2,2,4};
        OptionalInt max = Arrays.stream(nums).max(); //流式求数组中最大值
        System.out.println(max.getAsInt());
    }

}