class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    generateAll(new char[n * 2], 0, result);
    return result;
  }
  private void generateAll(char[] chars, int index, List<String> result) {
    if (index == chars.length) {
      if (isValid(chars)) {
        result.add(new String(chars));
      }
      return;
    }
    chars[index] = '(';
    generateAll(chars, index + 1, result);
    chars[index] = ')';
    generateAll(chars, index + 1, result);
  }
  private boolean isValid(char[] chars) {
    int balance = 0;
    for (char c : chars) {
      if (c == '(') {
        balance++;
      } else {
        balance--;
      }
      if (balance < 0) {
        return false;
      }
    }
    return balance == 0;
  }
}