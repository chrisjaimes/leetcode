class Solution {
  public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    int[] pattern = new int[s.length()];
    Arrays.fill(pattern, -1);
    
    for (int i = 0; i < indices.length; i++) {
      if (s.substring(indices[i], indices[i] + sources[i].length()).equals(sources[i])) {
        pattern[indices[i]] = i; 
      }
    }
    
    StringBuilder result = new StringBuilder();
    int i = 0;
    while (i < s.length()) {
      if (pattern[i] >= 0) {
        result.append(targets[pattern[i]]);
        i += sources[pattern[i]].length();
      } else {
        result.append(s.charAt(i++));
      }
    }
    return result.toString();
  }
}