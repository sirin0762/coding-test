package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 아기상어
public class BOJ_16236 {

    // 1. 먹을 수 있는 물고기 서칭
        // 1.1 모든 물고기에 대해서 BFS 로 서칭
        // 1.2 이걸 PQ 에 집어넣어야함
    // 2. 물고기 냠냠 및 시간 측정
        // 2.1 만약 물고기가 없으면 리턴
    // 3. 다시 1 반복

    static int N;
    static int sharkX;
    static int sharkY;
    static int sharkSize = 2;
    static int sharkFeed = 0;
    static PriorityQueue<Node> fishPositions;
    static boolean[][] isvisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[N - i - 1][j] = Integer.parseInt(st.nextToken());
                if (map[N - i - 1][j] == 9) {
                    sharkX = N - i - 1;
                    sharkY = j;
                }
            }
        }
        int answer = 0;
        while (true) {
            fishPositions = new PriorityQueue<>();
            isvisited = new boolean[N][N];
            bfs(map, sharkX, sharkY);

            if (fishPositions.isEmpty()) {
                break;
            }

            Node target = fishPositions.poll();
            map[sharkX][sharkY] = 0;

            sharkX = target.x;
            sharkY = target.y;
            map[target.x][target.y] = 9;
            sharkFeed++;
            answer += target.distance;


            if (sharkFeed == sharkSize) {
                sharkFeed = 0;
                sharkSize++;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int[][] map, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        isvisited[x][y] = true;
        queue.add(new Node(x, y, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || isvisited[nx][ny] || map[nx][ny] > sharkSize) {
                    continue;
                }

                if (map[nx][ny] < sharkSize && map[nx][ny] != 0) {
                    fishPositions.add(new Node(nx, ny, node.distance + 1));
                }
                isvisited[nx][ny] = true;
                queue.add(new Node(nx, ny, node.distance + 1));
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }


        @Override
        public int compareTo(Node o) {
            if (this.distance != o.distance) {
                return Integer.compare(this.distance, o.distance);
            }
            if (this.x != o.x) {
                return Integer.compare(o.x, this.x);
            }
            return Integer.compare(this.y, o.y);
        }

    }

}
