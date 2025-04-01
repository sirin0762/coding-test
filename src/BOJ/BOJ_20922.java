package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_20922 {

    // 1. 투포인터를 설정한다.
    // 2. 진행한다.
        // 1. K가 충족되지 않을 때 -> 오른쪽으로 넓힘
        // 2. K가 충분할 떄 -> K가 빠질때까지 계속이동
    // 3. 종료조건 : 우측 포인터가 마지막일떄가지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int K = input[1];
        int[] numberCounts = new int[200001];

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int right = 0;
        int length = 0;
        int answer = 0;

        while (right < numbers.length) {
            int target = numbers[right];
            if (numberCounts[target] == K) {
                while (numberCounts[target] == K) {
                    int leftNumber = numbers[left];
                    numberCounts[leftNumber]--;
                    left++;
                    length--;
                }
            }
            numberCounts[target]++;
            right++;
            length++;
            answer = Math.max(answer, length);
        }

        System.out.println(answer);
    }

}
