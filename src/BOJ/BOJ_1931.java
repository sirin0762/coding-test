package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 회의실 배정
public class BOJ_1931 {

    // 먼저 끝나는 순으로 정렬해서?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<MeetingTime> meetingTimes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            meetingTimes.add(new MeetingTime(input[0], input[1]));
        }
        Collections.sort(meetingTimes);

        MeetingTime lastMeetingTime = meetingTimes.get(0);
        int answer = 1;

        for (int i = 1; i < meetingTimes.size(); i++) {
            MeetingTime candidate = meetingTimes.get(i);
            if (lastMeetingTime.endTime <= candidate.startTime) {
                lastMeetingTime = candidate;
                answer++;
            }
        }
        System.out.println(answer);
    }

    static class MeetingTime implements Comparable<MeetingTime> {
        long startTime;
        long endTime;

        public MeetingTime(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(MeetingTime o) {
            if (this.endTime == o.endTime) {
                return Long.compare(this.startTime, o.startTime);
            }
            return Long.compare(endTime, o.endTime);
        }

    }

}
