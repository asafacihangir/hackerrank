package com.cihangir.graph_03_adjacency_list;

import java.util.ArrayList;

public class Graph {

  private final ArrayList<ArrayList<Integer>> adjMatrix;
  private final int numVertices;

  public Graph(int numVertices) {
    this.numVertices = numVertices;
    adjMatrix = new ArrayList<>(numVertices);

    for (int i = 0; i < numVertices; i++)
      adjMatrix.add(new ArrayList<>());
  }

  // Add edge
  public void addEdge(int s, int d) {
    adjMatrix.get(s).add(d);
    adjMatrix.get(d).add(s);
  }

  // Print the graph
  public void printGraph() {
    for (int i = 0; i < adjMatrix.size(); i++) {
      System.out.println("\nVertex " + i + ":");
      for (int j = 0; j < adjMatrix.get(i).size(); j++) {
        System.out.print(" -> " + adjMatrix.get(i).get(j));
      }
      System.out.println();
    }
  }
}
