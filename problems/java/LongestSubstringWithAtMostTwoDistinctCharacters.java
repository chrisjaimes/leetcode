class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int start = 0;
    int result = 0;
    HashMap<Character, Integer> map = new HashMap<>();
      
    for (int end = 0; end < s.length(); end++) {
      char c = s.charAt(end);
      map.put(c, map.getOrDefault(c, 0) + 1);
        
      while (map.size() > 2) {
        char temp = s.charAt(start);
        map.put(temp, map.get(temp) - 1);
        start++;
        
        if (map.get(temp) == 0) {
          map.remove(temp);
        }
      }
        
      result = Math.max(result, end - start + 1);
    }
      
    return result;
  }
}