package com.cihangir.graph_00_bfs.example1;

import java.util.LinkedList;

public class Graph {

  private final int V;   // No. of vertices
  private final LinkedList<Integer>[] adj; //Adjacency Lists

  // Constructor
  Graph(int v)
  {
    V = v;
    adj = new LinkedList[v];
    for (int i=0; i<v; ++i)
      adj[i] = new LinkedList();
  }


  // Function to add an edge into the graph
  void addEdge(int v,int w)
  {
    adj[v].add(w);
  }

  // prints BFS traversal from a given source s
  void BFS(int s)
  {
    // Mark all the vertices as not visited(By default
    // set as false)
    boolean[] visited = new boolean[V];

    // Create a queue for BFS
    LinkedList<Integer> queue = new LinkedList<>();

    // Mark the current node as visited and enqueue it
    visited[s]=true;
    queue.add(s);

    while (queue.size() != 0)
    {
      // Dequeue a vertex from queue and print it
      s = queue.poll();
      System.out.print(s+" ");

      // Get all adjacent vertices of the dequeued vertex s
      // If a adjacent has not been visited, then mark it
      // visited and enqueue it
      for (int n : adj[s]) {
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }



}
