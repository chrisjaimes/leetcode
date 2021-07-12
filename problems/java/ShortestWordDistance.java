class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
    int distance = Integer.MAX_VALUE;
    int indexOne = -1;
    int indexTwo = -1;
    
    for (int i = 0; i < words.length; i++) {
      if (word1.equals(words[i])) {
        indexOne = i;
      } else if(word2.equals(words[i])) {
        indexTwo = i;
      }
        
      if (indexOne != -1 && indexTwo != -1) {
        distance = Math.min(distance, Math.abs(indexTwo - indexOne));
      }
    }
    
    return distance;
  }
}