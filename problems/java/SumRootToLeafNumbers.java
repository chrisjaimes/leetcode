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
  int sum = 0;
  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    preorder(root, 0);
    return sum;
  }
  
  private void preorder(TreeNode root, int current) {
    if (root == null) {
      return;
    }
          
    current = (current * 10) + root.val;
    if (root.left == null && root.right == null) {
      sum += current;
      return;
    }
      
    preorder(root.left, current);
    preorder(root.right, current);
  }
}