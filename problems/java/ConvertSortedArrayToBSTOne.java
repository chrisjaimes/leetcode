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
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    return buildBST(nums, 0, nums.length - 1);
  }
  
  private TreeNode buildBST(int[] nums, int lo, int hi) {
    if (lo > hi) {
      return null;
    }

    int mid = lo + (hi - lo) / 2;
    if (lo + (hi - lo) % 2 == 1) {
      mid += 1;
    }
    TreeNode node = new TreeNode(nums[mid]);

    node.left = buildBST(nums, lo, mid - 1);
    node.right = buildBST(nums, mid + 1, hi);

    return node;
  }
}