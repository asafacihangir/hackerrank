package com.cihangir._02_sherlock_and_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SherlockAndAnagramsApp0 {

    public static void main(String[] args) {

        String str = "cdcd";
        final int anagrammaticPairCount = sherlockAndAnagrams(str);
        System.out.println(anagrammaticPairCount);
    }


    static int sherlockAndAnagrams(String str) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                substrings.add(str.substring(i, j));
            }
        }


        int anagrammaticPairCount = 0;
        for (int i = 0; i < substrings.size(); i++) {
            for (int j = i + 1; j < substrings.size(); j++)
                if (isAnagram(substrings.get(i), substrings.get(j)))
                    anagrammaticPairCount++;

        }

        return anagrammaticPairCount;
    }


     static boolean isAnagram(String s1, String s2) {

        final int s1Length = s1.length();
        final int s2Length = s2.length();

        if ( s1Length != s2Length ){
            return false;
        }

        Map<Character, Integer> letterFrequencyMap = new HashMap<>();
        for (int i = 0; i < s1Length; i++) {
            char letter = s1.charAt(i);
            int count = letterFrequencyMap.containsKey(letter) ? letterFrequencyMap.get(letter) + 1 : 1;
            letterFrequencyMap.put(letter, count);
        }

        boolean isAnagram = true;
        for (int i = 0; i < s2Length; i++) {
            char letter = s2.charAt(i);
            if (letterFrequencyMap.containsKey(letter)) {
                int letterFrequency = letterFrequencyMap.get(letter);
                if (letterFrequency <= 0) {
                    isAnagram = false;
                    break;
                }else {
                    letterFrequencyMap.put(letter, letterFrequency - 1);
                }
            } else {
                isAnagram = false;
                break;
            }
        }
        return isAnagram;
    }

}
