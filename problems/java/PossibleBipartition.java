class Solution {
  public boolean possibleBipartition(int n, int[][] dislikes) {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<Integer>());
    }
      
    for (int i = 0; i < dislikes.length; i++) {
      graph.get(dislikes[i][0] - 1).add(dislikes[i][1] - 1);
      graph.get(dislikes[i][1] - 1).add(dislikes[i][0] - 1);
    }
      
    int[] groups = new int[n];
    
    for (int i = 0; i < n; i++) {
      if (groups[i] == 0 && !dfs(i, graph, groups, 1)) {
        return false;
      }
    }
      
    return true;
  }
  
  private boolean dfs(int node, HashMap<Integer, List<Integer>> graph, int[] groups, int group) {
    groups[node] = group;
      
    for (int i = 0; i < graph.get(node).size(); i++) {
      int neighbor = graph.get(node).get(i);
    
      if (groups[neighbor] == group) {
        return false;
      }

      if (groups[neighbor] == 0 && !dfs(neighbor, graph, groups, -group)) {
        return false;
      }
    }
      
    return true;
  }
}