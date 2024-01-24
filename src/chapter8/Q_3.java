package chapter8;

import java.util.Arrays;

public class Q_3 {

    public int solution(int distance, int[] rocks, int n) {
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        Arrays.sort(rocks);

        int start = 1;
        int end = distance;

        while (start < end) {
            int d = (start + end) / 2;
            if (isValid(d, rocks, n)) {
                end = d;
            } else {
                start = d + 1;
            }
        }
        return start;
    }

    private boolean isValid(int d, int[] rocks, int n) {
        int removed = 0;
        int last = 0;
        for (int rock: rocks) {
            if (rock - last < d) {
                removed++;
                continue;
            }

            last = rock;
        }

        return removed > n;
    }


}
