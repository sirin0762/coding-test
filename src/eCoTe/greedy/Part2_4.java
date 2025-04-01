package eCoTe.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 문제명 : 1이 될 때 까지
public class Part2_4 {
    // 1. N에서 1을 뺸다
    // 2. N을 K로 나눈다.
    // -> 어떤 유형인지가 중요. 여기서는 무조건 나누는게 횟수에 좋은 영향을 미치므로 그리디로 판단가능
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        int k = input[1];
        int result = 0;

        while (n != 1) {
            result++;
            if (n % k == 0) n = n / k;
            else n -= 1;
        }

        System.out.println(result);
    }

}
