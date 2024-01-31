package chapter13;

import java.util.Arrays;

public class Q_2 {

    public static void main(String[] args) {
        Q_2 main = new Q_2();
        System.out.println(main.solution(437674, 3));
    }


    // 1. 주어진 n을 k진수로 변환한다.
    // 2. 0을 기준으로 split을 진행한다.
    // 3. 각 token에 대해서 소수 여부를 확인한다.
    // 4. 그 결과를 리턴한다.
    public int solution(int n, int k) {
        String number = Long.toString(n, k);
        long[] split = Arrays.stream(number.split("0+")).mapToLong(Long::parseLong).toArray();
        int answer = 0;
        for (long target: split) {
            if (isPrime(target)) answer++;
        }

        return answer;
    }

    private boolean isPrime(long v) {
        if (v <= 1) return false;

        for (long i = 2; i * i <= v; i++) {
            if (v % i == 0) return false;
        }
        return true;
    }

}
