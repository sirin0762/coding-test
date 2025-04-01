package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int start = input[2];
        boolean[] visited = new boolean[n + 1];
        boolean[][] map = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[input[0]][input[1]] = true;
            map[input[1]][input[0]] = true;
        }

        dfs(start, map, visited);
        visited = new boolean[n + 1];
        System.out.println();
        bfs(start, map, visited);
    }

    static void dfs(int start, boolean[][] map, boolean[] visited) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int i = 1; i < map.length; i++) {
            if (map[start][i] && !visited[i]) {
                dfs(i, map, visited);
            }
        }
    }

    static void bfs(int start, boolean[][] map, boolean[] visited) {
        System.out.print(start + " ");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i < map.length; i++) {
                if (map[now][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

}
