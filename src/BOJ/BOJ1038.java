package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ1038 {

    static List<Long> list = new ArrayList<>();

    // 1 ~ n까지 진행
    // n까지 감소하는 수를 찾으면 리턴
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 10) {
            System.out.println(n);
            return;
        }

        if (n > 1022) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            dfs(String.valueOf(i));
        }
        Collections.sort(list);
        System.out.println(list.get(n));
    }

    private static void dfs(String str) {
        list.add(Long.parseLong(str));
        int last = str.charAt(str.length() - 1) - '0';
        for (int i = last - 1; i >= 0; i--) {
            dfs(str + i);
        }
    }
}
