package chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chatper7_4 {

    public static int N, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        target = Integer.parseInt(input[1]);
        int max = 0;

        input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(input[i]);
            max = Math.max(max, temp);
            arr[i] = temp;
        }

        System.out.println(binarySearch(arr, max));

    }

    private static int binarySearch(int[] arr, int end) {
        int start = 0;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (cal(arr, mid) >= target) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private static int cal(int[] arr, int mid) {
        int result = 0;
        for (int j : arr) {
            result += Math.max(0, j - mid);
        }
        return result;
    }

}
