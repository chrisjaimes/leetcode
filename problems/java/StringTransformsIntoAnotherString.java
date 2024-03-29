class Solution {
  public boolean canConvert(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    } else if (str1.equals(str2)) {
      return true;
    }
      
    HashMap<Character, Character> map = new HashMap<>();
    HashSet<Character> set = new HashSet<>();
    
    for (int i = 0; i < str1.length(); i++) {
      char c1 = str1.charAt(i);
      char c2 = str2.charAt(i);
      if (!map.containsKey(c1)) {
        map.put(c1, c2);
      } else if (map.get(c1) != c2) {
        return false;
      }
      set.add(c2);
    }
    
    return set.size() < 26;
  }
}