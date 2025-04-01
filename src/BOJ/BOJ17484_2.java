package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ17484_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];

        int[][] board = new int[n][m];

        int[][][] dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], (int) 1e9);
            }
        }

        for (int i = 0; i < m; i++) {
            dp[0][i][0] = board[0][i];
            dp[0][i][1] = board[0][i];
            dp[0][i][2] = board[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + board[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + board[i][j];
                } else if (j == m - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + board[i][j];
                    dp[i][j][1] = dp[i - 1][j][2] + board[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + board[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + board[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + board[i][j];
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(answer, dp[n - 1][i][j]);
            }
        }
        System.out.println(answer);
    }

}
