class Solution {
  public String addStrings(String num1, String num2) {
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;
    StringBuilder result = new StringBuilder();
    
    while (i >= 0 || j >= 0) {
      int x = (i < 0) ? 0 : num1.charAt(i) - '0';
      int y = (j < 0) ? 0 : num2.charAt(j) - '0';
      
      int digit = (x + y + carry) % 10;
      carry = (x + y + carry) / 10;
      
      i--; j--;
      result.append(digit);
    }
    
    if (carry > 0) {
      result.append(1);
    }
    
    return result.reverse().toString();
  }
}