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
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    while (root != null) {
      List<Integer> leaves = new ArrayList<>();
      root = findLeaves(root, leaves);
      result.add(leaves);
    }
      
    return result;
  }
  
  private TreeNode findLeaves(TreeNode root, List<Integer> current) {
    if (root == null) {
      return null;
    }
      
    if (root.left == null && root.right == null) {
      current.add(root.val);
      return null;
    }
      
    if (root.left != null) {
      root.left = findLeaves(root.left, current);      
    }
    if (root.right != null) {
      root.right = findLeaves(root.right, current);      
    }

    return root;
  }
}