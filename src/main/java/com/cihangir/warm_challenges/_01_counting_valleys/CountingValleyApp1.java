package com.cihangir.warm_challenges._01_counting_valleys;

import java.io.IOException;

//hackerrank solution
public class CountingValleyApp1 {


    public static void main(String[] args) throws IOException {

        int n = 12;
        String path = "DDUUDDUDUUUD";
        int result = countingValleys(n, path);

        System.out.println(result);
    }

    public static int countingValleys(int steps, String path) {

        int valleyCount = 0;
        int altitude = 0;

        for (int i = 0; i < steps; i++) {
            char step = path.charAt(i);
            // Step up
            if(step == 'U') {
                if(altitude == -1) {
                    valleyCount++;
                }
                altitude++;
            }
            // Step down
            else {
                altitude--;
            }
        }

        return valleyCount;
    }
}
