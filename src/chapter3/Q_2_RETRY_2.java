package chapter3;

import java.util.Arrays;
import java.util.stream.Stream;

public class Q_2_RETRY_2 {

    public static void main(String[] args) {
        Q_2_RETRY_2 main = new Q_2_RETRY_2();
        System.out.println(Arrays.toString(main.solution(3)));
    }

    int[] dx = {0, 1, -1};
    int[] dy = {1, 0, -1};
    int direction = 0;

    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int x = 0;
        int y = 0;
        for (int i = 0; i < (n + 1) * n  / 2; i++) {
            map[y][x] = i + 1;
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[ny][nx] != 0) {
                direction = (direction + 1) % 3;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            x = nx;
            y = ny;
        }

        return Arrays.stream(map).flatMapToInt(Arrays::stream).filter(i -> i != 0).toArray();
    }

}
