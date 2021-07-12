class Solution {
  public int totalFruit(int[] fruits) {
    int firstType = -1;
    int secondType = -1;
    int lastTypeCount = 0;
    int count = 0;
    int maxCount = 0;
    
    for (int i = 0; i < fruits.length; i++) {
      if (fruits[i] == firstType || fruits[i] == secondType) {
        count++;
      } else {
        count = lastTypeCount + 1;
      }
        
      if (fruits[i] == secondType) {
        lastTypeCount++;
      }
        
      if (fruits[i] != secondType) {
        firstType = secondType;
        secondType = fruits[i];
        lastTypeCount = 1;
      }
        
      maxCount = Math.max(maxCount, count);
    }
    
    return maxCount;
  }
}