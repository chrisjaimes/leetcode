class Solution {
  public boolean repeatedSubstringPattern(String s) {
    int length = s.length();
    for (int i = 1; i <= length / 2; i++) {
      String subs = s.substring(0, i);
      int reps = length / subs.length();
      StringBuilder sb = new StringBuilder();
      while (reps-- > 0) {
        sb.append(subs);
      }
      if (sb.toString().equals(s)) {
        return true;
      }
    }

    return false;
  }
}