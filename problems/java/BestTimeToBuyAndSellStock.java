class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    
    int profit = 0;
    int buyPrice = Integer.MAX_VALUE;
    
    for (int i = 0; i < prices.length; i++) {
      if (buyPrice > prices[i]) {
          buyPrice = prices[i];
      } 
      profit = Math.max(prices[i] - buyPrice, profit);
    }
    
    return profit;
  }
}