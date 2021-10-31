package com.cihangir.graph_00_bfs.example1;

public class GraphBFSApp {

  public static void main(String[] args) {

    Graph g = new Graph(8);
    g.addEdge(0,1);
    g.addEdge(0,3);
    g.addEdge(1,0);
    g.addEdge(1,5);
    g.addEdge(2,5);
    g.addEdge(3,0);
    g.addEdge(4,6);
    g.addEdge(5, 1);
    g.addEdge(5,2);
    g.addEdge(6, 4);
    g.addEdge(6, 7);
    g.addEdge(7,6);


    System.out.println("Following is Breadth First Traversal "+
        "(starting from vertex 2)");

    g.BFS(2);



  }
}
