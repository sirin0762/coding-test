package chapter7;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q_1 {

    public static void main(String[] args) {
        Q_1 q1 = new Q_1();
        q1.solution(
            new int[]{1, 5, 2, 6, 3, 7, 4},
            new int[][] {
                {2, 5, 3},{4, 4, 1},{1, 7, 3}
            }
        );

    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int start = command[0];
            int end = command[1];
            int target = command[2];
            answer[i] = Arrays.stream(array, start - 1, end).sorted().toArray()[target - 1];
        }
        return answer;
    }

}
