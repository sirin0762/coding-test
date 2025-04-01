package eCoTe.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Part2_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int k = input[2];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(pq::add);
        /*
        (first * K) * (M / (K + 1)) + (M / (K + 1)) * 세컨드
         */
        int first = pq.poll();
        int second = pq.poll();

        int result = (first * k + second) * (m / (k + 1)) +  (m % (k + 1)) * first;
        System.out.println(result);

    }

}
