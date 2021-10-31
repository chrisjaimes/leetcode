class Solution {
  public boolean canCross(int[] stones) {
    return canCross(stones, 0, 0);
  }
  
  private boolean canCross(int[] stones, int position, int jump) {
    if (position == stones.length - 1) {
      return true;
    }
      
    for (int i = position + 1; i < stones.length; i++) {
      int gap = stones[i] - stones[position];
      if (gap <= jump + 1 && gap >= jump - 1) {
        if (canCross(stones, i, gap)) {
          return true;
        }
      }
    }
      
    return false;
  }
}