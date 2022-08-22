package com.cihangir._02_luck_balance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LuckBalance0App {

  public static void main(String[] args) throws IOException {

    final String currentDirectory = System.getProperty("user.dir");
    final String inputPath = currentDirectory + "/src/main/resources/02/input1.txt";
    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    int n = Integer.parseInt(firstMultipleInput[0]);
    int k = Integer.parseInt(firstMultipleInput[1]);
    List<List<Integer>> contests = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String[] contestsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
      List<Integer> contestsRowItems = new ArrayList<>();

      for (int j = 0; j < 2; j++) {
        int contestsItem = Integer.parseInt(contestsRowTempItems[j]);
        contestsRowItems.add(contestsItem);
      }
      contests.add(contestsRowItems);
    }
    int result = luckBalance(k, contests);
    System.out.println(result);
  }

  /*
   * Complete the 'luckBalance' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. 2D_INTEGER_ARRAY contests
   */

  public static int luckBalance(int k, List<List<Integer>> contests) {

    List<Integer> important = new ArrayList<>();

    int luck = 0;
    for (List<Integer> contest : contests) {
      int value = contest.get(0);
      int importance = contest.get(1);

      if (importance == 0) {
        luck = luck + value;
      } else {
        important.add(value);
      }
    }
    Collections.sort(important, Comparator.reverseOrder());

    for (int i = 0; i < important.size(); i++) {
      if (i < k) {
        luck += important.get(i);
      } else {
        luck -= important.get(i);
      }
    }

    return luck;
  }
}
