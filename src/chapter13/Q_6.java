package chapter13;

import java.util.Arrays;

public class Q_6 {

    final int ATTACK = 1;
    final int HEAL = 2;

    public static void main(String[] args) {

    }

    // 스킬을 순회한다.
    // 스킬에서 정보를 빼와 r1 ~ r2, c1 ~ c2 까지의 동작을 수행한다.
    // 반복 후 board의 상태를 확인한다.
    public int solution(int[][] board, int[][] skill) {
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];

            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    if (type == ATTACK) {
                        board[i][j] -= degree;
                    } else {
                        board[i][j] += degree;
                    }
                }
            }
        }

        int answer = 0;

        int sum = Arrays.stream(board).mapToInt(
            arr -> (int) Arrays.stream(arr).filter(i -> i > 0).count()
        ).sum();
        return sum;
    }

}
