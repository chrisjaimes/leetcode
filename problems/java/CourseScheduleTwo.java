class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    for(int n = 0; n < numCourses; n++) {
      adj.put(n, new ArrayList<Integer>());
    }

    for (int i = 0; i < prerequisites.length; i++) {
      adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }

    int[] incoming = new int[numCourses];
    for (int n = 0; n < numCourses; n++) {
      for (int i = 0; i < adj.get(n).size(); i++) {
        incoming[adj.get(n).get(i)]++;
      }
    }

    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < incoming.length; i++) {
      if (incoming[i] == 0) {
        queue.add(i);
      }
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int node = queue.remove();
      count++;
      for (int i = 0; i < adj.get(node).size(); i++) {
        incoming[adj.get(node).get(i)]--;
        if (incoming[adj.get(node).get(i)] == 0) {
          queue.add(adj.get(node).get(i));
        }
      }
    }
    return count == numCourses;
  }
}