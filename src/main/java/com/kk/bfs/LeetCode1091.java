package com.kk.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径 https://leetcode.cn/problems/shortest-path-in-binary-matrix/
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * 路径途经的所有单元格都的值都是 0.路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 *
 * 示例 1：
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 *
 * 示例 2：
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 *
 * 示例 3：
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 *
 * 提示：
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] 为 0 或 1
 */
class LeetCode1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1){
            return -1;
        }
        if(m == 1){
            return 1;
        }
        int res = 1;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] temp = queue.poll();
                int i = temp[0];
                int j = temp[1];
                for(int c = 0; c < 8; c++){
                    int ni = i + dir[c][0];
                    int nj = j + dir[c][1];
                    if(ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 0 && !visited[ni][nj]){
                        if(ni == m - 1 && nj == n - 1){
                            return res + 1;
                        }
                        queue.add(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}