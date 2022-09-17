package com.cihangir._03_greedy_florist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class GreedyFlorist0App {

  public static void main(String[] args) throws IOException {

    final String fileNumber = "4";
    final String inputPath = getPath("input", fileNumber);

    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    int numberOfFlowers = Integer.parseInt(firstMultipleInput[0]);
    int numberOfPeople = Integer.parseInt(firstMultipleInput[1]);

    int[] costOfFlowers = new int[numberOfFlowers];
    String[] cItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    for (int i = 0; i < numberOfFlowers; i++) {
      int cItem = Integer.parseInt(cItems[i]);
      costOfFlowers[i] = cItem;
    }
    int result = getMinimumCost(numberOfPeople, costOfFlowers);
    final int systemResult = getResult(fileNumber);

    System.out.println(result);
    System.out.println(systemResult);
  }

  // Complete the getMinimumCost function below.
  static int getMinimumCost(int peopleCount, int[] costOfFlowers) {
    int flowerCount = costOfFlowers.length;
    int minCost = 0;
    if (peopleCount == flowerCount) {
      final int[] flowerCostsInDesc =
          IntStream.of(costOfFlowers)
              .boxed()
              .sorted(Comparator.reverseOrder())
              .mapToInt(i -> i)
              .toArray();
      for (int flowerPrice : flowerCostsInDesc) {
        minCost += flowerPrice;
      }
    } else if (peopleCount < flowerCount) {
      final int[] flowerCostsInDesc =
          IntStream.of(costOfFlowers)
              .boxed()
              .sorted(Comparator.reverseOrder())
              .mapToInt(i -> i)
              .toArray();

      int seriesCount = 0;
      int cycleCounter = 1;

      for (int cost : flowerCostsInDesc) {
        if (cycleCounter % peopleCount == 0) {
          cycleCounter = 1;
          minCost += cost * (1 + seriesCount);
          seriesCount++;
        } else {
          cycleCounter++;
          minCost += cost * (1 + seriesCount);
        }
      }
    } else {
      Arrays.sort(costOfFlowers);
      for (int i = 0; i < peopleCount; i++) {
        minCost += costOfFlowers[i];
      }
    }

    return minCost;
  }

  static String getPath(String fileType, String fileNumber) {
    final String problemNumber = "03";
    final String currentDirectory = System.getProperty("user.dir");
    return currentDirectory
        + String.format("/src/main/resources/%s/%s%s.txt", problemNumber, fileType, fileNumber);
  }

  static int getResult(String fileNumber) throws IOException {
    final String outputPath = getPath("output", fileNumber);
    BufferedReader bufferedReader = new BufferedReader(new FileReader(outputPath));
    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    return Integer.parseInt(firstMultipleInput[0]);
  }
}
