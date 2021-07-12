class Solution {
  public int minDistance(String word1, String word2) {
    if (word1.length() == 0) {
      return word2.length();
    }
    if (word2.length() == 0) {
      return word1.length();
    }
      
    String sub1 = word1.substring(0, word1.length() - 1);
    String sub2 = word2.substring(0, word2.length() - 1);
      
    if (word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1)) {
      return minDistance(sub1, sub2);
    } else {
      return Math.min(
        Math.min(
          1 + minDistance(word1, sub2),
          1 + minDistance(sub1, word2)
        ),
        1 + minDistance(sub1, sub2)
      );
    }
  }
}