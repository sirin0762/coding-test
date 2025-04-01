package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17484 {

    static int answer = Integer.MAX_VALUE;

    static int[] dx = {-1, 0, 1};
    static int[] dy = {-1, -1, -1};

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        // 1. 주어진 배열
        // 2. dfs 진행
        // 3. 최소값 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[n - i - 1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < m; i++) {
            dfs(map, i, n - 1, -1, 0);
        }
        System.out.println(answer);
    }

    static void dfs(int[][] map, int x, int y, int beforeDirection, int value) {
        value += map[y][x];
        if (y == 0) {
            answer = Math.min(answer, value);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (i == beforeDirection) continue;
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= m) continue;
            dfs(map, nx, ny, i, value);
        }
    }

}
