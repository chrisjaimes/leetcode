class Solution {
  public boolean isValid(String s) {
    if (s.length() == 1) {
      return false;
    }
      
    Deque<Character> stack = new ArrayDeque<Character>();
    char[] str = s.toCharArray();
      
    for (int i = 0; i < str.length; i++) {
      if (str[i] == '(' || str[i] == '[' || str[i] == '{') {
        stack.push(str[i]);
      } else if (str[i] == ')' && !stack.isEmpty() && stack.peek() == '(') {
        stack.pop();
      } else if (str[i] == ']' && !stack.isEmpty() && stack.peek() == '[') {
        stack.pop();
      } else if (str[i] == '}' && !stack.isEmpty() && stack.peek() == '{') {
        stack.pop();
      } else {
        return false;
      }
    }
      
    return stack.isEmpty();
  }
}