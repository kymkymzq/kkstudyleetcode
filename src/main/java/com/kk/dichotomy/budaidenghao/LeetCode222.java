package com.kk.dichotomy.budaidenghao;

/**
 * 222. 完全二叉树的节点个数 https://leetcode.cn/problems/count-complete-tree-nodes/
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面
 * 一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 *
 * 示例 2：
 * 输入：root = []
 * 输出：0
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 *
 * 提示：
 *
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 */
class LeetCode222 {
    //解法1
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }
    //解法2
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode node = root;
        int level = 0;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level;
        int high = (1 << (level + 1)) - 1;
        while (low < high) { //不带等号
            int mid = (low + high + 1) >>> 1;
            if (exists(root, mid, level)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int mid, int level) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & mid) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}













