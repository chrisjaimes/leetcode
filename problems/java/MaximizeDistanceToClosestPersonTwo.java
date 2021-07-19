class Solution {
  public int maxDistToClosest(int[] seats) {
    int n = seats.length;
    int dist = 0;
    int ans = 0;

    for (int i = 0; i < n; ++i) {
      if (seats[i] == 1) {
        dist = 0;
      } else {
        dist++;
        ans = Math.max(ans, (dist + 1) / 2);
      }
    }

    for (int i = 0; i < n; ++i)  {
      if (seats[i] == 1) {
        ans = Math.max(ans, i);
        break;
      }
    }

    for (int i = n - 1; i >= 0; --i)  { 
      if (seats[i] == 1) {
        ans = Math.max(ans, n - 1 - i);
        break;
      }
    }

    return ans;
  }
}