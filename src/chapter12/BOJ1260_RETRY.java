package chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ1260_RETRY {

    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int start = input[2];

        // 간선 정보 주입
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int[] coord = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = coord[0];
            int y = coord[1];
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        boolean[] visited = new boolean[n + 1];
        dfs(start, visited);
        System.out.println();

        visited = new boolean[n + 1];
        bfs(start, visited);

    }

    private static void bfs(int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        System.out.print(start + " ");

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i < graph[now].length; i++) {
                int value = graph[now][i];
                if (value == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    private static void dfs(int start, boolean[] visited) {
        System.out.print(start + " ");
        visited[start] = true;

        for (int i = 1; i < graph[start].length; i++) {
            int value = graph[start][i];
            if (value == 1 && !visited[i]) dfs(i, visited);
        }
    }

}
