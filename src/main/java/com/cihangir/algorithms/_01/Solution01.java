package com.cihangir.algorithms._01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result {

    /*
     * Forming a Magic Square
     * ----------------------
     * Problem: 3x3 matrix veriliyor (1-9 arasi sayilar). Bu matrix'i minimum maliyet ile
     * magic square'e donusturmek gerekiyor.
     *
     * Magic Square: Her satir, sutun ve capraz toplami ayni sayi (magic constant = 15).
     * Bir hucreyi degistirme maliyeti = |eski_deger - yeni_deger|
     *
     * Yaklasim: Brute Force
     * - 3x3 magic square sadece 8 tane var (1-9 arasi distinct sayilarla).
     * - Input matrix'i 8 magic square'in her biri ile karsilastir.
     * - Her hucre icin |input[i][j] - magic[i][j]| farkini topla -> donusturme maliyeti.
     * - 8 magic square arasindaki minimum maliyeti dondur.
     *
     * Complexity: O(1) - sabit sayida (8) magic square, sabit boyut (3x3)
     *
     * Ornek:
     *   Input:      Magic Square #5:     Maliyet:
     *   5 3 4       8 3 4                |5-8| = 3
     *   1 5 8       1 5 9                |8-9| = 1
     *   6 4 2       6 7 2                |4-7| = 3
     *                                     Toplam = 7
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        // 3x3 icin mumkun olan 8 magic square (her biri satir/sutun/capraz toplami = 15)
        int[][][] magicSquares = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
        };

        int minCost = Integer.MAX_VALUE;

        // Check the input against each of the 8 magic squares
        for (int[][] magic : magicSquares) {
            int currentCost = 0;

            // Calculate the cost to convert input 's' to the current 'magic' square
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    currentCost += Math.abs(s.get(i).get(j) - magic[i][j]);
                }
            }

            // Update the minimum cost found so far
            minCost = Math.min(minCost, currentCost);
        }

        return minCost;
    }





}

public class Solution01 {

    // Converts a line like "4 9 2" into a List of Integers [4, 9, 2]
    private static List<Integer> parseLine(String line) {
        String[] parts = line.trim().split(" ");
        List<Integer> row = new ArrayList<>();
        for (String part : parts) {
            row.add(Integer.parseInt(part));
        }
        return row;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = "src/main/java/com/cihangir/algorithms/_01/input01.txt";
        Scanner scanner = new Scanner(new File(inputPath));

        int testCase = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            // Skip empty lines and delimiters between test cases
            if (line.isEmpty() || line.startsWith("---")) {
                continue;
            }

            // Read the 3x3 matrix (first line already read above)
            List<List<Integer>> s = new ArrayList<>();
            s.add(parseLine(line));
            s.add(parseLine(scanner.nextLine()));
            s.add(parseLine(scanner.nextLine()));

            // Read expected result and run the algorithm
            int expected = Integer.parseInt(scanner.nextLine().trim());
            int result = Result.formingMagicSquare(s);

            testCase++;
            if (result == expected) {
                System.out.println("Test #" + testCase + " PASSED (expected=" + expected + ", got=" + result + ")");
            } else {
                System.out.println("Test #" + testCase + " FAILED (expected=" + expected + ", got=" + result + ")");
            }
        }

        scanner.close();
    }
}
