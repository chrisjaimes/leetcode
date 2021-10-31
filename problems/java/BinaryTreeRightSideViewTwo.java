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
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<Integer>();
    }

    List<Integer> result = new ArrayList<>();
    buildLists(root, 0, result);
    return result;
  }

  private void buildLists(TreeNode root, int level, List<Integer> result) {
    if (root == null) {
      return;
    }

    if (level == result.size()) {
      result.add(root.val);
    }

    buildLists(root.right, level + 1, result);
    buildLists(root.left, level + 1, result);
  }
}