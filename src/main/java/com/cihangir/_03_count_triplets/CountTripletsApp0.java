package com.cihangir._03_count_triplets;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public class CountTripletsApp0 {

  public static void main(String[] args) {

    // final List<Long> arr = Stream.of(1L, 2L, 2L, 4L).collect(toList());
    //final long commonRatio = 2;

    //final List<Long> arr = Stream.of(1L, 3L, 9L, 9L, 27L, 81L).collect(toList());
    //final long commonRatio = 3;

    final List<Long> arr = Stream.of(1L,5L,5L,25L, 125L).collect(toList());
    final long commonRatio = 5;

    final long countTriplets = countTriplets(arr, commonRatio);
    System.out.println(countTriplets);



  }

  // Complete the countTriplets function below.
  static long countTriplets(List<Long> arr, long r) {
    long count = 0L;
    for (int i = 0; i + 2 < arr.size(); i++) {
      for (int j = i + 1; j + 1 < arr.size(); j++) {
        if ( arr.get(i)*r != arr.get(j)){
          continue;
        }
        for (int k = j + 1; k < arr.size(); k++) {
          if (arr.get(j) * r == arr.get(k)) {
            count++;
          }
        }
      }
    }

    return count;
  }
}
