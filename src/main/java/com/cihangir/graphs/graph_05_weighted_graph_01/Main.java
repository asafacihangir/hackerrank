package com.cihangir.graphs.graph_05_weighted_graph_01;

public class Main {

  public static void main(String[] args) {

    Graph graph = new Graph();
    graph.addEdge(0, 1, 4);
    graph.addEdge(0, 2, 3);
    graph.addEdge(1, 3, 2);
    graph.addEdge(1, 2, 5);
    graph.addEdge(2, 3, 7);
    graph.addEdge(3, 4, 2);
    graph.addEdge(4, 0, 4);
    graph.addEdge(4, 1, 4);
    graph.addEdge(4, 5, 6);
    graph.printGraph();


  }
}
