package com.kk.dp;

/**
 * 5. 最长回文子串 https://leetcode.cn/problems/longest-palindromic-substring/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */

class LeetCode5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        //没写dp[i][i] = true; 不写也没问题,也可以AC

        int maxLen = 1;
        int maxIndex = 0;

        for(int j = 1; j < len; j++){
            for(int i = 0; i < j; i++){
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if(j - i + 1 <= 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if(j - i + 1 > maxLen && dp[i][j]){
                    maxLen = j - i + 1;
                    maxIndex = i;
                }
            }
        }
        return s.substring(maxIndex, maxIndex + maxLen);
    }
}