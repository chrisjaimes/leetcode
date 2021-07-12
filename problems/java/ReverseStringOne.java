class Solution {
  public void reverseString(char[] s) {
    int i = 0, j = s.length - 1;
    reverseString(s, i, j);
  }

  private void reverseString(char[] s, int i, int j) {
    if (i >= j) {
      return;
    }
    char temp = s[i];
    s[i] = s[j];
    s[j] = temp;

    reverseString(s, ++i, --j);
  }
}