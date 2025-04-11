package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1449 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int L = input[1];

        int[] spots = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(spots);

        int tapePosition = 0;
        int tapeCount = 0;
        for (int i = 0; i < N; i++) {
            int spot = spots[i];

            if (spot + 1 > tapePosition) {
                tapePosition = spot + L;
                tapeCount++;
            }
        }
        System.out.println(tapeCount);
    }

}
