package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_13904 {


    // 날이 적은 순으로 가져가면서
    // 만약 날이 되었는데 그게 더 크다면
    // 바꿔 끼우자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Assignment> assignments = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            assignments.add(new Assignment(input[0], input[1]));
        }

        assignments.sort((o1, o2) -> {
            if (o1.day == o2.day) {
                return Integer.compare(o1.score, o2.score);
            }
            return Integer.compare(o1.day, o2.day);
        });

        PriorityQueue<Assignment> pq = new PriorityQueue<>();
        pq.add(assignments.get(0));

        for (int i = 1; i < assignments.size(); i++) {
            Assignment assignment = assignments.get(i);
            if (pq.size() < assignment.day) {
                pq.add(assignment);
                continue;
            }
            if (assignment.score > pq.peek().score || (assignment.score == pq.peek().score && assignment.day < pq.peek().day)) {
                pq.poll();
                pq.add(assignment);
            }
        }

        System.out.println(pq.stream().mapToInt(o -> o.score).sum());

    }

    static class Assignment implements Comparable<Assignment> {
        int day;
        int score;

        public Assignment(int day, int score) {
            this.day = day;
            this.score = score;
        }

        @Override
        public int compareTo(Assignment o) {
            if (this.score == o.score) {
                return Integer.compare(this.day, o.day);
            }
            return Integer.compare(this.score, o.score);
        }

    }

}
