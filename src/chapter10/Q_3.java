package chapter10;

import java.util.Arrays;

public class Q_3 {

    final int REMINDER = 1_000_000_007;

    public static void main(String[] args) {
        Q_3 q3 = new Q_3();
        q3.solution(4, 3, new int[][]{{2, 2}});
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] traps = new boolean[n + 1][m + 1];
        dp[1][1] = 1;
        for (int[] puddle : puddles) {
            traps[puddle[1]][puddle[0]] = true;
            dp[puddle[1]][puddle[0]] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (traps[i][j]) continue;
                if (i == 1 && j == 1) continue;

                if (i == 1) {
                    dp[i][j] = dp[i][j - 1] % REMINDER;
                    continue;
                }

                if (j == 1) {
                    dp[i][j] = dp[i - 1][j] % REMINDER;
                    continue;
                }

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % REMINDER;
            }
        }

        return dp[n][m];
    }

}
