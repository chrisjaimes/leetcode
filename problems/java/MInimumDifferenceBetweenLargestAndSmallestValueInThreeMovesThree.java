class Solution {
  public int minDifference(int[] nums) {
    int len = nums.length;
    if (len < 5) {
      return 0;
    }
    
    PriorityQueue<Integer> max = new PriorityQueue<Integer>();
    PriorityQueue<Integer> min = new PriorityQueue<Integer>(Collections.reverseOrder());
    
    for (int i = 0; i < len; i++) {
      max.add(nums[i]);
      min.add(nums[i]);
      
      if (max.size() > 4) {
        max.poll();
        min.poll();
      }
    }
    
    int[] minA = new int[4];
    int[] maxA = new int[4];
    for (int i = 0, k = 3; i < 4; i++, k--) {
      minA[i] = min.poll();
      maxA[k] = max.poll();
    }
    
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < 4; i++) {
      ans = Math.min(ans, maxA[i] - minA[i]);
    }
    return ans;
  }
}