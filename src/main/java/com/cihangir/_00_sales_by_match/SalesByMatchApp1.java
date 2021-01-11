package com.cihangir._00_sales_by_match;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//lipusal solution

public class SalesByMatchApp1 {


    public static void main(String[] args) throws IOException {

        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = sockMerchant(n, ar);

        System.out.println(result);
    }


    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        int numSocks = 0;
        final Map<Integer, Integer> pairs = new HashMap<>();
        for (int color : ar) {
            int count = pairs.containsKey(color) ? pairs.get(color)+1 : 1;
            pairs.put(color, count);
            if(count % 2 == 0) {
                numSocks++;
            }

        }
        return numSocks;
    }

}
