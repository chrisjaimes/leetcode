class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    int[] pCount = new int[26];
    int[] sCount = new int[26];
    List<Integer> result = new ArrayList<>();

    for (char c : p.toCharArray()) {
      pCount[c - 'a']++;
    }

    for (int end = 0; end < s.length(); end++) {
      sCount[s.charAt(end) - 'a']++;

      if (end >= p.length()) {
        sCount[s.charAt(end - p.length()) - 'a']--;
      }

      if (Arrays.equals(sCount, pCount)) {
        result.add(end - p.length() + 1);
      }
    }

    return result;
  }
}