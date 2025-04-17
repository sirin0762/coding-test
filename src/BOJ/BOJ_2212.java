package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// 센서
public class BOJ_2212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(sensors);

        int[] diffs = IntStream.range(1, N).map(i -> sensors[i] - sensors[i - 1]).sorted().toArray();
        long answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += diffs[i];
        }
        System.out.println(answer);
    }

}
