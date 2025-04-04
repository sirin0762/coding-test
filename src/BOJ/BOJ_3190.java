package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 뱀
public class BOJ_3190 {

    static final int APPLE = 10_000;

    // 오 -> 위 -> 왼 -> 아
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int direction = 0; // 시작은 오른쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for (int i = 0; i < K; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            board[input[0] - 1][input[1] - 1] = APPLE;
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            map.put(Integer.parseInt(input[0]), input[1].charAt(0));
        }

        int answer = 0;
        int x = 0, y = 0;
        LinkedList<Node> snake = new LinkedList<>();
        snake.add(new Node(x, y));
        while (true) {
            answer++;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
            if (snake.contains(new Node(nx, ny))) break;

            snake.addFirst(new Node(nx, ny));
            if (board[nx][ny] != APPLE) {
                snake.removeLast();
            } else {
                board[nx][ny] = 0;
            }
            x = nx;
            y = ny;

            if (map.containsKey(answer)) {
                Character c = map.get(answer);
                if (c == 'L') direction = (direction + 1) % 4;
                else {
                    direction = direction - 1;
                    if (direction == -1) direction = 3;
                }
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

    }

}
