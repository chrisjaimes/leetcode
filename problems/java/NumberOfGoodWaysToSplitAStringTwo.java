class Solution {
  public int numSplits(String s) {
    if (s == null) {
      return 0;
    } else if (s.length() < 3) {
      return 1;
    }

    int ways = 0;
    int length = s.length();
    for (int i = 1; i < length; i++) {
      String partitionOne = s.substring(0, i);
      String partitionTwo = s.substring(i);

      int n1 = chars(partitionOne.toCharArray());
      int n2 = chars(partitionTwo.toCharArray());
      if (n1 == n2) {
        ways++;
      }
    }
  
    return ways;
  }

  private int chars(char[] str) {
    Set<Character> set = new HashSet<>();
    for (char c : str) {
      set.add(c);
    }
    return set.size();
  }
}