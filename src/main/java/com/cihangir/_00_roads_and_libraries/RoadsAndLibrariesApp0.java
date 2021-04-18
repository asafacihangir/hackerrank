package com.cihangir._00_roads_and_libraries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoadsAndLibrariesApp0 {

  public static void main(String[] args) throws IOException {

    final int c_lib = 2;
    final int c_road = 5;
    final int cityCount = 6;

    int[][] cities = getInputsFromFile(cityCount);

    final long minimalCost = roadsAndLibraries(cityCount, c_lib, c_road, cities);



  }


  // Complete the roadsAndLibraries function below.
  static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

     for ( int i=0; i<cities.length; i++){


     }


    return 0L;
  }


  static int[][] getInputsFromFile(int m) throws IOException {
    final String currentDirectory = System.getProperty("user.dir");
    final String inputPath = currentDirectory + "/src/main/resources/frequency-queries-input2.txt";

    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
    int q = Integer.parseInt(bufferedReader.readLine().trim());

    int[][] cities = new int[m][2];

    for (int i = 0; i < m; i++) {
      String[] citiesRowItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
      for (int j = 0; j < 2; j++) {
        int citiesItem = Integer.parseInt(citiesRowItems[j]);
        cities[i][j] = citiesItem;
      }
    }

    bufferedReader.close();
    return cities;
  }


}
