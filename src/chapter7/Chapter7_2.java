package chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chapter7_2 {

    public static int N, M;
    public static int[] numbers, requests;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        M = Integer.parseInt(br.readLine());
        requests = new int[M];
        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            requests[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(numbers);

        for (int request : requests) {
            System.out.println(binarySearch(numbers, request));
        }

    }

    private static String binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return "yes";
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return "no";
    }

}
