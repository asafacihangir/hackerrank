package com.cihangir.graphs.graph_02_dfs;


public class GraphDFSApp {

  public static void main(String[] args) {

    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 3);

    System.out.println("Following is Depth First Traversal");

    g.DFS(2);



  }
}
