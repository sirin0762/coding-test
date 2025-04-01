package eCoTe.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 모험가 길드
public class Part11_1 {

    // 공포도가 X이면 X명이상으로 구성
    // 몇개의 그룹이 묶이는가가 중요
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(pq::add);

        // 1. pq를 조회
        // 2. 해당 인원의 공포도에 따른 인원 전달
        // 3. 그룹 카운트 증가
        int result = 0;
        while (true) {
            int scary = pq.poll();
            if (scary >= pq.size()) break;

            for (int i = 1; i < scary; i++) {
                pq.poll();
            }
            result += 1;
        }
        System.out.println(result);
    }

}
