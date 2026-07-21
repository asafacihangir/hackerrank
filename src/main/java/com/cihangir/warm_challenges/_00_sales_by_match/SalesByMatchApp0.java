package com.cihangir.warm_challenges._00_sales_by_match;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SalesByMatchApp0 {


    public static void main(String[] args) throws IOException {

        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = sockMerchant(n, ar);

        System.out.println(result);
    }


    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        int countOfSockPair = 0;
        final Map<Integer, Integer> colorFrequencyMap = new HashMap<>();
        for (int sockColor : ar) {
            if (colorFrequencyMap.containsKey(sockColor)) {
                final int colorFrequency = colorFrequencyMap.get(sockColor);
                final int newColorFrequency = colorFrequency + 1;
                if (  newColorFrequency % 2 == 0){
                    countOfSockPair++;
                    colorFrequencyMap.put(sockColor, 0);
                }else {
                    colorFrequencyMap.put(sockColor, newColorFrequency);
                }
            } else {
                colorFrequencyMap.put(sockColor, 1);
            }
        }
        return countOfSockPair;
    }

    /*
    Map<Integer, Integer> map = new HashMap<>();
        for (int sockColor : ar) {
        if (map.containsKey(sockColor)) {
            int frequency = map.get(sockColor);
            if (frequency == 1) {
                count++;
                map.put(sockColor, 0);
            } else {
                map.put(sockColor, ++frequency);
            }
        } else {
            map.put(sockColor, 1);
        }
    }*/

}
