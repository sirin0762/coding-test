package chapter11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q_9 {

    // 1. 주어진 작업을 Queue에 넣는다(출발 시간부터 정렬 후).
    // 2. 작업을 진행하며, 조건에 해당하는 작업들을 큐에 넣늗다.
    public static void main(String[] args) {
        Q_9 main = new Q_9();
        main.solution(new int[][] {
            {0, 3}, {1, 9}, {2, 6}
        });
    }

    public int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();
        for (int[] job: jobs) {
            jobList.add(new Job(job[0], job[1]));
        }
        jobList.sort(Comparator.comparingInt(j -> j.start));
        Queue<Job> jobQueue = new LinkedList<>(jobList);
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(j -> j.duration));

        int time = 0;
        int answer = 0;
        while (!pq.isEmpty() || !jobQueue.isEmpty()) {
            while (!jobQueue.isEmpty() && jobQueue.peek().start <= time) {
                pq.add(jobQueue.poll());
            }

            if (pq.isEmpty()) {
                time = jobQueue.peek().start;
                continue;
            }

            Job now = pq.poll();
            answer += (now.duration + time - now.start);
            time += now.duration;

        }

        return answer / jobs.length;
    }

    static class Job {
        int start;
        int duration;

        public Job(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }

    }

}
