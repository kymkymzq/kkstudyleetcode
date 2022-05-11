package com.kk.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合 https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */

class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        Map<Character, String> hashmap = new HashMap<>();
        hashmap.put('2', "abc");
        hashmap.put('3', "def");
        hashmap.put('4', "ghi");
        hashmap.put('5', "jkl");
        hashmap.put('6', "mno");
        hashmap.put('7', "pqrs");
        hashmap.put('8', "tuv");
        hashmap.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        dfs(temp, res, digits, hashmap, 0);

        return res;

    }

    public void dfs(StringBuilder temp, List<String> res, String digits, Map<Character, String> hashmap, int index){
        if(index == digits.length()){
            res.add(temp.toString());
            return;
        }
        char curChar = digits.charAt(index);
        String curString = hashmap.get(curChar);
        for(int i = 0; i < curString.length(); i++){  //树的每一层是从curChar对应的curString中选
            temp.append(curString.charAt(i));
            dfs(temp, res, digits, hashmap, index + 1);
            temp.deleteCharAt(temp.length() - 1);
        }

    }

}