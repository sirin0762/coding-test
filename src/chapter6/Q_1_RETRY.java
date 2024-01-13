package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_1_RETRY {

    int[] first = {1, 2, 3, 4, 5};
    int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static void main(String[] args) {
        Q_1_RETRY main = new Q_1_RETRY();
        System.out.println(Arrays.toString(main.solution(new int[] {
            1,2,3,4,5
        })));
    }

    public int[] solution(int[] answers) {
        int[] result = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (first[i % 5] == answers[i]) result[0]++;
            if (second[i % 8] == answers[i]) result[1]++;
            if (third[i % 10] == answers[i]) result[2]++;
        }

        int max = 0;
        for (int i = 0; i < result.length; i++) {
            max = Math.max(max, result[i]);
        }

        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if (max == result[i]) winners.add(i + 1);
        }
        return winners.stream().mapToInt(i -> i).toArray();
    }

}
