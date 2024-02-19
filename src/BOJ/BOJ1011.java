package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1011 {

    // k[i] = Math.min(k)
    // 유형 : 그리디?
    // 1. 가능한 한 가장 긴 길이로 이동한다.
    // 2. 해당 길이와 도착지까지의 거리를 계산하여, 남은 거리 안에 1로 만들수 있는걸 계산한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            solve(br);
        }
        
    }

    private static void solve(BufferedReader br) throws IOException {
        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        int dist = end - start;

        int sqrt = (int) Math.sqrt(dist);
        if (dist == sqrt * sqrt) System.out.println(2 * sqrt - 1);
        else if (dist <= sqrt * sqrt + sqrt) System.out.println(2 * sqrt);
        else System.out.println(2 * sqrt + 1);
    }

}
