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
    Deque<Node> queue = new ArrayDeque<>();
    queue.add(root);
    
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = queue.size();
      
      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        level.add(node.val);
        for (Node c : node.children) {
          queue.add(c);
        }
      }
        
      result.add(level);
    }
      
    return result;
  }
}