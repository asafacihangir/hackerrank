package com.cihangir.dictionaries_and_hashmaps._05_anagrams;

import java.util.Arrays;


//https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/

/****
 *
 *
 * Method 1 (Use Sorting)
 *
 * 1.Sort both strings
 * 2.Compare the sorted strings
 *
 * Time Complexity: O(nLogn)
 */

public class AnagramsApp0 {

  public static void main(String[] args) {

    String str1 = "geeksforgeeks";
    String str2 = "forgeeksgeeks";

    final boolean isAnagram = isAnagram(str1.toCharArray(), str2.toCharArray());
    System.out.println(isAnagram);
  }


  static boolean isAnagram(char[] str1, char[] str2)
  {
    // Get lenghts of both strings
    int n1 = str1.length;
    int n2 = str2.length;

    // If length of both strings is not same,
    // then they cannot be anagram
    if (n1 != n2)
      return false;

    // Sort both strings
    Arrays.sort(str1);
    Arrays.sort(str2);

    // Compare sorted strings
    for (int i = 0; i < n1; i++)
      if (str1[i] != str2[i])
        return false;

    return true;
  }

}
