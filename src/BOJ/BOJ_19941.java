package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_19941 {

    public static void main(String[] args) throws IOException {
        // 1. visited 배열 선언
        // 2. 주어진 배열 순회
        // 3. 사람과 햄버거에 대한 greedy 진행
        // 4. visited = true 숫자 세기
        // 5. 리턴

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int k = input[1];

        String map = br.readLine();

        Boolean[] visited = new Boolean[map.length()];
        Arrays.fill(visited, false);

        for (int i = 0; i < map.length(); i++) {
            char c = map.charAt(i);
            if (c == 'H') continue;

            for (int j = -k; j <= k; j++) {

                // 동일대상
                if (j == 0) continue;

                // ArrayIndexException 방지
                if (i + j < 0 || i + j >= map.length()) continue;

                char target = map.charAt(i + j);

                if (target == 'H' && !visited[i + j]) {
                    visited[i + j] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.stream(visited).filter(p -> p).count());
    }

}
