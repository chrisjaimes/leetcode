class Solution {
  public boolean canCross(int[] stones) {
    HashMap<Integer, Set<Integer>> dp = new HashMap();
    
    for(int val : stones) { 
      dp.put(val, new HashSet());
    }

    dp.get(stones[0]).add(1);
    
    for(int val : stones) {
      for(int jump : dp.get(val)) {
        int nextStone = val + jump;
        if(jump != 0 && dp.containsKey(nextStone)) {
          dp.get(nextStone).add(jump - 1);
          dp.get(nextStone).add(jump);
          dp.get(nextStone).add(jump + 1);
        }
      }
    }
    
    return !dp.get(stones[stones.length-1]).isEmpty();
  }
}