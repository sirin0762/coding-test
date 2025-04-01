package BOJ;


import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, -0, 1, -1};

    static int n;
    static int m;

    static int[][] map;
    static int[][] shortestMap;
    static boolean[][] visited;

    static final Integer INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        map = new int[n][m];
        shortestMap = new int[n][m];
        visited = new boolean[n][m];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                shortestMap[i][j] = INF;
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(map, shortestMap, visited, startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 0) {
                        bw.write(0 + " ");
                    }
                    else {
                        bw.write(-1 + " ");
                    }
                }
                else if (shortestMap[i][j] == 0) {
                    bw.write(0 + " ");
                }
                else {
                    bw.write(shortestMap[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void bfs(int[][] map, int[][] shortestMap, boolean[][] visited, int startX, int startY) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;
        shortestMap[startX][startY] = -1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i ++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= n || nx < 0 || ny >= m || ny < 0 || map[nx][ny] == 0) continue;
                shortestMap[now.x][now.y] = Math.min(shortestMap[now.x][now.y], shortestMap[nx][ny]);

                if (!visited[nx][ny]) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }

            if (shortestMap[now.x][now.y] != INF) {
                shortestMap[now.x][now.y] += 1;
            }
        }
    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

}
