package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ_22233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];

        Set<String> memos = new HashSet<>();
        for (int i = 0; i < n; i++) {
            memos.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String[] keywords = br.readLine().split(",");
            for (String keyword: keywords) {
                memos.remove(keyword);
            }
            System.out.println(memos.size());
        }
    }

}
