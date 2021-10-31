class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    for (int n = 0; n < numCourses; n++) {
      graph.put(n, new ArrayList<Integer>());
    }

    for (int i = 0; i < prerequisites.length; i++) {
      graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }

    int[] visited = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (visited[i] == 0 && !dfs(i, graph, visited)) {
        return false;
      }
    }

    return true;
  }

  private boolean dfs(int node, HashMap<Integer, List<Integer>> graph, int[] visited) {
    if (visited[node] == 1) {
      return true;
    }

    if (visited[node] == -1) {
      return false;
    }

    visited[node] = -1;

    for (int i = 0; i < graph.get(node).size(); i++) {
      if (!dfs(graph.get(node).get(i), graph, visited)) {
        return false;
      }
    }

    visited[node] = 1;
    return true;
  }
}