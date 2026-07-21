package com.cihangir.graphs.graph_00_bfs.example2;

public class GraphBFSApp {

  public static void main(String[] args) {

    Graph g = new Graph(8);
    g.addEdge(0,1);
    g.addEdge(0,3);
    g.addEdge(1,5);
    g.addEdge(2,5);
    g.addEdge(4,6);
    g.addEdge(6, 7);

    System.out.println("Following is Breadth First Traversal "+
        "(starting from vertex 2)");

    //g.BFS(2);

    System.out.println();

    Graph g2  = new Graph(9);
    g2.addEdge(0, 3);
    g2.addEdge(0,4);
    g2.addEdge(1, 2);
    g2.addEdge(1,5);
    g2.addEdge(2,4);
    g2.addEdge(2,5);
    g2.addEdge(2,6);
    g2.addEdge(5,7);
    g2.addEdge(5,6);

    g2.printGraph();


    System.out.println("\nFollowing is Breadth First Traversal "+
        "(starting from vertex 5)");

    g2.BFS(5);




  }
}
