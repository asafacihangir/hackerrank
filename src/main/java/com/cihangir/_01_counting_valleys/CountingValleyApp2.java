package com.cihangir._01_counting_valleys;

import java.io.IOException;


//my solution refactored
public class CountingValleyApp2 {


    public static void main(String[] args) throws IOException {

        int n = 12;
        String path = "DDUUDDUDUUUD";
        int result = countingValleys(n, path);

        System.out.println(result);
    }

    public static int countingValleys(int steps, String path) {
        int valleyCount = 0;
        int currentPosition = 0;

        for (int i = 0; i < steps; i++) {
            char step = path.charAt(i);
            boolean up = step == 'U';

            int previousPosition = currentPosition;
            currentPosition += up ? 1 : -1;

            if (previousPosition < 0 && currentPosition == 0) {
                valleyCount++;
            }
        }


        return valleyCount;
    }
}
