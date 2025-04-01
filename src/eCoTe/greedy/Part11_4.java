package eCoTe.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 만들 수 없는 금액
public class Part11_4 {

    // 1. 최소 힙으로 정렬
    // 2. 금액 더하기
    // 3. 내가 가진 코인이거나, 그 코인으로 만들수 있는 숫자 범위 아래면
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(coins);

        int target = 1;

        for (int coin: coins) {
            if (target < coin) {
                break;
            } else {
                target += coin;
            }
        }
        System.out.println(target);
    }

}
