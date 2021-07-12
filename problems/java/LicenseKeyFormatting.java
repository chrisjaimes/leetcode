class Solution {
  public String licenseKeyFormatting(String s, int k) {
    StringBuilder str = new StringBuilder();
    int count = 0;
    int i = s.length() - 1;
    while (i >= 0) {
      char c = Character.toUpperCase(s.charAt(i));
      if (c == '-') {
        i--;
      } else if (count != 0 && count % k == 0) {
        str.insert(0, "-");
        count = 0;
      } else {
        str.insert(0, c);
        count++;
        i--;
      }
    }
    
    return str.toString();
  }
}