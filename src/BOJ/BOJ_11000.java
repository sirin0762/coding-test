package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_11000 {

    static class Meeting {

        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        Arrays.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 끝나는 시간 저장
        pq.add(meetings[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= meetings[i].start) {
                pq.poll(); // 기존 회의실 재사용
            }
            pq.add(meetings[i].end); // 새 회의실 또는 재사용된 회의실의 새로운 종료시간
        }

        System.out.println(pq.size());
    }

}
