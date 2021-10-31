class Solution {
  public int maxScore(int[] cardPoints, int k) {
    return maxScore(cardPoints, k, 0, 0, cardPoints.length - 1);
  }
  
  private int maxScore(int[] cardPoints, int k, int sum, int left, int right) {
    if (k <= 0) {
      return sum;
    } else if (left > right) {
      return sum;
    }
      
    int res1 = maxScore(cardPoints, k - 1, sum + cardPoints[left], left + 1, right);
    int res2 = maxScore(cardPoints, k - 1, sum + cardPoints[right], left, right - 1);
    sum = Math.max(res1, res2);
    
    return sum;
  }
}