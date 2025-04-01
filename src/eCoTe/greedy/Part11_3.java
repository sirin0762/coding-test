package eCoTe.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 뒤집기
public class Part11_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] nums = new int[2];

        nums[input.charAt(0) - '0'] = 1;

        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != input.charAt(i - 1)) {
                nums[ch - '0']++;
            }
        }
        System.out.println(Math.max(nums[0], nums[1]));
    }

}
