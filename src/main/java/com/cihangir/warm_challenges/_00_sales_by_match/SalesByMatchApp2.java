package com.cihangir.warm_challenges._00_sales_by_match;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//lipusal solution

public class SalesByMatchApp2 {


    public static void main(String[] args) throws IOException {

        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = sockMerchant(n, ar);

        System.out.println(result);
    }


    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int numSocks = 0;
        Set<Integer> unmatched = new HashSet<>();
        for (int color : ar) {
            if (unmatched.contains(color)) {
                unmatched.remove(color);
                ++numSocks;
            }
            else {
                unmatched.add(color);
            }

        }
        return numSocks;
    }

}
