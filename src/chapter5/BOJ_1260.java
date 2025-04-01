//package chapter5;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class BOJ_1260 {
//
//    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//    public static int n, m, start;
//    public static boolean[] visited;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        n = Integer.parseInt(input[0]);
//        m = Integer.parseInt(input[1]);
//        start = Integer.parseInt(input[2]);
//
//
//        for (int i = 0; i < n + 1; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < m; i++) {
//            input = br.readLine().split(" ");
//            int start = Integer.parseInt(input[0]);
//            int end = Integer.parseInt(input[1]);
//            graph.get(start).add(end);
//        }
//
//        for (int i = 0; i < n; i++) {
//            ArrayList<Integer> node = graph.get(i);
//
//        }
//
//        visited = new boolean[n + 1];
//        dfs(start);
//        System.out.println();
//        visited = new boolean[n + 1];
//        bfs(start);
//
//    }
//
//    private static void dfs(int start) {
//        visited[start] = true;
//        System.out.print(start + " ");
//        for (int i = 0; i < graph.get(start).size(); i++) {
//            int next = graph.get(start).get(i);
//            if (!visited[next]) dfs(next);
//        }
//    }
//
//    private static void bfs(int start) {
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(start);
//        visited[start] = true;
//        while (!q.isEmpty()) {
//            start = q.poll();
//            System.out.print(start + " ");
//            for (int i = 0; i < graph.get(start).size(); i++) {
//                int next = graph.get(start).get(i);
//                if (!visited[next]) {
//                    q.offer(next);
//                    visited[next] = true;
//                }
//            }
//        }
//    }
//
//}
