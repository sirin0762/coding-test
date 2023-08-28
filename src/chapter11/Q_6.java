package chapter11;

import java.util.Arrays;

public class Q_6 {

    public static int[][] graph;

    public static void main(String[] args) {

    }

    public int solution(int n, int[][] results) {
        graph = new int[n][n];
        for (int i = 0; i < results.length; i++) {
            int start = results[i][0] - 1;
            int end = results[i][1] - 1;
            graph[start][end] = 1;
            graph[end][start] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }

                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = (int) Arrays.stream(graph[i]).filter(c -> c != 0).count();
            if (count == n - 1) answer++;
        }
        return answer;
    }

}
