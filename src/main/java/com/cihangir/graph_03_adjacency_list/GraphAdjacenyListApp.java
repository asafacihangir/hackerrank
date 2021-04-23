package com.cihangir.graph_03_adjacency_list;

public class GraphAdjacenyListApp {

  public static void main(String[] args) {

    Graph graph = new Graph(5);

    // Add edges
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    graph.addEdge(1, 2);

    graph.printGraph();
  }
}
