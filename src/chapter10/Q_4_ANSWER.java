package chapter10;

import java.util.Arrays;

public class Q_4_ANSWER {

    private final int[][] maxNum = new int[202][202];
    private final int[][] minNum = new int[202][202];

    public int solution(String[] arr) {
        for (int[] row : maxNum) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        for (int[] row : minNum) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return max(0, arr.length, arr);
    }

    private int max(int start, int end, String[] arr) {
        if (maxNum[start][end] != Integer.MIN_VALUE) {
            return maxNum[start][end];
        }
        if (end - start == 1) return Integer.parseInt(arr[start]);

        int max = Integer.MIN_VALUE;
        for (int i = start + 1; i < end; i+=2) {
            int l = max(start, i, arr);
            int v;
            if (arr[i].equals("+")) {
                v = l + max(i + 1, end, arr);
            } else {
                v = l - min(i + 1, end, arr);
            }
            max = Math.max(max, v);
        }
        return maxNum[start][end] = max;
    }

    private int min(int start, int end, String[] arr) {
        if (minNum[start][end] != Integer.MIN_VALUE) {
            return minNum[start][end];
        }
        if (end - start == 1) return Integer.parseInt(arr[start]);

        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i += 2) {
            int l = min(start, i, arr);
            int v;
            if (arr[i].equals("+")) {
                int r = min(i + 1, end, arr);
                v = l + r;
            } else {
                int r = max(i + 1, end, arr);
                v = l - r;
            }
            min = Math.min(min, v);
        }
        return minNum[start][end] = min;
    }

}
