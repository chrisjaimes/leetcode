class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }
    return isPalindrome(s, 0, s.length() - 1);
  }
  
  public boolean isPalindrome(String s, int lo, int hi) {
    if (lo >= hi) {
      return true;
    }
    
    char c1 = Character.toLowerCase(s.charAt(lo));
    char c2 = Character.toLowerCase(s.charAt(hi));
    
    if (!Character.isLetterOrDigit(c1)) {
      return isPalindrome(s, lo + 1, hi);
    } else if (!Character.isLetterOrDigit(c2)) {
      return isPalindrome(s, lo, hi - 1);
    } else if (c1 != c2) { 
      return false;
    } else {
      return isPalindrome(s, lo + 1, hi - 1);
    }
  }
}