/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public boolean hasPathSum(TreeNode root, int sum) { 
    if (root == null) {
      return false;
    }
  
    return sumPath(root, 0, sum);
  }
  
  public boolean sumPath(TreeNode node, int current, int target) {
    if (node == null) {
      return false;
    }
    
    current += node.val;
    
    if (node.left == null && node.right == null) {
      return current == target;
    }
    
    return sumPath(node.left, current, target) || sumPath(node.right, current, target);
  }
}