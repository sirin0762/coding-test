package chapter3;

import java.util.Arrays;

public class Q_2_ANSWER {

    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public static void main(String[] args) {

    }

    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 방향 확인
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                // 방향 전환
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                // 전환 했는데 이미 진행했으면? 끗
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }

        return Arrays.stream(triangle).flatMapToInt(Arrays::stream).filter(i -> i != 0).toArray();
    }

}
