package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 로봇청소기
public class BOJ14503 {

    static int N;
    static int M;
    static int direction;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        board = new int[N][M];

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Node robot = new Node(input[0], input[1]);
        direction = input[2];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(bfs(robot));

    }

    private static int bfs(Node robot) {
        int result = 0;
        int x = robot.x;
        int y = robot.y;
        board[x][y] = 2; // 2 청소완료
        result++;

        while (true) {
            if (isClean(x, y)) {
                int nx = x - dx[direction];
                int ny = y - dy[direction];

                if (board[nx][ny] == 1) {
                    break;
                } else {
                    x = nx;
                    y = ny;
                }

            } else {
                direction = (direction + 3) % 4;
                int nx = x + dx[direction];
                int ny = y + dy[direction];
                if (board[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    board[x][y] = 2; // 2 청소완료
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean isClean(int x, int y) {
        boolean isClean = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (board[nx][ny] == 0) return false;
        }
        return isClean;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
