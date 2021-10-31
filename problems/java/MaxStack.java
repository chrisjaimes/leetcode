class MaxStack {

  Deque<int[]> stack;
  
  public MaxStack() {
    stack = new ArrayDeque<>();
  }

  public void push(int val) {
    int[] value;
    if (stack.isEmpty()) {
      value = new int[]{ val, val };
    } else {
      int[] temp = stack.peek();
      value = new int[] { val, Math.max(val, stack.peek()[1]) };
    }
    
    stack.push(value);
  }

  public int pop() {
    return stack.pop()[0];
  }

  public int top() {
    return stack.peek()[0];
  }
  
  public int popMax() {
    int max = this.peekMax();
    Deque<Integer> buffer = new ArrayDeque<>();
    while (max != this.top()) {
      buffer.push(this.pop());
    }
    this.pop();
    
    while (!buffer.isEmpty()) {
      this.push(buffer.pop());
    }
    return max;
  }

  public int peekMax() {
    return stack.peek()[1];
  }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */