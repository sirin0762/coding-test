package chapter10;

import java.util.Arrays;

public class Q_3_RETRY {

    int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Q_3_RETRY main = new Q_3_RETRY();
        System.out.println(main.solution(4, 3, new int[][] {
            {2, 2}
        }));
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];

        Arrays.fill(map[1], 1);
        map[1][0] = 0;
        for (int i = 1; i < n + 1; i++) {
            map[i][1] = 1;
        }

        for (int[] arr: puddles) {
            if (arr[1] == 1) {
                for (int i = arr[0]; i < m + 1; i++) {
                    map[arr[1]][i] = INF;
                }
            }

            if (arr[0] == 1) {
                for (int i = arr[1]; i < n + 1; i++) {
                    map[i][arr[0]] = INF;
                }
            }
            map[arr[1]][arr[0]] = INF;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < m + 1; j++) {
                if (map[i][j] == INF) continue;
                if (map[i - 1][j] == INF) map[i][j] = map[i][j - 1];
                else if (map[i][j - 1] == INF) map[i][j] = map[i - 1][j];
                else map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1_000_000_007;
            }
        }

        return map[n][m];
    }

}
