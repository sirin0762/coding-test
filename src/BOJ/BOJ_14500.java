package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 테크노미노
public class BOJ_14500 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board;
    static int answer = Integer.MIN_VALUE;

    static int N;
    static int M;

    // 어찌되었든 4칸만 가면 되지 않을까?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        boolean[][] isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Node start = new Node(i, j);
                Node[] nodes = new Node[4];
                nodes[0] = start;
                isVisited[start.x][start.y] = true;
                dfs(nodes, isVisited, 1, 4);
                isVisited[start.x][start.y] = false;
                bfs(start);
            }
        }
        System.out.println(answer);
    }

    private static void bfs(Node start) {
        for (int i = 0; i < 4; i++) {
            int score = board[start.x][start.y];
            boolean breaker = false;
            for (int j = 0; j < 3; j++) {
                int direction = (i + j) % 4;
                int nx = start.x + dx[direction];
                int ny = start.y + dy[direction];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    breaker = true;
                    break;
                };

                score += board[nx][ny];
            }

            if (breaker) continue;
            answer = Math.max(answer, score);
        }
    }

    private static void dfs(Node[] nodes, boolean[][] isVisited, int depth, int max) {
        if (depth == max) {
            int score = 0;
            for (int i = 0; i < 4; i++) {
                Node node = nodes[i];
                score += board[node.x][node.y];
            }
            answer = Math.max(answer, score);
            return;
        }

        for (int i = 0; i < 4; i++) {
            Node current = nodes[depth - 1];
            int nx = current.x + dx[i];
            int ny = current.y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || isVisited[nx][ny]) continue;
            isVisited[nx][ny] = true;
            nodes[depth] = new Node(nx, ny);
            dfs(nodes, isVisited, depth + 1, max);
            isVisited[nx][ny] = false;
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
        }

    }

}
