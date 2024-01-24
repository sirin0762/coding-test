package chapter9;

import java.util.Arrays;

public class Q_4_RETRY {

    public static void main(String[] args) {

    }

    public int solution(int[] numbers) {
        return 55 - Arrays.stream(numbers).sum();
    }

}
