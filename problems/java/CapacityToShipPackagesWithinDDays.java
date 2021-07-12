class Solution {
  public int shipWithinDays(int[] weights, int days) {
    int lo = Integer.MIN_VALUE;
    int hi = 0;
      
    for (int w : weights) {
      hi += w;
      lo = Math.max(w, lo);
    }
      
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (shipPackages(weights, mid, days)) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
      
    return lo;
  }
  
  private boolean shipPackages(int[] weights, int capacity, int days) {
    int current = 0;
    for (int i = 0; i < weights.length; i++) {
      if (weights[i] + current <= capacity) {
        current += weights[i];   
      } else {
        days--;
        current = weights[i];
      }
    }
      
    if (days <= 0) {
      return false;
    } else {
      return true;
    }
  }
}