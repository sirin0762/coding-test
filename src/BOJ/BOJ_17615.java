package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17615 {

    // 1. 4가지 케이스에 대해서 최소값을 구한다.
        // 1. 왼파
        // 2. 왼빨
        // 3. 오파
        // 4. 오빨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        int answer = Integer.MAX_VALUE;
        // 1. 왼파 : 처음 빨이 나온 시점부터 파 갯수
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                int blues = 0;
                for (int j = i + 1; j < chars.length; j++) {
                       if (chars[j] == 'B') blues++;
                }
                answer = Math.min(answer, blues);
                break;
            }
        }

        // 2. 왼빨
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'B') {
                int reds = 0;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] == 'R') reds++;
                }
                answer = Math.min(answer, reds);
                break;
            }
        }

        // 3. 오파
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == 'R') {
                int blues = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (chars[j] == 'B') blues++;
                }
                answer = Math.min(answer, blues);
                break;
            }
        }

        // 4. 오빨
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == 'B') {
                int reds = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (chars[j] == 'R') reds++;
                }
                answer = Math.min(answer, reds);
                break;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE? 0: answer);
    }

}
