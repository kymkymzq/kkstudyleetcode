package com.kk.backtrace;

/**
 * 79. 单词搜索 https://leetcode.cn/problems/word-search/
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 *
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *  
 *
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？

 */

class LeetCode79 {
    public static boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        // boolean res = false;

        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
//                    if(dfs(board, word, direction, i, j, visited, 0)){
//                        return true;
//                    }
                    boolean res = dfs(board, word, direction, i, j, visited, 0);
                    if(res){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int[][] direction, int i, int j, boolean[][] visited, int index){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        
        boolean res = false;

        visited[i][j] = true;

        for(int k = 0; k < direction.length; k++){
            int ni = i + direction[k][0];
            int nj = j + direction[k][1];
            
            boolean flag = dfs(board, word, direction, ni, nj, visited, index + 1);
            if(flag){
                res = true;
                break;
            }

        }

        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        //board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean abcced = exist(board, "ABCCED");
        System.out.println(abcced);

    }
}