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

public class BOJ1260 {

    private static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int start = input[2];

        // 간선 정보 주입
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] coord = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = coord[0];
            int y = coord[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 간선 정보 정렬
        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
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
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (visited[next]) continue;
                System.out.print(next + " ");
                visited[next] = true;
                q.add(next);
            }
        }
    }

    private static void dfs(int start, boolean[] visited) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (visited[next]) continue;
            dfs(next, visited);
        }
    }

}
