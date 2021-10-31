class Solution {
  public int maxDistToClosest(int[] seats) {
    int prev = -1;
    int next = 0;
    int max = 0;
      
    for (int seatHereIndex = 0; seatHereIndex < seats.length; seatHereIndex++) {
      if (seats[seatHereIndex] == 1) {
        prev = seatHereIndex;
      } else {
        while (next < seats.length && (seats[next] == 0 || next < seatHereIndex)) {
          next++;
        }
        int left = (prev == -1) ? seats.length : seatHereIndex - prev;
        int right = (next == seats.length) ? seats.length : next - seatHereIndex;
        max = Math.max(max, Math.min(left, right));
      }
    }
      
    return max;
  }
}
