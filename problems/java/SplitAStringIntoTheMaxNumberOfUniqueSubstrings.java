public class Solution {
  int max;
  public int maxUniqueSplit(String s) {
    HashSet<String> set = new HashSet<>();
    dfs(s, 0, s.length() - 1, set);
    return max;
  }

  public void dfs(String str, int start, int end, HashSet<String> set) {
    if (start > end) {
      max = Math.max(set.size(), max);
      return;
    }

    for (int i = start; i <= end; i++) {
      String substring = str.substring(start, i + 1);
      if (set.add(substring)) {
        dfs(str, i + 1, end, set);
        set.remove(substring);
      }
    }
  }
}
