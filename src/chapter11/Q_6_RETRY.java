package chapter11;

import chapter8.Main;

public class Q_6_RETRY {

    public static void main(String[] args) {
        Q_6_RETRY main = new Q_6_RETRY();
        System.out.println(main.solution(5, new int[][]{
            {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
        }));
    }

    private int[][] graph;

    // 1. 그래프 세팅
    // 2. 주어진 시작점을 기반으로 그래프 순회(dfs)
    // 3. 이긴사람 + 진사람 + 1 = 전체선수
    public int solution(int n, int[][] results) {
        graph = new int[n + 1][n + 1];

        for (int[] r: results) {
            int winner = r[0];
            int loser = r[1];
            graph[winner][loser] = 1;
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            int winCount = countWin(i, visited) - 1;

            visited = new boolean[n + 1];
            int loseCount = countLose(i, visited) - 1;

            if (winCount + loseCount + 1 == n) answer++;
        }

        return answer;
    }

    private int countLose(int start, boolean[] visited) {
        int count = 1;
        for (int i = 1; i <= visited.length - 1; i++) {
            if (graph[i][start] == 1 && !visited[i]) {
                visited[i] = true;
                count += countLose(i, visited);
            }
        }
        return count;
    }

    private int countWin(int start, boolean[] visited) {
        int count = 1;
        for (int i = 1; i <= visited.length - 1; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                count += countWin(i, visited);
            }
        }
        return count;
    }

}
