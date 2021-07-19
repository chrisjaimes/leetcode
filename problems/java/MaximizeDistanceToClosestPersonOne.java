class Solution {
  public int maxDistToClosest(int[] seats) {
    int prev = -1;
    int next = 0;
    int max = 0;
      
    for (int end = 0; end < seats.length; end++) {
      if (seats[end] == 1) {
        prev = end;
      } else {
        while (next < seats.length && (seats[next] == 0 || next < end)) {
          next++;
        }
        int left = prev == -1 ? seats.length : end - prev;
        int right = next == seats.length ? seats.length : next - end;
        max = Math.max(max, Math.min(left, right));
      }
    }
      
    return max;
  }
}
