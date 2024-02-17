package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ1913 {

    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};

    static int direction = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int x = -1;
        int y = 0;

        for (int i = n * n; i > 0; i--) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != 0) {
                direction = (direction + 1) % 4;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            map[nx][ny] = i;
            x = nx;
            y = ny;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.append(String.valueOf(map[i][j])).append(" ");
            }
            bw.append("\n");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == target) {
                    bw.append(String.valueOf(i + 1)).append(" ").append(String.valueOf(j + 1));
                    bw.flush();
                    return;
                }
            }
        }

    }

}
