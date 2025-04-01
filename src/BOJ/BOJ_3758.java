package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class BOJ_3758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = input[0]; // 팀의 개수
            int k = input[1]; // 문제의 개수
            int t = input[2]; // 팀 ID
            int m = input[3]; // 로그 엔트리 개수

            Map<Integer, Team> teams = new HashMap<>();
            for (int i = 0; i < n; i++) {
                teams.put(i + 1, new Team(i + 1));
            }
            for (int i = 0; i < m; i++) {
                input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Team team = teams.get(input[0]);
                team.solve(input[1], input[2], i);
            }

            List<Team> teamList = new ArrayList<>(teams.values());
            Collections.sort(teamList);

            for (int i = 0; i < teamList.size(); i++) {
                if (teamList.get(i).teamId == t) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }

    static class Team implements Comparable<Team>{
        int teamId;
        Map<Integer, Integer> scores = new HashMap<>();
        int submitCount;
        int lastSubmitTime;

        public Team(int teamId) {
            this.teamId = teamId;
        }

        void solve(int scoreId, int score, int lastSubmitTime) {
            scores.putIfAbsent(scoreId, score);
            scores.put(scoreId, Math.max(scores.get(scoreId), score));
            this.submitCount++;
            this.lastSubmitTime = lastSubmitTime;
        }

        @Override
        public int compareTo(Team o) {
            if (this.scores.values().stream().mapToInt(i -> i).sum() != o.scores.values().stream().mapToInt(i -> i).sum()) {
                return Integer.compare(o.scores.values().stream().mapToInt(i -> i).sum(), this.scores.values().stream().mapToInt(i -> i).sum());
            }
            if (this.submitCount != o.submitCount) {
                return Integer.compare(this.submitCount, o.submitCount);
            }

            return Integer.compare(this.lastSubmitTime, o.lastSubmitTime);
        }

    }

}
