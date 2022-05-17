package com.onequestionperday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

/**
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 * 通过次数51,114提交次数82,010
 */

class interview0406 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        Queue<TreeNode> queue = new LinkedList<>();

        midErgodic(root, queue);

        TreeNode res = null;
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node == p){   //这里如果是最后一个元素，那还要判断这个之后是否还有元素。
                // return queue.remove();
                if(queue.isEmpty()){    //如果没有元素,则直接return null
                    return null;
                }else{                //如果有元素,就再移除下一个元素
                    return queue.remove();
                }
            }

        }
        return null;

    }
    
    public void midErgodic(TreeNode root, Queue<TreeNode> queue){
        if(root == null){
            return;
        }

        if(root.left != null){
            midErgodic(root.left, queue);
        }

        queue.add(root);

        if(root.right != null){
            midErgodic(root.right, queue);
        }
    }


}







