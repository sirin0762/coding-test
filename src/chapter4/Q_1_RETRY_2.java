package chapter4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q_1_RETRY_2 {

    public static void main(String[] args) {
        Q_1_RETRY_2 main = new Q_1_RETRY_2();
        System.out.println(Arrays.toString(main.solution(123456)));
    }

    public int[] solution(long n) {
        int[] answer = new StringBuilder(String.valueOf(n)).reverse().chars().map(i -> i - '0').toArray();
        return answer;
    }

}
