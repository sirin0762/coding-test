package practive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260 {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static int n, m, start;

    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        start = input[2];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = input[0];
            int y = input[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n + 1];
        dfs(start);
        System.out.println();

        visited = new boolean[n + 1];
        bfs(start);

    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        System.out.print(start + " ");
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    System.out.print(next + " ");
                }
            }
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (!visited[next]) dfs(next);
        }
    }

}
