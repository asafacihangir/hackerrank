package com.cihangir._04_candies;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/****
 * İlk olarak, her çocuğa en az bir şeker vermek için bir liste başlatılır.
 * Soldan sağa doğru bir geçiş yaparak, eğer bir çocuğun puanı solundaki çocuktan yüksekse, ona daha fazla şeker verilir.
 * Sağdan sola doğru ikinci bir geçiş yaparak, eğer bir çocuğun puanı sağındaki çocuktan yüksekse ve önceki geçişte verilen şeker miktarı bu durumu karşılamıyorsa, şeker miktarı güncellenir.
 *
 *
 *
 */


public class Candies0App {

  public static long candies(int n, List<Integer> arr) {
    if (n == 0) return 0;

    // Her çocuğa en az 1 şeker vermek için bir liste başlatılır
    int[] candies = new int[n];
    Arrays.fill(candies, 1);

    // Soldan sağa doğru geçiş
    for (int i = 1; i < n; i++) {
      if (arr.get(i) > arr.get(i - 1)) {
        candies[i] = candies[i - 1] + 1;
      }
    }

    // Sağdan sola doğru geçiş
    for (int i = n - 2; i >= 0; i--) {
      if (arr.get(i) > arr.get(i + 1)) {
        candies[i] = Math.max(candies[i], candies[i + 1] + 1);
      }
    }

    // Toplam şeker miktarını hesapla
    long totalCandies = 0;
    for (int candy : candies) {
      totalCandies += candy;
    }

    return totalCandies;
  }


  public static void main(String[] args) throws IOException {
    final String inputPath = getPath("04", "input", "2");

    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter("./data/04/output01.txt"));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

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

    long result = candies(n, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }

  static String getPath(String problemNumber, String fileType, String fileNumber) {
    final String currentDirectory = System.getProperty("user.dir");
    return currentDirectory
        + String.format("/src/main/resources/%s/%s%s.txt", problemNumber, fileType, fileNumber);
  }


}

