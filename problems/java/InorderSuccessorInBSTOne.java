/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (p == null) {
      return null;
    } else if (p.right != null) {
      p = p.right;
      while (p.left != null) {
        p = p.left;
      }
      return p;
    }
    
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode prev = null;
    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      
      TreeNode node = stack.pop();
      if (prev == p) {
        return node;
      }
      
      prev = node;
      root = node.right;
    }
    
    return null;
  }
}