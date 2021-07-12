class Solution {
  public char findTheDifference(String s, String t) {
      char[] sChars = s.toCharArray();
      char[] tChars = t.toCharArray();
      Arrays.sort(sChars);
      Arrays.sort(tChars);
      
      for (int i = 0; i < tChars.length; i++) {
          if (i < sChars.length && tChars[i] != sChars[i]) {
              return tChars[i];
          }
      }
      
      return tChars[tChars.length - 1];
  }
}
