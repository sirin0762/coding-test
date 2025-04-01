package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1522 {

    // 1. b를 기준으로 순회.
    // 2. b와 연결되지 않은 b를 조사
    // 3. 이 중, 가장 적게 연결된 b가 정답
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int total = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') total++;
        }

        int aMax = 0;
        for (int i = 0; i < chars.length; i++) {
            int aCnt = 0;
            for (int j = 0; j < total; j++) {
                int index = (i + j) % chars.length;
                if (chars[index] == 'a') aCnt++;
            }
            if (aCnt > aMax) aMax = aCnt;
        }

        System.out.println(total - aMax);
    }

}
