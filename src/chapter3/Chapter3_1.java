package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chapter3_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] coins = new int[]{500, 100, 50, 10};

        for (int coin: coins) {
            answer += money / coin;
            money = money % coin;
        }

        System.out.println(answer);
    }

}
