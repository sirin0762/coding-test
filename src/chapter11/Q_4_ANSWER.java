package chapter11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q_4_ANSWER {

    public static void main(String[] args) {

    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int index = q.poll();
            int expiration = (int) Math.ceil((double) (100 - progresses[index]) / speeds[index]);

            if (expiration > days) {
                result.add(count);
                count = 0;
                days = expiration;
            }
            count++;
        }

        result.add(count);
        return result.stream().filter(i -> i != 0).mapToInt(i -> i).toArray();
    }

}
