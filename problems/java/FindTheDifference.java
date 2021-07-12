class Solution {
  public char findTheDifference(String s, String t) {
    char character = 0;
    int Slength = s.length();
    int Tlength = t.length();
    for (int i = 0; i < Tlength; i++) {
      if (i < Slength) {
        character ^= s.charAt(i);
      }
      character ^= t.charAt(i);
    }
    return character;
  }
}

