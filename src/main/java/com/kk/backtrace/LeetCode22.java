package com.kk.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成 https://leetcode.cn/problems/generate-parentheses/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：
 *
 * 1 <= n <= 8
 */

class LeetCode22 {
    public static List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        int leftCount = 0;
        int rightCount = 0;

        dfs(temp, res, n, 0, leftCount, rightCount);
        return res;
    }

    /**
    本题中: int n 作为dfs退出的判定条件
    之前刷的题把index放在最后了,以后dfs可以这么定义,这样可以更加规范:
    dfs(temp, res, 输入参数(int n), index/begin)  {}
    dfs(temp, res, 输入参数(int n), index/begin, 辅助参数)  {}  辅助参数(非必须)
     */

    public static void dfs(StringBuilder temp, List<String> res, int n, int index, int leftCount, int rightCount){
        if(index == 2 * n){
            res.add(temp.toString());
        }
        /**
        正常的回溯套路是,在这个位置会遍历该层整个范围的数字,即树的兄弟结点。使用for()循环,
        i要么从0开始     : 如全排列(46, 47)
        i要么从begin开始 : 如求子集(78, 90), 求和的组合等(39, 40)
         */
        
        /**
        而本题中,每一层的范围相当于已经确定了,只有'('和 ')'，因此在此处不用for()循环,直接依次写出也是可以的
        2022/05/11 13:51提交的用了for循环的写法
        */
        if(leftCount < n){
            temp.append('(');
            dfs(temp, res, n, index + 1, leftCount + 1, rightCount);
            temp.deleteCharAt(temp.length() - 1);
        }

        if(rightCount < leftCount){
            temp.append(')');
            dfs(temp, res, n, index + 1, leftCount, rightCount+ 1);
            temp.deleteCharAt(temp.length() - 1);
        }

    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
        /*
        [((())), (()()), (())(), ()(()), ()()()]
         */
    }

}