class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(0, 0, n, result, new StringBuilder());
    return result;
  }
  private void backtrack(int open, int close, int max, List<String> result, StringBuilder sb) {
    if (sb.toString().length() == max * 2) {
      result.add(sb.toString());
      return;
    }
    
    if (open < max) {
      backtrack(open + 1, close, max, result, sb.append("("));
      sb.deleteCharAt(sb.length() - 1);
    }
    if (close < open) {
      backtrack(open, close + 1, max, result, sb.append(")"));
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}