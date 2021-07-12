class Solution {
  public int numSplits(String s) {
    if (s == null) {
      return 0;
    } else if (s.length() < 3) {
      return 1;
    }
    
    return numSplits(s, 1);
  }
  
  private int numSplits(String str, int index) {
    if (index == str.length()) {
      return 0;
    }
    
    String partitionOne = str.substring(0, index);
    String partitionTwo = str.substring(index);
    
    Set<Character> setOne = new HashSet<>();
    Set<Character> setTwo = new HashSet<>();
    char[] charsOne = partitionOne.toCharArray();
    char[] charsTwo = partitionTwo.toCharArray();
    
    for (char c : charsOne) {
      setOne.add(c);
    }
    for (char c : charsTwo) {
      setTwo.add(c);
    }
    
    if (setOne.size() != setTwo.size()) {
      return numSplits(str, index + 1);
    } else {
      return 1 + numSplits(str, index + 1);
    }
  }
}