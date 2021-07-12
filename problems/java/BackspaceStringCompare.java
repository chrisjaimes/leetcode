import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public boolean backspaceCompare(String S, String T) {
    Deque<Character> stackS = new ArrayDeque<>();
    Deque<Character> stackT = new ArrayDeque<>();

    int lengthS = S.length();
    int lengthT = T.length();

    for (int i = 0; i < lengthS; i++) {
      char c = S.charAt(i);
      if (c != '#') {
        stackS.push(c);
      } else if (!stackS.isEmpty()) {
        stackS.pop();
      }
    }

    for (int i = 0; i < lengthT; i++) {
      char c = T.charAt(i);
      if (c != '#') {
        stackT.push(c);
      } else if (!stackT.isEmpty()) {
        stackT.pop();
      }
    }

    while (!stackS.isEmpty()) {
      char c = stackS.pop();
      if (stackT.isEmpty() || c != stackT.pop()) {
        return false;
      }
    }

    return stackT.isEmpty() && stackS.isEmpty();
  }
}
