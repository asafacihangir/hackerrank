package com.cihangir._01_shortest_reach_in_a_graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

class Graph {
  private final int V; // No. of vertices
  private Map<Integer, LinkedList<Integer>> nodeAdjs = new HashMap<>();

  Graph(int v) {
    V = v;
    for (int i = 0; i < v; i++) {
      nodeAdjs.put(i, new LinkedList<>());
    }
  }

  public Map<Integer, LinkedList<Integer>> getNodeAdjs() {
    return nodeAdjs;
  }

  void add_edge(int v, int w) {
    addConnection(v, w);
    addConnection(w, v);
  }

  // Function to add an edge into the graph
  private void addConnection(int v, int w) {
    LinkedList<Integer> adjs = nodeAdjs.getOrDefault(v, new LinkedList<>());
    adjs.add(w);
    nodeAdjs.put(v, adjs);
  }

  Vector<Integer> minEdgeBFS(int u, int v, int n) {

    // visited[n] for keeping track of visited
    // node in BFS
    Vector<Boolean> visited = new Vector<Boolean>(n);
    Vector<Integer> distance = new Vector<Integer>(n);

    // initialize
    for (int i = 0; i < n; i++) {
      visited.addElement(false);
      distance.addElement(0);
    }

    // queue to do BFS.
    Queue<Integer> Q = new LinkedList<>();
    distance.setElementAt(0, u);
    visited.setElementAt(true, u);
    Q.add(u);

    while (!Q.isEmpty()) {
      int currentNode = Q.poll();

      LinkedList<Integer> adjNodes = nodeAdjs.get(currentNode);

      for (Integer node : adjNodes) {
        if (visited.elementAt(node)) continue;

        // update distance for i
        distance.setElementAt(distance.get(currentNode) + 1, node);
        visited.setElementAt(true, node);
        Q.add(node);
      }
    }
    return distance;
  }

  public int[] shortestReach(int startId) { // 0 indexed
    int[] distances = new int[V];
    Arrays.fill(distances, -1); // O(n) space.
    Queue<Integer> que = new LinkedList<>();

    que.add(startId);
    distances[startId] = 0;
    HashSet<Integer> seen = new HashSet<>();

    seen.add(startId);
    while (!que.isEmpty()) { // Standard BFS loop.
      Integer curr = que.poll();
      for (int node : nodeAdjs.get(curr)) {
        if (!seen.contains(node)) {
          que.offer(node);
          // Right place to add the visited set.
          seen.add(node);
          // keep on increasing distance level by level.
          distances[node] = distances[curr] + 6;
        }
      }
    }
    return distances;
  }
}

public class ShortestReachInGraphApp0 {

  public static void main(String[] args) throws IOException {

    run();
  }

  static void run() throws IOException {
    final String currentDirectory = System.getProperty("user.dir");
    final String inputPath = currentDirectory + "/src/main/resources/01/input03.txt";

    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));

    int numberOfQueries = Integer.parseInt(bufferedReader.readLine());
    for (int i = 0; i < numberOfQueries; i++) {
      String[] nm_node_edge = bufferedReader.readLine().split(" ");
      int numberOfVertices = Integer.parseInt(nm_node_edge[0]);
      int numberOfEdges = Integer.parseInt(nm_node_edge[1]);

      Graph graph = new Graph(numberOfVertices);
      for (int j = 0; j < numberOfEdges; j++) {
        String[] fromToEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int source = Integer.parseInt(fromToEdges[0]) - 1;
        int destination = Integer.parseInt(fromToEdges[1]) - 1;
        graph.add_edge(source, destination);
      }

      int startingNode = Integer.parseInt(bufferedReader.readLine()) - 1;
      int[] distances = graph.shortestReach(startingNode);
      for (int k = 0; k < distances.length; k++) {
        if (k != startingNode) System.out.print(distances[k] + " ");
      }
      System.out.println();
    }

    bufferedReader.close();
  }
}
