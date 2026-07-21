package com.cihangir.warm_challenges._02_jumping_on_the_clouds;

public class JumpingOnCloudApp0 {

    public static void main(String[] args) {


        int[] clouds1 = {0, 1, 0, 0, 0, 1, 0};
        int[] clouds2 = {0, 0, 1, 0, 0, 1, 0};
        int[] clouds3 = {0, 0, 0, 0, 1, 0};

        int result = jumpingOnClouds(clouds3);
        System.out.println(result);
    }


    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] clouds) {

        int countSafeCloud = 0;
        int firstIndexForControlConsecutive = 2;

        for ( int i=0; i<clouds.length; i++){
            boolean isSafeCloud = clouds[i] == 0;
            if ( isSafeCloud){
                countSafeCloud++;
                boolean isConsecutive = i>=firstIndexForControlConsecutive && (clouds[i] == clouds[i-1]) && (clouds[i-1] == clouds[i-2]);
                if ( isConsecutive ) {
                    firstIndexForControlConsecutive = i+2;
                    countSafeCloud--;
                }
            }
        }
        //path uzunluğu için 1 çıkarılır.
        return countSafeCloud-1;
    }

}
