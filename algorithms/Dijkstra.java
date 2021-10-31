package algorithms;

import java.util.PriorityQueue;

public class Dijkstra {
  int[][] matrix = new int[10][10];
  class Vertex implements Comparable<Vertex> {
    int id, distance;
    Vertex(int id, int distance) {
      this.id = id;
      this.distance = distance;
    }

    public int compareTo(Vertex v) {
      return this.distance - v.distance;
    }
  }

  public void dijkstra(int source) {
    int[] distances = new int[matrix.length];
    boolean[] visited = new boolean[matrix.length];
    int visitedVertices = 0;

    PriorityQueue<Vertex> minHeap = new PriorityQueue<>();
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[source] = 0;

    for (int i = 0; i < matrix.length; i++) {
      minHeap.add(new Vertex(i, distances[i]));
    }

    while (!minHeap.isEmpty() && visitedVertices < matrix.length) {
      Vertex v = minHeap.poll();
      if (visited[v.id]) { 
        continue;
      }

      visited[v.id] = true;
      visitedVertices++;

      for (int i = 0; i < matrix.length; i++) {
        if (matrix[v.id][i] > 0 && !visited[i] && distances[v.id] + matrix[v.id][i] < distances[i]) {
          distances[i] = distances[v.id] + matrix[v.id][i];
          minHeap.add(new Vertex(i, distances[i]));
        }
      }
    }
  }
}
