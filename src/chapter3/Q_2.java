package chapter3;

import java.util.Arrays;

public class Q_2 {

    // 1. n에 해당하는 2차원 배열을 생성한다.
    // 2. 방향에 따라 삼각형을 돌린다.
        // 2.1 아래, 오른쪽, 좌상단 방향으로 돌린다.
        // 2-2. 기준은
    // 3. 일차원 배열로 묶은 뒤 필터링한다.

    private int[] dx = {0, 1, -1};
    private int[] dy = {1, 0, -1};
    private int direction = 0;

    public static void main(String[] args) {
        Q_2 q2 = new Q_2();
        q2.solution(4);
    }

    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int x = 0, y = -1;
        int limit = n;
        int reminder = 0;

        for (int i = 0; i < (n * (n + 1)) / 2; i++) {
            x = x + dx[direction];
            y = y + dy[direction];
            arr[y][x] = i + 1;
            reminder++;
            if (limit == reminder) {
                changeDirection();
                limit--;
                reminder = 0;
            }
        }
        int[] ints = Arrays.stream(arr).flatMapToInt(Arrays::stream).filter(i -> i != 0).toArray();
        return ints;
    }

    private void changeDirection() {
        direction = (direction + 1) % 3;
    }

}
