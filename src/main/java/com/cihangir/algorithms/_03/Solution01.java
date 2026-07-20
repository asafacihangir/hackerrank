package com.cihangir.algorithms._03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    static final boolean DEBUG = true;

    public static int nonDivisibleSubset(int k, List<Integer> s) {

        // Iki sayinin toplami k'ya bolunuyorsa, kalanlarinin toplami 0 ya da k'dir.
        // Yani secim tamamen kalanlara bagli -> once kalana gore grupla.
        Map<Integer, List<Integer>> groupsByRemainder = new HashMap<>();
        for (int value : s) {
            groupsByRemainder.computeIfAbsent(value % k, r -> new ArrayList<>()).add(value);
        }

        List<Integer> selected = new ArrayList<>();

        for (int remainder = 0; remainder < k; remainder++) {
            
             // remainder + opposite = k oldugu icin ikisi ayni kumede duramaz
            int opposite = (k - remainder) % k;

            // bu cift asagida zaten islendi
            if (remainder > opposite) {
                continue;                         
            }

            List<Integer> group = groupsByRemainder.getOrDefault(remainder, Collections.emptyList());
            List<Integer> oppositeGroup = groupsByRemainder.getOrDefault(opposite, Collections.emptyList());

            if (remainder == opposite) {
                if (!group.isEmpty()) {
                    selected.add(group.get(0));
                }
                log("r=%d %-14s grup ici cakisma => sadece 1 eleman (+%d)%n",
                        remainder, group, Math.min(group.size(), 1));
                continue;
            }

            // grup ici guvenli, gruplar arasi degil -> ya hep ya hic, kalabalik olani al
            boolean pickGroup = group.size() >= oppositeGroup.size();
            selected.addAll(pickGroup ? group : oppositeGroup);

            log("r=%d %-14s <-> r=%d %-14s => r=%d secildi (+%d)%n",
                    remainder, group,
                    opposite, oppositeGroup,
                    pickGroup ? remainder : opposite,
                    Math.max(group.size(), oppositeGroup.size()));
        }

        log("Secilen elemanlar: %s%n", selected);
        return selected.size();
    }

    private static void log(String format, Object... args) {
        if (DEBUG) {
            System.out.printf(format, args);
        }
    }

}

public class Solution01 {

    private static String nextDataLine(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty() && !line.startsWith("---")) {
                return line;
            }
        }
        return null;
    }

    private static List<Integer> parseLine(String line) {
        List<Integer> list = new ArrayList<>();
        for (String part : line.trim().split("\\s+")) {
            list.add(Integer.parseInt(part));
        }
        return list;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = "src/main/java/com/cihangir/algorithms/_03/testdata/input04.txt";
        Scanner scanner = new Scanner(new File(inputPath));

        int testCase = 0;
        String line;
        while ((line = nextDataLine(scanner)) != null) {
            int k = Integer.parseInt(line.split("\\s+")[1]);

            List<Integer> s = parseLine(nextDataLine(scanner));

            int expected = Integer.parseInt(nextDataLine(scanner));
            int result = Result.nonDivisibleSubset(k, s);

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
