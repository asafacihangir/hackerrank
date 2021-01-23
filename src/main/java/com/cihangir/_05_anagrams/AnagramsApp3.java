package com.cihangir._05_anagrams;

import java.util.Arrays;

/*****

 Method 3:

 The problem can be Done in Linear time and constant space.

 We initialize a variable say count to 0.
 Then we take the sum of all the characters of the first String and then decreasing the value of all the characters from the second String.
 If the Count value finally is 0, i.e. before performing any operation then its an anagram, else it is not.


 Time Complexity: O(N)
 Auxiliary Space: O(1)

 ******/

public class AnagramsApp3 {

  public static void main(String[] args) {
    String str1 = "geeksforgeeks";
    String str2 = "forgeeksgeeks";

    final boolean isAnagram = isAnagram(str1, str2);
    System.out.println(isAnagram);
  }

  static boolean isAnagram(String c, String d) {
    if (c.length() != d.length())
      return false;

    int count = 0;

    // Take sum of all characters of
    // first String
    for(int i = 0; i < c.length(); i++)
    {
      count = count + c.charAt(i);
    }

    // Subtract the Value of all the characters
    // of second String
    for(int i = 0; i < d.length(); i++)
    {
      count = count - d.charAt(i);
    }

    // If Count = 0 then they are anagram
    // If count > 0 or count < 0 then
    // they are not anagram
    return (count == 0);
  }
}
