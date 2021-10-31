package com.cihangir.graph_05_weighted_graph_01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

  private Map<Integer, LinkedList<Edge>> nodeEdges = new HashMap<>();

  public void addEdge(int source, int destination, int weight) {
    Edge edge = new Edge(source, destination, weight);
    LinkedList<Edge> edges = nodeEdges.getOrDefault(source, new LinkedList<>());
    edges.add(edge);
    nodeEdges.put(source, edges);
  }

  public void printGraph() {
    nodeEdges.forEach(
        (node, edges) -> {
          for (Edge edge : edges) {
            System.out.println(
                "vertex-"
                    + node
                    + " is connected to "
                    + edge.getDestination()
                    + " with weight "
                    + edge.getWeight());
          }
        });
  }
}
