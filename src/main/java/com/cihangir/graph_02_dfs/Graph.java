package com.cihangir.graph_02_dfs;

import java.util.LinkedList;

public class Graph {

  private LinkedList<Integer> adjLists[];
  private boolean visited[];


  // Constructor


  // Graph creation
  Graph(int vertices) {
    adjLists = new LinkedList[vertices];
    visited = new boolean[vertices];

    for (int i = 0; i < vertices; i++)
      adjLists[i] = new LinkedList<>();
  }

  // Add edges
  void addEdge(int src, int dest) {
    adjLists[src].add(dest);
  }

  // DFS algorithm
  void DFS(int vertex) {
    visited[vertex] = true;
    System.out.print(vertex + " ");

    for (int adj : adjLists[vertex]) {
      if (!visited[adj])
        DFS(adj);
    }
  }



}
