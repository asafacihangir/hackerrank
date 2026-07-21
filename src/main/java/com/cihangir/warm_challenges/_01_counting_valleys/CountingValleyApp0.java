package com.cihangir.warm_challenges._01_counting_valleys;

import java.io.IOException;

//my solution
public class CountingValleyApp0 {

    public static void main(String[] args) throws IOException {

        int n = 12;
        String path = "DDUUDDUDUUUD";
        int result = countingValleys(n, path);

        System.out.println(result);
    }


    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {

        int valleyCount = 0;
        int previousPosition;
        int currentPosition = 0;

        for (int i = 0; i < steps; i++) {
            previousPosition = currentPosition;
            char step = path.charAt(i);
            boolean up = step == 'U';

            if ( step == 'U') {
                currentPosition++;
            }else {
                currentPosition--;
            }
            if ( i !=0 && previousPosition <0 && currentPosition == 0){
                valleyCount++;
            }
        }

        return valleyCount;
    }


}
