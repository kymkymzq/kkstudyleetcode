package com.kk.dfs;

/**
 * 200. 岛屿数量 https://leetcode.cn/problems/number-of-islands/
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
class LeetCode200 {
    public int numIslands(char[][] grid) {
        
        int res = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;  //遇到'1',必定遇到一个岛屿,因此先+1
                    dfs(grid, directions, i, j);
                    //每次dfs的目的,都是将本次遇到的'1'及其相邻的'1'置为0,将dfs能遍历到的"这座岛屿"全置0,使其不会影响"下一座岛屿的计算"
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int[][] directions, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';  //每次dfs的目的就是把1置为0,这样下次进入一个新的岛屿的时候,不会与上次的岛屿重复计算。

        for(int k = 0; k < directions.length; k++){
            int ni = i + directions[k][0];
            int nj = j + directions[k][1];
            dfs(grid, directions, ni, nj);

        }
    }    

}