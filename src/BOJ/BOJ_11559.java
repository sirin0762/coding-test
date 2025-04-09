package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 뿌요
public class BOJ_11559 {

    // 1. bfs 를 돌며 뿌요가 가능한 목록을 찾는다.
    // 2. 뿌요를 터친다.
    // 3. 남은 색깔을 아래로 내린다.
    // 4. 이를 반복한다.

    static String[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Node> boomPos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new String[12][6];
        for (int i = 1; i <= 12; i++) {
            board[12 - i] = br.readLine().split("");
        }
        int answer = 0;
        while (true) {
            boomPos = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (boomPos.contains(new Node(i, j))) continue;
                    if (board[i][j].equals(".")) continue;
                    bfs(i, j, board[i][j]);
                }
            }

            if (boomPos.isEmpty()) {
                break;
            }

            boomPos.forEach(n -> board[n.x][n.y] = ".");

            for (int i = 1; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].equals(".")) continue;
                    fallBlock(i, j);
                }
            }
            answer++;
        }
        System.out.println(answer);
    }

    private static void fallBlock(int x, int y) {
        while (true) {
            x = x - 1;
            if (x < 0 || !board[x][y].equals(".")) break;

            board[x][y] = board[x + 1][y];
            board[x + 1][y] = ".";
        }
    }

    private static void bfs(int startX, int startY, String color) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];
        List<Node> nodes = new ArrayList<>();
        Node startNode = new Node(startX, startY);
        q.add(startNode);
        nodes.add(startNode);
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                if (!board[nx][ny].equals(color)) continue;
                if (visited[nx][ny]) continue;

                Node adeedNode = new Node(nx, ny);
                visited[nx][ny] = true;
                q.add(adeedNode);
                nodes.add(adeedNode);
            }
        }

        if (nodes.size() >= 4) {
            boomPos.addAll(nodes);
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
