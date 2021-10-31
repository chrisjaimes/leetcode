class Solution {
  public int mySqrt(int x) {
    if (x < 2) {
      return x;
    }
    
    int left = 0;
    int right = x / 2;
    
    while (left <= right) {
      int guess = left + (right - left) / 2;
      long num = (long)guess * guess;
      
      if (num > x) {
        right = guess - 1;
      } else if (num < x) {
        left = guess + 1;
      } else {
        return guess;
      }
    }
    
    return right;
  }
}