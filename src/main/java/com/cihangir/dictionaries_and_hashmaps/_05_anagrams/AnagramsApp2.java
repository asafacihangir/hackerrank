package com.cihangir.dictionaries_and_hashmaps._05_anagrams;

import java.util.Arrays;

/*****

 Method 3:

 The above implementation can be further to use only one count array instead of two.
 We can increment the value in count array for characters in str1 and decrement for characters in str2.
 Finally, if all count values are 0, then the two strings are anagram of each other.
 Thanks to Ace for suggesting this optimization.

 Time Complexity: O(n)

 ******/

public class AnagramsApp2 {

  public static void main(String[] args) {
    String str1 = "geeksforgeeks";
    String str2 = "forgeeksgeeks";

    final boolean isAnagram = isAnagram(str1.toCharArray(), str2.toCharArray());
    System.out.println(isAnagram);
  }

  static boolean isAnagram(char[] str1, char[] str2) {

    final int NO_OF_CHARS = 256;

    // Create 2 count arrays and initialize
    // all values as 0
    int[] count1 = new int[NO_OF_CHARS];
    Arrays.fill(count1, 0);
    int[] count2 = new int[NO_OF_CHARS];
    Arrays.fill(count2, 0);
    int i;


    // For each character in input strings,
    // increment count in the corresponding
    // count array
    for (i = 0; i < str1.length && i < str2.length; i++) {
      count1[str1[i]]++;
      count2[str2[i]]++;
    }

    // If both strings are of different length.
    // Removing this condition will make the program
    // fail for strings like "aaca" and "aca"
    if (str1.length != str2.length) return false;

    // Compare count arrays
    for (i = 0; i < NO_OF_CHARS; i++) if (count1[i] != count2[i]) return false;

    return true;
  }
}
