package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20310 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int countOfZero = (int) s.chars().filter(c -> c == '0').count();
        int countOfOne = (int) s.chars().filter(c -> c == '1').count();

        boolean[] deleted = new boolean[s.length()];


        // 1삭제
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count == countOfOne / 2) {
                break;
            }
            if (s.charAt(i) == '1') {
                count += 1;
                deleted[i] = true;
            }
        }

        // 0 삭제
        count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count == countOfZero / 2) {
                break;
            }
            if (s.charAt(i) == '0') {
                count += 1;
                deleted[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!deleted[i]) sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
    }

}
