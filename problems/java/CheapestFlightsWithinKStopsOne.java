class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, List<int[]>> adj = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adj.put(i, new ArrayList<int[]>());
    }

    for (int i = 0; i < flights.length; i++) {
      adj.get(flights[i][0]).add(new int[] { flights[i][1], flights[i][2] });
    }

    int minCost = Integer.MAX_VALUE;
    int stop = 0;

    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] { src, 0 });

    while (!queue.isEmpty() && stop <= k + 1) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        int[] temp = queue.remove();
        int currentCity = temp[0];
        int currentCost = temp[1];

        if (currentCity == dst) {
          minCost = Math.min(currentCost, minCost);
          continue;
        }
        
        if (adj.get(currentCity).size() == 0) {
          continue;
        }

        for (int[] flight : adj.get(currentCity)) {
          if (stop >= k && dst != flight[0]) {
            continue;
          }
          if (currentCost + flight[1] <= minCost) {
            queue.add(new int[] { flight[0], currentCost + flight[1] });
          }
        }
      }
      stop++;
    }

    return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
  }
}