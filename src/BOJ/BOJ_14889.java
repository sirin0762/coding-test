package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] statuses = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                statuses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] isVisited = new boolean[n];
        int members = n / 2;
        dfs(statuses,  new int[members], isVisited, 0, members);

        System.out.println(answer);
    }

    private static void dfs(int[][] statuses, int[] participate, boolean[] isVisited, int depth, int max) {
        if (depth ==  max) {
            int teamStartScore = getScore(statuses, participate);
            int[] teamLinkMembers = getTeamLinkMembers(statuses, participate);
            int teamLinkScore = getScore(statuses, teamLinkMembers);
            answer = Math.min(answer, Math.abs(teamStartScore - teamLinkScore));
            return;
        }

        if (depth == 0) {
            for (int i = 0; i < statuses.length / 2; i++) {
                if (isVisited[i]) continue;
                isVisited[i] = true;
                participate[depth] = i;
                dfs(statuses, participate, isVisited, depth + 1, max);
                isVisited[i] = false;
            }
        } else {
            for (int i = participate[depth - 1]; i < statuses.length; i++) {
                if (isVisited[i]) continue;
                isVisited[i] = true;
                participate[depth] = i;
                dfs(statuses, participate, isVisited, depth + 1, max);
                isVisited[i] = false;
            }
        }
    }

    private static int[] getTeamLinkMembers(int[][] statuses, int[] participate) {
        int[] teamLink = new int[participate.length];
        int pos = 0;
        for (int i = 0; i < statuses.length; i++) {
            boolean isMatch = false;
            for (int j = 0; j < participate.length; j++) {
                if (participate[j] == i) {
                    isMatch = true;
                    break;
                }
            }
            if (!isMatch) {
                teamLink[pos] = i;
                pos++;
            }
        }
        return teamLink;
    }

    private static int getScore(int[][] statuses, int[] participate) {
        int score = 0;
        for (int i = 0; i < participate.length; i++) {
            for (int j = i; j < participate.length; j++) {
                int x = participate[i];
                int y = participate[j];
                score += statuses[x][y] + statuses[y][x];
            }
        }
        if (score == 0) {
            System.out.println(score);
            System.exit(0);
        }
        return score;
    }

}
