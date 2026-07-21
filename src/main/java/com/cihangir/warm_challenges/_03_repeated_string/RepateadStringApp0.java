package com.cihangir.warm_challenges._03_repeated_string;

public class RepateadStringApp0 {

    public static void main(String[] args) {

        /*
        String s = "abcac";
        long n = 10L;*/


        /*
        String s = "a";
        long n = 1000000000000L;*/

        String s = "aba";
        long n = 10L;


        long result = repeatedString(s, n);
        System.out.println(result);
    }


    // Complete the repeatedString function below.
    static long repeatedString(String repeatedString, long targetedRepeatedStringLength) {

        controlEdgeNumberOfCharactersForTargetedStringLength(targetedRepeatedStringLength);

        final int lengthOfRepeatedString = repeatedString.length();
        controlEdgeLengthForLengthOfRepeatedString(lengthOfRepeatedString);
        
        final char specialLetterForSearch = 'a';
        long frequencyOfSpecialLetter = 0;
        long frequencyOfSpecialLetterAtPoint = 0L;
        
        long repeatedCount = targetedRepeatedStringLength / lengthOfRepeatedString;
        long remainderStringLength = targetedRepeatedStringLength % lengthOfRepeatedString;

        for (int i = 0; i < lengthOfRepeatedString; i++) {
            if (repeatedString.charAt(i) == specialLetterForSearch) {
                frequencyOfSpecialLetter++;
                if (i < remainderStringLength) {
                    frequencyOfSpecialLetterAtPoint++;
                }
            }
        }

        return (frequencyOfSpecialLetter * repeatedCount) + frequencyOfSpecialLetterAtPoint;
    }

    private static void controlEdgeNumberOfCharactersForTargetedStringLength(long targetedRepeatedStringLength) {
        final long minNumberOfCharecter = 1L;
        final long maxNumberOfCharecter = (long) Math.pow(10, 12);

        if (targetedRepeatedStringLength < minNumberOfCharecter || targetedRepeatedStringLength > maxNumberOfCharecter) {
            throw new IllegalArgumentException("The number of characters to consider is must be " + minNumberOfCharecter + " and " + maxNumberOfCharecter);
        }
    }

    private static void controlEdgeLengthForLengthOfRepeatedString(int lengthOfRepeatedString) {
        final int minLengthOfRepeatedString = 1;
        final int maxLengthOfRepeatedString = 100;

        if (lengthOfRepeatedString < minLengthOfRepeatedString || lengthOfRepeatedString > maxLengthOfRepeatedString) {
            throw new IllegalArgumentException("The max length for repeated string to consider is must be " + minLengthOfRepeatedString + " and " + maxLengthOfRepeatedString);
        }
    }

}
