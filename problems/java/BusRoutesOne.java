class Solution {
  public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target) {
      return 0;
    }
    
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    HashSet<Integer> busVisited = new HashSet<>();
    
    for (int i = 0; i < routes.length; i++) {
      for (int j = 0; j < routes[i].length; j++) {
        adj.putIfAbsent(routes[i][j], new ArrayList<>());
        adj.get(routes[i][j]).add(i);
      }
    }
    
    int numberOfBuses = 0;
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(source);
    
    while (!queue.isEmpty()) {
      int n = queue.size();
      
      for (int i = 0; i < n; i++) {
        int busStop = queue.poll();
        if (busStop == target) {
          return numberOfBuses;
        }
        
        List<Integer> buses = adj.get(busStop);
        for (int bus : buses) {
          if (busVisited.contains(bus)) {
            continue;
          }
          busVisited.add(bus);
          for (int j = 0; j < routes[bus].length; j++) {
            int nextStop = routes[bus][j];
            queue.add(nextStop);
          }
        }
      }
      numberOfBuses++;
    }
    
    return -1;
  }
}