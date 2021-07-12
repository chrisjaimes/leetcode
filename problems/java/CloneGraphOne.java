/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
      
    Deque<Node> queue = new ArrayDeque<>();
    Map<Node, Node> visited = new HashMap<>();
      
    queue.add(node);
    visited.put(node, new Node(node.val, new ArrayList<Node>()));
      
    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      for (Node n : temp.neighbors) {
        if (!visited.containsKey(n)) {
          visited.put(n, new Node(n.val, new ArrayList<Node>()));
          queue.add(n);
        }
        visited.get(temp).neighbors.add(visited.get(n));
      }
    }
      
    return visited.get(node);
  }
}