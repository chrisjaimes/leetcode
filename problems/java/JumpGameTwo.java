class Solution {
  public boolean canJump(int[] nums) {
    HashMap<Integer, Boolean> map = new HashMap<>();
    return canJumpHelper(nums, 0, map);
  }
  
  private boolean canJumpHelper(int[] nums, int index, HashMap<Integer, Boolean> map) {
    if (index == nums.length - 1) {
      return true;
    }
    
    if (map.containsKey(index)) {
      return map.get(index);
    }
  
    int furthest = Math.min(index + nums[index], nums.length - 1);
    for (int k = index + 1; k <= furthest; k++) {
      if (canJumpHelper(nums, k, map)) {
        map.put(index, true);
        return map.get(index);
      }
    }
      
    map.put(index, false);
    return map.get(index);
  }
}
   