public class Solution {
  public int hammingWeight(int n) {
    int k = 0;
    while (n != 0) {
      k++;
      n = (n & (n - 1));
    }
    
    return k;
  }
}