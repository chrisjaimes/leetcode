class Solution {
  public int longestValidParentheses(String s) {
    int longest = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(-1);
    
    for (int i = 0; i < s.length(); i++) {
      int temp = 0;
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          temp = i - stack.peek();
        }
      }
      longest = Math.max(temp, longest);
    }
    
    return longest;
  }
}