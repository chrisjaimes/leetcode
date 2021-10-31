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
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    
    List<List<Integer>> result = new ArrayList<>();
    buildLists(root, 0, result);
    return result;
  }
  
  private void buildLists(TreeNode root, int level, List<List<Integer>> result) {
    if (root == null) {
      return;
    }
      
    if (level == result.size()) {
      result.add(new ArrayList<Integer>());
    }
      
    result.get(level).add(root.val);
    
    buildLists(root.left, level + 1, result);
    buildLists(root.right, level + 1, result);
  }
}