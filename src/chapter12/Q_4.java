package chapter12;

public class Q_4 {

    public boolean[] visited;

    public static void main(String[] args) {

    }

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, n);
                answer++;
            };
        }
        return answer;
    }

    private void dfs(int start, int[][] computers, int n) {
        visited[start] = true;
        for (int i = 0; i < n; i++) {
            if (computers[start][i] == 1 && !visited[i]) dfs(i, computers, n);
        }
    }

}
