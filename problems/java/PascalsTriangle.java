class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>(){{ add(1); }});
  
    for (int i = 1; i < numRows; i++) {
      List<Integer> row = new ArrayList<>();
      for (int col = 0; col < i; col++) {
        if (col == 0) {
          row.add(1);
        } else {
          row.add(result.get(i - 1).get(col) + result.get(i - 1).get(col - 1));
        }
      }
      row.add(1);
      result.add(row);
    }
    
    return result;
  }
}