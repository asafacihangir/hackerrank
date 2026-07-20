package com.cihangir.dynamic_programming._01_maxarraysum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MaxArraySumApp0 {

  // Complete the maxSubsetSum function below.
  static int maxSubsetSum(int[] arr) {

    int length = arr.length;
    if (length == 0) return 0;
    if (length == 1) return Math.max(0, arr[0]);

    int[] dp = new int[length];

    dp[0] = Math.max(0, arr[0]);
    dp[1] = Math.max(dp[0], arr[1]);

    for (int i = 2; i < length; i++) {
      dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
    }

    return dp[length - 1];
  }



  public static void main(String[] args) throws IOException {
    final String currentDirectory = System.getProperty("user.dir");
    final String inputPath = currentDirectory
        + "/src/main/java/com/cihangir/dynamic_programming/_01_maxarraysum/testdata/input2.txt";

    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));

    int arraySize = Integer.parseInt(bufferedReader.readLine());
    String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int[] arr = new int[arraySize];
    for (int i = 0; i < arraySize; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int res = maxSubsetSum(arr);
    System.out.println(res);
  }
}
