package com.cihangir.graph_00_bfs.example3;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

public class App {


  static void example1(){
    // To store adjacency list of graph
    int n = 9;
    Graph graph = new Graph(9);
    graph.addEdge(0, 1);
    graph.addEdge(0, 7);
    graph.addEdge(1, 7);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(2, 5);
    graph.addEdge(2, 8);
    graph.addEdge(3, 4);
    graph.addEdge(3, 5);
    graph.addEdge(4, 5);
    graph.addEdge(5, 6);
    graph.addEdge(6, 7);
    graph.addEdge(7, 8);

    int u = 0;
    int v = 5;
    System.out.println(minEdgeBFS(graph, u, v, n));
  }

  static void example2(){
    // To store adjacency list of graph
    int n = 6;
    Graph graph = new Graph(6);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(1, 5);

    int u = 4;
    int v = 6;
    System.out.println(minEdgeBFS(graph, u, v, n));
  }





  public static void main(String[] args) {

    example2();
  }

  // Method for finding minimum no. of edge
  // using BFS
  static int minEdgeBFS(Graph graph, int u, int v, int n) {

    Map<Integer, LinkedList<Integer>> nodeAdjs = graph.getNodeAdjs();

    // visited[n] for keeping track of visited
    // node in BFS
    Vector<Boolean> visited = new Vector<Boolean>(n);
    Vector<Integer> distance = new Vector<Integer>(n);

    // initialize
    for (int i = 0; i <= n; i++) {
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
    return distance.get(v);
  }
}
