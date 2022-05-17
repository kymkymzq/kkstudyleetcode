package com.onequestionperday;

/**
 * 953. 验证外星语词典 https://leetcode.cn/problems/verifying-an-alien-dictionary/
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 * 示例 1：
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 *
 * 示例 2：
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 *
 * 示例 3：
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
 */

class LeetCode953 {
    public boolean isAlienSorted(String[] words, String order) {

        int[] index = new int[26];
        for(int i = 0; i < order.length(); i++){  //这里是order.length(), 不是words.length
            index[order.charAt(i) - 'a'] = i;     //求出新字母表在原字母表index中的索引
        }
        //String order = "hlabcdefgijkmnopqrstuvwxyz"
        //index: [2, 3, 4, 5, 6, 7, 8, 0, 9, 10, 11, 1, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
        //                             h             l
        boolean res = false;

        for(int i = 1; i < words.length; i++){
            for(int j = 0; j < words[i - 1].length() && j < words[i].length(); j++){
                int prev = index[words[i - 1].charAt(j) - 'a']; //prev老字母表在新字母表中的索引
                int cur = index[words[i].charAt(j) - 'a'];

                if(prev < cur){
                    res = true;
                    break;
                }else if(prev > cur){
                    return false;
                }
            }
            if(!res){  //特殊情况,如果words[i - 1] 和 words[i]全部比较完毕,则判断如果前者较大,则false。 前者较小责无所谓
                if(words[i - 1].length() > words[i].length()){
                    return false;
                }
            }
        }
        return true;

    }
}