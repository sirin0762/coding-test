package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주사위 굴리기
public class BOJ_14999 {

    // 3차원 좌표?
    // 다이스 번호, 높이, 방향
    // {-1,

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int M;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        int x = input[2];
        int y = input[3];
        int K = input[4];

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(x, y, new int[7]);

        int[] directions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int d : directions) {
            boolean rolled = dice.roll(d);
            if(rolled) System.out.println(dice.getTopValue());
        }
    }

    static class Dice {

        int x;

        int y;

        int[] numbers;

        public Dice(int x, int y, int[] numbers) {
            this.x = x;
            this.y = y;
            this.numbers = numbers;
        }

        // 1(동), 2(서), 3(북), 4(남)
        public boolean roll(int d) {
            int nx = x + dx[d - 1];
            int ny = y + dy[d - 1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) return false;

            x = nx;
            y = ny;
            int tmp;
            switch (d) {
                case 1:
                    tmp =  numbers[3];
                    numbers[3] = numbers[1];
                    numbers[1] = numbers[4];
                    numbers[4] = numbers[6];
                    numbers[6] = tmp;
                    break;
                case 2:
                    tmp =  numbers[4];
                    numbers[4] = numbers[1];
                    numbers[1] = numbers[3];
                    numbers[3] = numbers[6];
                    numbers[6] = tmp;
                    break;
                case 3:
                    tmp =  numbers[2];
                    numbers[2] = numbers[1];
                    numbers[1] = numbers[5];
                    numbers[5] = numbers[6];
                    numbers[6] = tmp;
                    break;
                case 4:
                    tmp =  numbers[5];
                    numbers[5] = numbers[1];
                    numbers[1] = numbers[2];
                    numbers[2] = numbers[6];
                    numbers[6] = tmp;
                    break;
            }
            if (board[x][y] == 0) {
                board[x][y] = numbers[6];
            } else {
                numbers[6] = board[x][y];
                board[x][y] = 0;
            }
            return true;
        }

        public int getTopValue() {
            return numbers[1];
        }

    }

}
