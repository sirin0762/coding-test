package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1138 {

    /*
    1. 앞에서 부터 순회
    2. 주어진 숫자만큼 뒤로 이동
    3. 뒤로 이동 중, 숫자가 더 크면 무시
     */
    static int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[input.length];
        Arrays.fill(arr, INF);

        for (int i = 0; i < input.length; i++) {
            int height = i + 1;
            int leftPeople = input[i];

            boolean breaker = false;
            for (int j = 0; j < input.length; j++) {
                if (leftPeople == 0) {
                    for (int k = j; k < input.length; k++) {
                        if (arr[k] == INF) {
                            arr[k] = height;
                            breaker = true;
                            break;
                        }
                    }
                }

                if (breaker) {
                    breaker = false;
                    break;
                }

                if (arr[j] > height) {
                    leftPeople -= 1;
                }
            }
        }
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

}
