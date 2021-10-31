package com.cihangir.graph_00_bfs.example3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

  private final int V; // No. of vertices
  private final Map<Integer, LinkedList<Integer>> nodeAdjs = new HashMap<>();

  Graph(int v) {
    V = v;
    for (int i = 1; i <= v; i++) {
      nodeAdjs.put(i, new LinkedList<>());
    }
  }

  public Map<Integer, LinkedList<Integer>> getNodeAdjs() {
    return nodeAdjs;
  }

  void addEdge(int v, int w) {
    addConnection(v, w);
    addConnection(w, v);
  }

  // Function to add an edge into the graph
  private void addConnection(int v, int w) {
    LinkedList<Integer> adjs = nodeAdjs.getOrDefault(v, new LinkedList<>());
    adjs.add(w);
    nodeAdjs.put(v, adjs);
  }

  public void printGraph() {
    nodeAdjs.forEach(
        (node, adjs) -> {
          for (Integer adj : adjs) {
            System.out.println("vertex-" + node + " is connected to " + adj);
          }
        });
  }

  // prints BFS traversal from a given source s
  void BFS(int s) {
    // Mark all the vertices as not visited(By default
    // set as false)
    boolean[] visited = new boolean[V];

    // Create a queue for BFS
    LinkedList<Integer> queue = new LinkedList<>();

    // Mark the current node as visited and enqueue it
    visited[s] = true;
    queue.add(s);

    while (queue.size() != 0) {
      // Dequeue a vertex from queue and print it
      s = queue.poll();
      System.out.print(s + " ");

      // Get all adjacent vertices of the dequeued vertex s
      // If a adjacent has not been visited, then mark it
      // visited and enqueue it
      for (int n : nodeAdjs.get(s)) {
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }
}
