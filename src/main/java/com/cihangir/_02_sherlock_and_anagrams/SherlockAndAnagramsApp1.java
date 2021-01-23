package com.cihangir._02_sherlock_and_anagrams;

import java.util.ArrayList;
import java.util.List;

//EunHyeJung solution
public class SherlockAndAnagramsApp1 {

  public static void main(String[] args) {

    String str = "cdcd";
    final int anagrammaticPairCount = sherlockAndAnagrams(str);
    System.out.println(anagrammaticPairCount);
  }

  static int sherlockAndAnagrams(String s) {
    int cnt = 0;
    for (int i = 1, n = s.length(); i < n; i++) {
      List<String> subsetList = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if (i + j <= n) {
          subsetList.add(s.substring(j, i + j));
        }
      }

      for (int k = 0, size = subsetList.size(); k < size; k++) {
        for (int l = k + 1; l < size; l++) {
          if (isAnagram(subsetList.get(k), subsetList.get(l))) {
            cnt++;
          }
        }
      }
    }

    return cnt;
  }

  static boolean isAnagram(String s1, String s2) {
    final int ALPHABET_CNT = 26;

    char[] chCnt1 = new char[ALPHABET_CNT];
    char[] chCnt2 = new char[ALPHABET_CNT];

    for (int i = 0, n = s1.length(); i < n; i++) {
      System.out.println(s1.charAt(i)-97);
      chCnt1[s1.charAt(i) - 97] += 1;
      chCnt2[s2.charAt(i) - 97] += 1;
    }

    for (int i = 0; i < ALPHABET_CNT; i++) {
      if (chCnt1[i] != chCnt2[i]) {
        return false;
      }
    }

    return true;
  }
}
