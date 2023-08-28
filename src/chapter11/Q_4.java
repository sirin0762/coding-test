package chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q_4 {

    // 1. Q르 선언한다
    // 2. 주어진 progress와 speeds 로 Work 객체를 만든다.
    // 3. 매일매일 확인한다.

    public static void main(String[] args) {
        Q_4 q4 = new Q_4();
        System.out.println(Arrays.toString(q4.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Work> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new Work(progresses[i], speeds[i]));
        }

        while (!queue.isEmpty()) {
            int count = 0;

            while (!queue.isEmpty() && queue.peek().isDone()) {
                count++;
                queue.poll();
            }

            for (int i = 0; i < queue.size(); i++) {
                Work work = queue.poll();
                work.develop();
                queue.offer(work);
            }

            if (count > 0) {
                answer.add(count);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static class Work {
        int progress;
        int speed;

        public Work(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public boolean isDone() {
            return this.progress >= 100;
        }

        public void develop() {
            this.progress += speed;
        }
    }

}
