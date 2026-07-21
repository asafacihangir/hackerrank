package com.cihangir.dictionaries_and_hashmaps._01_two_strings;

import java.util.HashSet;
import java.util.Set;

public class TwoStringsApp0 {

    public static void main(String[] args) {


        String s1 = "hello";
        String s2 = "world";

        String result = twoStrings(s1,s2);
        System.out.println(result);

    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        final Set<Character> lettersSetForS1 = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            char letter = s1.charAt(i);
            lettersSetForS1.add(letter);
        }

        String shareCommonLettersResponse = "NO";
        for (int i = 0; i < s2.length(); i++) {
            char letter = s2.charAt(i);
            if ( lettersSetForS1.contains(letter)){
                shareCommonLettersResponse =   "YES";
                break;
            }
        }

        return shareCommonLettersResponse;
    }

}
