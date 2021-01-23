package com.cihangir._05_anagrams;

import java.util.Arrays;

/*****
Method 2 (Count characters)

 This method assumes that the set of possible characters in both strings is small. In the following implementation,
 it is assumed that the characters are stored using 8 bit and there can be 256 possible characters.

    Create count arrays of size 256 for both strings. Initialize all values in count arrays as 0.
    Iterate through every character of both strings and increment the count of character in the corresponding count arrays.
    Compare count arrays. If both count arrays are same, then return true.




 ******/

public class AnagramsApp1 {

  public static void main(String[] args) {
    String str1 = "geeksforgeeks";
    String str2 = "forgeeksgeeks";

    final boolean isAnagram = isAnagram(str1.toCharArray(), str2.toCharArray());
    System.out.println(isAnagram);
  }

  static boolean isAnagram(char[] str1, char[] str2) {
    final int NO_OF_CHARS = 256;

    // Create a count array and initialize
    // all values as 0
    int[] count = new int[NO_OF_CHARS];
    int i;

    // For each character in input strings,
    // increment count in the corresponding
    // count array
    for(i = 0; i < str1.length; i++)
    {
      count[str1[i] - 'a']++;
      count[str2[i] - 'a']--;
    }

    // If both strings are of different
    // length. Removing this condition
    // will make the program fail for
    // strings like "aaca" and "aca"
    if (str1.length != str2.length)
      return false;

    // See if there is any non-zero
    // value in count array
    for(i = 0; i < NO_OF_CHARS; i++)
      if (count[i] != 0)
      {
        return false;
      }
    return true;
  }
}
