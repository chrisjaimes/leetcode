import java.util.HashMap;

class TimeMap {

  class Node {
    int ts;
    String val;
    Node next;
    Node prev;

    public Node(String val, int ts) {
      this.val = val;
      this.ts = ts;
    }
  }

  /** Initialize your data structure here. */
  HashMap<String, Node> map;
  public TimeMap() {
    this.map = new HashMap<>();
  }
  
  public void set(String key, String value, int timestamp) {
    Node node = new Node(value, timestamp);
    Node temp = this.map.get(key);
    if (temp != null) {
      node.next = temp;
      temp.prev = node;
    }
    this.map.put(key, node);
  }
  
  public String get(String key, int timestamp) {
    Node node = this.map.get(key);
    String value = "";
    if (node != null) {
      while (node != null) {
        if (node.ts > timestamp) {
          node = node.next;
        } else {
          return node.val;
        }
      }
    }
    return value;
  }
}

/**
* Your TimeMap object will be instantiated and called as such:
* TimeMap obj = new TimeMap();
* obj.set(key,value,timestamp);
* String param_2 = obj.get(key,timestamp);
*/