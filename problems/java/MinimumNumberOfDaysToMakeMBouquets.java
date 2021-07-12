class Solution {
  public int minDays(int[] bloomDay, int m, int k) {
    if (m * k > bloomDay.length) {
      return -1;
    }
    
    int lo = Integer.MAX_VALUE;
    int hi = Integer.MIN_VALUE;
    for (int day : bloomDay) {
      lo = Math.min(lo, day);
      hi = Math.max(hi, day);
    }
    
    int mid;
    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;
      if (makeBouquets(bloomDay, mid, m, k)) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    
    return lo;
  }
  
  private boolean makeBouquets(int[] bloomDay, int day, int m, int k) {
    int flowers = 0;
    for (int d : bloomDay) {
      if (d <= day) {
        flowers++;
      } else {
        flowers = 0;
      }
      if (flowers == k) {
        m--;
        flowers = 0;
        if (m == 0) {
          return true;
        }
      }
    }
    return false;
  }
}