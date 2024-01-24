package chapter10;

import java.util.Arrays;

public class Q_4_RETRY {

    // 1, 주어진 수를 기반으로 뒤에 수 중 가장 크거나 작은수를 계산한다.
        // (+) 의 경우 : 최댓값이면 가장 큰 수, 최솟값이면 가장 작은 수
        // (-) 의 경우 : 최댓값이면 가장 작은 수, 최댓값이면 가장 큰 수
    // 2. 해당 결과 중 가장 큰 수를 리턴한다.

    private int[][] maxNum = new int[202][202];
    private int[][] minNum = new int[202][202];

    public static void main(String[] args) {

    }

    public int solution(String arr[]) {
        for (int[] row: maxNum) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        for (int[] row: minNum) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return max(0, arr.length, arr);
    }

    private int max(int start, int end, String[] arr) {
        if (maxNum[start][end] != Integer.MIN_VALUE) return maxNum[start][end];
        if (end - start == 1) return Integer.parseInt(arr[start]);
        int max = Integer.MIN_VALUE;

        for (int i = start + 1; i < end; i += 2) {
            int l = max(start, i, arr);
            int v;
            if (arr[i].equals("+")) {
                int r = max(i + 1, end, arr);
                v = l + r;
            } else {
                int r = min(i + 1, end, arr);
                v = l - r;
            }
            if (v > max) max = v;
        }
        return maxNum[start][end] = max;
    }

    private int min(int start, int end, String[] arr) {
        if (minNum[start][end] != Integer.MAX_VALUE) return minNum[start][end];
        if (end - start == 1) return Integer.parseInt(arr[start]);
        int min = Integer.MAX_VALUE;

        for (int i = start + 1; i < end; i += 2) {
            int l = min(start, i, arr);
            int v;
            if (arr[i].equals("+")) {
                v = l + min(i + 1, end, arr);
            } else {
                v = l - max(i + 1, end, arr);
            }
            min = Math.min(min, v);
        }
        return minNum[start][end] = min;
    }

}
