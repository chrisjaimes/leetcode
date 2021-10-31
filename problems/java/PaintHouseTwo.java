class Solution {
  private int[][] costs;
  HashMap<String, Integer> memo; 
  
  public int minCost(int[][] costs) {
    if (costs.length == 0 ) {
      return 0;
    }
        
    this.costs = costs;
    this.memo = new HashMap<>();
    return Math.min(paintHouse(0, 0), Math.min(paintHouse(0, 1), paintHouse(0, 2)));
  }
  
  private int paintHouse(int house, int color) {
    int total = costs[house][color];
    
    if (memo.containsKey(house + "" + color)) {
      return memo.get(house + "" + color);
    }
      
    if (house == costs.length - 1) {
      ;
    } else if (color == 0) {
      total += Math.min(paintHouse(house + 1, 1), paintHouse(house + 1, 2));
    } else if (color == 1) {
      total += Math.min(paintHouse(house + 1, 0), paintHouse(house + 1, 2));
    } else if (color == 2) {
      total += Math.min(paintHouse(house + 1, 0), paintHouse(house + 1, 1));
    }
      
    memo.put(house+""+color, total);
    return total;
  }
}