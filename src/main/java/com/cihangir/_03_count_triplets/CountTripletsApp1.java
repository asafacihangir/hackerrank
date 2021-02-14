package com.cihangir._03_count_triplets;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class CountTripletsApp1 {

  public static void main(String[] args) {

    // final List<Long> arr = Stream.of(1L, 2L, 2L, 4L).collect(toList());
    // final long commonRatio = 2;

    //final List<Long> arr = Stream.of(1L, 3L, 9L, 9L, 27L, 81L).collect(toList());
    //final long commonRatio = 3;

    final List<Long> arr = Stream.of(1L,5L,5L,25L, 125L).collect(toList());
    final long commonRatio = 5;


    final long countTriplets = countTriplets(arr, commonRatio);
    System.out.println(countTriplets);
  }

  // Complete the countTriplets function below.
  static long countTriplets(List<Long> arr, long ratio) {
    // To store count of total triplets
    long ans = 0;

    final HashMap<Long, Long> secondMap = new HashMap<>();
    final HashMap<Long, Long> thirdMap = new HashMap<>();

    for (Long entry : arr) {

      ans += thirdMap.getOrDefault(entry, 0L);
      final long nextNumber = entry*ratio;


      long frequencyEntryInSecondMap = secondMap.getOrDefault(entry, 0L);
      long frequencyNextNumberInThirdMap = thirdMap.getOrDefault(nextNumber, 0L);
      thirdMap.put(nextNumber, frequencyEntryInSecondMap + frequencyNextNumberInThirdMap);


      long frequencyNextNumberInSecondMap = secondMap.getOrDefault(nextNumber, 0L);
      secondMap.put(nextNumber, frequencyNextNumberInSecondMap + 1);
    }

    return ans;
  }
}
