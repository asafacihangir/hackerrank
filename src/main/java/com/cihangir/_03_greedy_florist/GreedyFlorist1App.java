package com.cihangir._03_greedy_florist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class GreedyFlorist1App {

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
    Queue<Integer> flowersQueue =
        new PriorityQueue<>(peopleCount, new ReversedComparator<Integer>());
    for (int costOfFlower : costOfFlowers) {
      flowersQueue.offer(costOfFlower);
    }

    int minumumCost = 0;
    int flowers = 0;
    while (!flowersQueue.isEmpty()) {
      int cost = flowersQueue.poll();
      int cycleCount = flowers / peopleCount;
      minumumCost += (cycleCount + 1) * cost;
      flowers++;
    }

    return minumumCost;
  }

  private static class ReversedComparator<E extends Comparable<E>> implements Comparator<E> {
    public int compare(E o1, E o2) {
      return o1.compareTo(o2) * -1;
    }
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
