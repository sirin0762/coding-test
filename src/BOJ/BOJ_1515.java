package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int index = 0;
        for (int i = 1; i < 30000; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                char target = input.charAt(index);
                if (str.charAt(j) == target) {
                    index++;
                }
                if (index == input.length()) {
                    System.out.println(i);
                    return;
                }
            }

        }

    }

}
