class Solution {
  
  HashMap<Character, Character> map = new HashMap<>() {{
    this.put('(', ')');
    this.put('[', ']');
    this.put('{', '}');
  }};
  
  public boolean isValid(String s) {
      if (s.length() == 1) {
        return false;
      }
      
      Deque<Character> stack = new ArrayDeque<Character>();
      
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        
        if (map.containsKey(c)) {
          stack.push(c);
        } else {
          if (stack.isEmpty()) {
            return false;
          } else if (map.get(stack.pop()) != c) {
            return false;
          }
        }
      }
    
    return stack.isEmpty();
  }
}