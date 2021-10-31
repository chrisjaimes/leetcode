class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() <= 1) {
      return s.length();
    }

    int start = 0;
    int res = 0;
    Set<Character> set = new HashSet<>();

    for (int end = 0; end < s.length(); end++) {
      if (!set.contains(s.charAt(end))) {
        set.add(s.charAt(end));
        res = Math.max(res, set.size());
      } else {
        set.remove(s.charAt(start));
        end--;
        start++;
      }
    }

    return res;
  }
}