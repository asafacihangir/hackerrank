package com.cihangir.dictionaries_and_hashmaps._04_frequency_queries;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrequencyQueriesApp0 {

  public static void main(String[] args) throws IOException {

    List<List<Integer>> queries = getInputsFromFile();

    List<Integer> ans = freqQuery(queries);

    System.out.println(ans);
  }

  static List<List<Integer>> getInputsFromFile() throws IOException {
    final String currentDirectory = System.getProperty("user.dir");
    final String inputPath =
        currentDirectory
            + "/src/main/java/com/cihangir/dictionaries_and_hashmaps/_04_frequency_queries/testdata/input2.txt";

    BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
    int q = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> queries = new ArrayList<>();
    IntStream.range(0, q)
        .forEach(
            i -> {
              try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    return queries;
  }

  // Complete the freqQuery function below.
  static List<Integer> freqQuery(List<List<Integer>> queries) {

    final int operationInsert = 1;
    final int operationDelete = 2;
    final int operationFrequencyCheck = 3;

    final Map<Integer, Integer> numberFrequencyMap = new HashMap<>();
    int[] quantities = new int[queries.size() + 1];

    final List<Integer> outputArray = new ArrayList<>();

    queries.forEach(
        entry -> {
          int frequencyNumber;
          int dataElement = entry.get(1);

          switch (entry.get(0)) {
            case operationInsert:
              frequencyNumber = numberFrequencyMap.getOrDefault(dataElement, 0);
              numberFrequencyMap.put(dataElement, frequencyNumber + 1);

              // process qt
              quantities[frequencyNumber]--;
              quantities[frequencyNumber + 1]++;

              break;

            case operationDelete:
              frequencyNumber = numberFrequencyMap.getOrDefault(dataElement, 0);
              if (frequencyNumber - 1 > 0) {
                numberFrequencyMap.put(dataElement, frequencyNumber - 1);
              } else {
                numberFrequencyMap.remove(dataElement);
              }


              if ( frequencyNumber != 0){
                quantities[frequencyNumber]--;
                quantities[frequencyNumber - 1]++;
              }

              break;

            case operationFrequencyCheck:
              if (dataElement >= quantities.length) outputArray.add(0);
              else outputArray.add(quantities[dataElement] > 0 ? 1 : 0);

              break;

            default:
              throw new IllegalArgumentException(
                  "Invalid Operation.Please input correct operation type!");
          }
        });

    return outputArray;
  }
}
