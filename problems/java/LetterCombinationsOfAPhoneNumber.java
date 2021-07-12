class Solution {
  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<String>();
    }
    
    String[] lettersMap = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    List<String> result = new ArrayList<>();
    dfs(digits, lettersMap, 0, new StringBuilder(), result);
    return result;
  }
  
  private void dfs(String digits, String[] lettersMap, int index, StringBuilder current, List<String> result) {
    if (index >= digits.length()) {
      result.add(current.toString());
      return;
    }  
      
    int digit = digits.charAt(index) - '0' - 1;
    String letters = lettersMap[digit];
    for(int i = 0; i < letters.length(); i++) {
      current.append(letters.charAt(i));
      dfs(digits, lettersMap, index + 1, current, result);
      current.deleteCharAt(current.length() - 1);
    }
  }
}