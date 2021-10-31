/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }
    
    List<List<Integer>> result = new ArrayList<>();
    buildLists(root, 0, result);
    return result;
  }
  
  private void buildLists(Node root, int level, List<List<Integer>> result) {
    if (root == null) {
      return;
    }
      
    if (level == result.size()) {
      result.add(new ArrayList<Integer>());
    }
      
    result.get(level).add(root.val);
    for (int i = 0; i < root.children.size(); i++) {
      Node child = root.children.get(i);
      buildLists(child, level + 1, result);
    }
  }
}