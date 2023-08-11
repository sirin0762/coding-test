package chapter4;

import java.util.Arrays;

public class Q_1 {

    public static void main(String[] args) {

    }

    public int[] solution(long n) {
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();

        int[] answer = new int[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[i] - '0';
        }

        return answer;
    }

}
