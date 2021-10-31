class LRUCache {
  int capacity;
  Node head;
  Node tail;
  HashMap<Integer, Node> cache;

  class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node() {
      this.key = -1;
      this.value = -1;
    }
    
    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public LRUCache(int capacity) {
    this.cache = new HashMap<>();
    this.capacity = capacity;
    this.head = new Node();
    this.tail = new Node();
    head.next = tail;
    tail.prev = head;
  }
  
  public int get(int key) {
    Node node = this.cache.get(key);
    if (node == null) {
      return -1;
    } else {
      this.moveToHead(node);
      return node.value;
    }
  }
  
  public void put(int key, int value) {
    Node node = this.cache.get(key);
    if (node == null) {
      if (this.cache.size() == this.capacity) {
        Node removed = popTail();
        this.cache.remove(removed.key);
      }
      Node newNode = new Node(key, value);
      this.cache.put(key, newNode);
      addNode(newNode);
    } else {
      node.value = value;
      moveToHead(node);
    }
  }

  private void addNode(Node node) {
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
  }

  private void removeNode(Node node) {
    Node prev = node.prev;
    Node next = node.next;

    prev.next = next;
    next.prev = prev;
  }

  private void moveToHead(Node node) {
    this.removeNode(node);
    this.addNode(node);
  }

  private Node popTail() {
    Node temp = tail.prev;
    this.removeNode(temp);
    return temp;
  }
}

/**
* Your LRUCache object will be instantiated and called as such:
* LRUCache obj = new LRUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/