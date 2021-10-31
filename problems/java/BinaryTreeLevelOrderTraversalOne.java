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
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    
    while (!queue.isEmpty()) {
      List<Integer> currentLevel = new ArrayList<>();
      int size = queue.size();
      
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        currentLevel.add(node.val);
        
        if (node.left != null) {
          queue.add(node.left); 
        }
        if (node.right != null) {
          queue.add(node.right); 
        }
      }
      
      result.add(currentLevel);
    }
     
    return result;
  }
}