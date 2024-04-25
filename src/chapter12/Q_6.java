package chapter12;

import java.util.LinkedList;
import java.util.Queue;

public class Q_6 {

    int answer = Integer.MAX_VALUE;

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Q_6 q6 = new Q_6();
        System.out.println(q6.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }

    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        boolean[][] visited = new boolean[row][col];
//        dfs(0, 0, maps, 1, row, col, visited);
        return bfs(maps);
    }

    private int bfs(int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        q.add(new Node(0, 0, 1));
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.y == maps.length - 1 && now.x == maps[0].length - 1) {
                return now.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= maps[0].length || nx < 0 || ny >= maps.length || ny < 0) continue;
                if (visited[ny][nx]) continue;
                if (maps[ny][nx] == 0) continue;

                q.add(new Node(nx, ny, now.dist + 1));
                visited[ny][nx] = true;
            }
        }
        return -1;
    }


    private void dfs(int x, int y, int[][] maps, int depth, int maxRow, int maxCol, boolean[][] visited) {
        if (x >= maxCol || y >= maxRow || x < 0 || y < 0) return;

        if (visited[y][x]) return;

        if (maps[y][x] == 0) return;

        if (x == maxCol - 1 && y == maxRow - 1 && maps[y][x] == 1) {
            answer = Math.min(answer, depth);
            return;
        }

        visited[y][x] = true;

        dfs(x + 1, y, maps, depth + 1, maxRow, maxCol, visited);
        dfs(x, y + 1, maps, depth + 1, maxRow, maxCol, visited);
        dfs(x - 1, y, maps, depth + 1, maxRow, maxCol, visited);
        dfs(x, y - 1, maps, depth + 1, maxRow, maxCol, visited);
    }

    static private class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }

}
