package com.cihangir._00_roads_and_libraries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class RoadsAndLibrariesApp0 {

  public static void main(String[] args) throws IOException {
    run();
  }

  // Complete the roadsAndLibraries function below.
  static long roadsAndLibraries(int numberOfVertices, int c_lib, int c_road, int[][] cities) {

    Graph graph = new Graph(numberOfVertices);
    for (int[] city : cities) {
      graph.addEdge(city[0], city[1]);
    }
    boolean fixRoads = c_lib > c_road;

    long totalCost = 0L;
    boolean[] visited = new boolean[numberOfVertices+1];
    for (int i = 1; i <= numberOfVertices; i++) {
      LinkedList<Integer> queue = new LinkedList<>();
      if (!visited[i]) {
        visited[i] = true;
        totalCost = totalCost + c_lib;
        if (fixRoads) {
          queue.add(i);
        }
      }
      while (queue.size() != 0) {
        int vertex = queue.poll();
        for (int n : graph.adjLists[vertex]) {
          if (!visited[n]) {
            visited[n] = true;
            totalCost = totalCost + c_road;
            queue.add(n);
          }
        }
      }
    }
    return totalCost;
  }

  static void run() throws IOException {
    final String currentDirectory = System.getProperty("user.dir");
    final String inputPath = currentDirectory + "/src/main/resources/00/input2.txt";

    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));

    String[] nmC_libC_road = bufferedReader.readLine().split(" ");

    int numberOfVertices = Integer.parseInt(nmC_libC_road[0]);

    int m = Integer.parseInt(nmC_libC_road[1]);

    int c_lib = Integer.parseInt(nmC_libC_road[2]);

    int c_road = Integer.parseInt(nmC_libC_road[3]);

    int[][] cities = new int[m][2];

    for (int i = 0; i < m; i++) {
      String[] citiesRowItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      for (int j = 0; j < 2; j++) {
        int citiesItem = Integer.parseInt(citiesRowItems[j]);
        cities[i][j] = citiesItem;
      }
    }

    long result = roadsAndLibraries(numberOfVertices, c_lib, c_road, cities);
    System.out.println("=====" + result + "=====");
    bufferedReader.close();
  }

  static class Graph {

    private LinkedList<Integer> adjLists[];
    // Graph creation
    Graph(int vertices) {
      adjLists = new LinkedList[vertices+1];
      for (int i = 0; i <= vertices; i++) adjLists[i] = new LinkedList<>();
    }

    // Add edges
    void addEdge(int src, int dest) {
      adjLists[src].add(dest);
      adjLists[dest].add(src);
    }
  }
}
