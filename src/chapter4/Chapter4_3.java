package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chapter4_3 {

    public static int[][] map;
    public static boolean[][] visited;
    public static int direction;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int nPos = Integer.parseInt(st.nextToken());
        int mPos = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        visited[nPos][mPos] = true;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 1;
        int turnTime = 0;
        while (true) {
            turn_left();
            int nextN = nPos + dx[direction];
            int nextM = mPos + dy[direction];
            if(map[nextN][nextM] == 0 && !visited[nextN][nextM]) {
                nPos = nextN;
                mPos = nextM;
                visited[nPos][mPos] = true;
                answer++;
                turnTime = 0;
                continue;
            }
            else turnTime++;

            if (turnTime == 4) {
                nextN = nPos - dx[direction];
                nextM = mPos - dy[direction];

                if (map[nextN][nextM] == 0) {
                    nPos = nextN;
                    mPos = nextM;
                    turnTime = 0;
                    continue;
                }
                else break;
            }

        }
        System.out.println(answer);

    }

    private static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

}
