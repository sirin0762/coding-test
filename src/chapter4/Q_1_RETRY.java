package chapter4;

import chapter4.Q_1_RETRY;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q_1_RETRY {

    public static void main(String[] args) {
        Q_1_RETRY main = new Q_1_RETRY();
        main.solution(123456);
    }

    public int[] solution(long n) {
        char[] reversedChars = new StringBuilder(String.valueOf(n)).reverse().toString().toCharArray();
        int[] answer = new int[reversedChars.length];
        for (int i = 0; i < reversedChars.length; i++) {
            answer[i] = reversedChars[i] - '0';
        }
        return answer;
    }

}
