package com.cihangir._01_min_absolute_diff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MinAbsoluteDiffApp0 {

  public static void main(String[] args) throws IOException {

    final String currentDirectory = System.getProperty("user.dir");
    final String inputPath = currentDirectory + "/src/main/resources/01/input1.txt";

    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
    int numberOfElements = Integer.parseInt(bufferedReader.readLine().trim());

    String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    List<Integer> arr = new ArrayList<>();
    for (int i = 0; i < numberOfElements; i++) {
      int arrItem = Integer.parseInt(arrTemp[i]);
      arr.add(arrItem);
    }

    int result = minimumAbsoluteDifference(arr);
    System.out.println(result);
  }

  public static int minimumAbsoluteDifference(List<Integer> arr) {

    final List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());



    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < sorted.size()-1; i++) {
      int diff = Math.abs(Math.subtractExact(sorted.get(i), sorted.get(i+1)));

      if (diff < minDiff) {
        minDiff = diff;
      }
    }

    return minDiff;
  }
}
