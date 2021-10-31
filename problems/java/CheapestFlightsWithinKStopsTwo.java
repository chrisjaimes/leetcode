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

    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] { src, 0, 0 });

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        int[] temp = queue.remove();
        int currentCity = temp[0];
        int currentCost = temp[1];
        int stopsToThisCity = temp[2];

        if (currentCity == dst) {
          return currentCost;
        }

        if (stopsToThisCity == k + 1) {
          continue;
        }
        
        if (adj.get(currentCity).size() == 0) {
          continue;
        }

        for (int[] flight : adj.get(currentCity)) {
          
        }
      }
    }

    return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
  }
}