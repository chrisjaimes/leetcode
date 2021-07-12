class Solution {
  public String decodeString(String s) {
    Deque<Integer> countStack = new ArrayDeque<>();
    Deque<StringBuilder>  strStack = new ArrayDeque<>();
      
    StringBuilder temp = new StringBuilder();
    int count = 0;
    for(char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        count = count * 10 + (c - '0'); 
      } else if (c == '[') {
        countStack.push(count);
        count = 0;
        
        strStack.push(temp);
        temp = new StringBuilder();
      } else if (c == ']') {
        StringBuilder str = strStack.pop();
        int k = countStack.pop();
        for (int i = 0; i < k; i++) {
            str.append(temp);
        }
        temp = str;
      } else {
        temp.append(c);
      }
    }
      
    return temp.toString();
  }
}