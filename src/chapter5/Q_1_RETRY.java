package chapter5;

import java.text.MessageFormat;
import java.util.Arrays;

public class Q_1_RETRY {

    private int[] answer = new int[2];

    public static void main(String[] args) {
        Q_1_RETRY main = new Q_1_RETRY();
        main.solution(new int[][]{
            {1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}
        });
    }

    public int[] solution(int[][] arr) {
        quad(arr, 0, arr.length, 0, arr.length);
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private void quad(int[][] arr, int startX, int endX, int startY, int endY) {
        if (allSameIngredient(arr, startX, endX, startY, endY)) {
            answer[arr[startY][startX]]++;
            return;
        }

        int quadLength = (endX - startX) / 2;
        quad(arr, startX, startX + quadLength, startY, startY + quadLength);
        quad(arr, startX + quadLength, endX, startY, startY + quadLength);
        quad(arr, startX, startX + quadLength, startY + quadLength, endY);
        quad(arr, startX + quadLength, endX, startY + quadLength, endY);
    }

    private boolean allSameIngredient(int[][] arr, int startX, int endX, int startY, int endY) {
        int target = arr[startY][startX];
        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                if (arr[i][j] != target) return false;
            }
        }
        return true;
    }

}
