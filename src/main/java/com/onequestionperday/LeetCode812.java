package com.onequestionperday;

/**
 * 812. 最大三角形面积 https://leetcode.cn/problems/largest-triangle-area/
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 *
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 *
 *
 * 注意:
 *
 * 3 <= points.length <= 50.
 * 不存在重复的点。
 *  -50 <= points[i][j] <= 50.
 * 结果误差值在 10^-6 以内都认为是正确答案。
 */

class LeetCode812 {
    public double largestTriangleArea(int[][] points) {
        
        double res = 0;

        for(int i = 0; i < points.length - 2; i++){
            for(int j = i + 1; j < points.length - 1; j++){
                for(int k = j + 1; k < points.length; k++){
                    res = Math.max(res, crossProduct(points[i], points[j], points[k]));
                }
            }
        }
        return res;
    }
    
    public double crossProduct(int[] points1, int[] points2, int[] points3){
        int[] vector1 = {points1[0] - points2[0], points1[1] - points2[1]};
        int[] vector2 = {points1[0] - points3[0], points1[1] - points3[1]};

        //叉积求三角形面积公式: S = |x1·y2 - x2·y1| / 2
        //证明在这里 https://www.cnblogs.com/kkksc0100/p/SABC.html
        return Math.abs(vector1[0] * vector2[1] - vector2[0] * vector1[1])/2.0; //一定要记住，浮点数不能/2,要/2.0 !!!

    }
}



