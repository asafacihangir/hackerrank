package com.cihangir.greedy_algorithms._04_max_min;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


/*****
 *
 *
 *
 *
 *
 */

public class MaxMin0App {



  public static void main(String[] args) throws IOException {


    final String inputPath = getPath("0");
    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));

    int n = Integer.parseInt(bufferedReader.readLine().trim());
    int k = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
          try {
            return bufferedReader.readLine().replaceAll("\\s+$", "");
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    int result = maxMin(k, arr);

    System.out.println("Result: " + result);

    bufferedReader.close();

  }

  public static int maxMinV1(int k, List<Integer> arr) {
    arr.sort(Integer::compareTo);
    if (arr.size() < k) {
      return 0;
    }

    int unfairness = Integer.MAX_VALUE;
    for (int i = 0; i <= arr.size() - k; i++) {
      List<Integer> subArray = new ArrayList<>();
      for (int j = i; j < i + k; j++) {
        subArray.add(arr.get(j));
      }
      int diff = Math.abs(subArray.get(0) - subArray.get(subArray.size() - 1));
      if (diff < unfairness) {
        unfairness = diff;
      }
    }

    return unfairness;
  }


  public static int maxMin(int k, List<Integer> arr) {
    arr.sort(Integer::compareTo);
    if (arr.size() < k) {
      return 0;
    }

    int unfairness = Integer.MAX_VALUE;
    for (int i = 0; i <= arr.size() - k; i++) {
      int diff = arr.get(i + k - 1) - arr.get(i);
      unfairness = Math.min(unfairness, diff);
    }

    return unfairness;
  }


  static String getPath(String fileNumber) {
    final String currentDirectory = System.getProperty("user.dir");
    return currentDirectory
        + String.format(
            "/src/main/java/com/cihangir/greedy_algorithms/_04_max_min/testdata/input%s.txt",
            fileNumber);
  }


}
