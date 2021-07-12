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
      
    return cloneGraph(node, new HashMap<Node, Node>());
  }
  private Node cloneGraph(Node node, Map visited) {
    if (node == null) {
      return null;
    }
      
    if (visited.containsKey(node)) {
      return (Node)visited.get(node);
    }
      
    Node clone = new Node(node.val, new ArrayList<Node>());
    visited.put(node, clone);
    
    for (Node n : node.neighbors) {
      clone.neighbors.add(cloneGraph(n, visited));
    }
      
    return clone;
  }
}