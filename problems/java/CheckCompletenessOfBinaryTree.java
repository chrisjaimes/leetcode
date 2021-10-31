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
  public boolean isCompleteTree(TreeNode root) {
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    
    boolean hasNull = false;
    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      
      if (hasNull && node.left != null) {
        return false;
      }
        
      if (hasNull && node.right != null) {
        return false;
      }

      if (node.left == null || node.right == null) {
        hasNull = true;
      } 

      if (node.left != null) {
        queue.add(node.left);
      }   
      if (node.right != null) {
        queue.add(node.right);
      }
    }
      
    return true;
  }
}