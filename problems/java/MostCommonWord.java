class Solution {
  public String mostCommonWord(String paragraph, String[] banned) {
    HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));
    HashMap<String, Integer> map = new HashMap<>();
    
    String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
    String[] words = normalizedStr.split("\\s+");
    
    for (String s : words) {
      if (!bannedSet.contains(s)) {
        map.put(s, map.getOrDefault(s, 0) + 1);
      }
    }
    
    String result = "";
    for (String s : map.keySet()) {
      if (result == "" || map.get(s) > map.get(result)) {
        result = s;
      }
    }
    return result;
  }
}