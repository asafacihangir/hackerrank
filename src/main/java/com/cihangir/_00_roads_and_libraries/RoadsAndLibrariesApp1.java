package com.cihangir._00_roads_and_libraries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class RoadsAndLibrariesApp1 {

  public static void main(String[] args) throws IOException {

    final String currentDirectory = System.getProperty("user.dir");
    final String inputPath = currentDirectory + "/src/main/resources/input2.txt";

    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));

    String[] nmC_libC_road = bufferedReader.readLine().split(" ");
    int numberOfVertices = Integer.parseInt(nmC_libC_road[0]); // number of cities
    int m = Integer.parseInt(nmC_libC_road[1]); // number of roads
    int c_lib = Integer.parseInt(nmC_libC_road[2]); // cost to repair library
    int c_road = Integer.parseInt(nmC_libC_road[3]); // cost to repair road

    HashMap<String, HashSet<Integer>> graph = new HashMap<>(numberOfVertices);
    for (int i = 0; i < m; i++) {
      String[] citiesRowItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      int city_1 = Integer.parseInt(citiesRowItems[0]);
      int city_2 = Integer.parseInt(citiesRowItems[1]);

      addConnection(graph, city_1, city_2);
      addConnection(graph, city_2, city_1);
    }

    boolean fixRoads = c_lib > c_road;
    BigInteger libraryCost = BigInteger.valueOf(c_lib);
    BigInteger roadCost = BigInteger.valueOf(c_road);
    BigInteger totalCost = new BigInteger("0");

    HashSet<Integer> visitedCities = new HashSet<Integer>(numberOfVertices);

    for (Map.Entry<String, HashSet<Integer>> entry : graph.entrySet()) {
      Stack<Integer> searchList = new Stack<Integer>();
      Integer startCity = Integer.valueOf(entry.getKey());
      if (!visitedCities.contains(startCity)) {
        visitedCities.add(startCity);
        totalCost = totalCost.add(libraryCost);
        if (fixRoads) {
          for (Integer nextCity : entry.getValue()) {
            searchList.push(nextCity);
          }
        }
      }
      while (!searchList.empty()) {
        Integer thisCity = searchList.pop();
        if (!visitedCities.contains(thisCity)) {
          visitedCities.add(thisCity);
          totalCost = totalCost.add(roadCost);
          HashSet<Integer> adjacentCities = graph.get(String.valueOf(thisCity));
          for (Integer nextCity : adjacentCities) {
            searchList.push(nextCity);
          }
        }
      }
    }

    BigInteger numLonelyCities = BigInteger.valueOf(numberOfVertices - visitedCities.size());
    totalCost = totalCost.add(numLonelyCities.multiply(libraryCost));

    System.out.println(totalCost);
  }

  private static void addConnection(
      HashMap<String, HashSet<Integer>> graph, int fromCity, int toCity) {
    HashSet<Integer> adjacentCities = graph.get(String.valueOf(fromCity));
    if (adjacentCities == null) {
      adjacentCities = new HashSet<>();
      graph.put(String.valueOf(fromCity), adjacentCities);
    }
    adjacentCities.add(toCity);
  }
}
