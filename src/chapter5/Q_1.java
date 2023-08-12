package chapter5;

import chapter4.Q_10;

public class Q_1 {

    // 1. 주어진 배열이 모두 같은 숫자인지 확인한다.
    // 2. 같은 숫자이면 그대로 해당 배열[start][start]

    private int[] count = new int[2];

    public static void main(String[] args) {
        Q_1 q1 = new Q_1();
        q1.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
    }

    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        return count;
    }

    private void quad(int[][] arr, int startX, int startY, int length) {
        if (isPossibleQuad(arr, startX, startY, length)) {
            count[arr[startY][startX]]++;
            return;
        }
        if (length == 1) {
            count[arr[startY][startX]]++;
            return;
        }
        int halfLength = length / 2;
        quad(arr, startX, startY, halfLength);
        quad(arr, startX + halfLength, startY, halfLength);
        quad(arr, startX, startY + halfLength, halfLength);
        quad(arr, startX + halfLength, startY + halfLength, halfLength);
    }

    private boolean isPossibleQuad(int[][] arr, int startX, int startY, int length) {
        int target = arr[startY][startX];
        for (int y = startY; y < startY + length; y++) {
            for (int x = startX; x < startX + length; x++) {
                if (arr[y][x] != target) return false;
            }
        }
        return true;
    }

}
