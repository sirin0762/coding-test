package programmaers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PRGR_42891 {

    public static void main(String[] args) {
        PRGR_42891 prgr = new PRGR_42891();
        System.out.println(prgr.solution(new int[]{3, 1, 2}, 5)); // 결과: 1
    }

    public int solution(int[] food_times, long k) {
        if (food_times.length == 0) return -1;

        // 전체 음식 수
        int n = food_times.length;

        // 음식 정보 PQ (times 기준 오름차순)
        PriorityQueue<Food> pq = new PriorityQueue<>(Comparator.comparingInt(f -> f.times));
        for (int i = 0; i < n; i++) {
            pq.add(new Food(i + 1, food_times[i]));
        }

        long previousTime = 0;   // 이전 음식의 time
        long remaining = n;      // 남은 음식 수

        while (!pq.isEmpty()) {
            Food current = pq.peek();
            long timeGap = current.times - previousTime;

            if (timeGap == 0) {
                pq.poll(); // 동일한 time 중복 제거
                remaining--;
                continue;
            }

            long cost = timeGap * remaining;
            if (k < cost) break; // 여기서 종료 조건

            k -= cost;
            previousTime = current.times;
            pq.poll();
            remaining--;
        }

        if (pq.isEmpty()) return -1;

        // 남은 음식들을 index 기준 정렬
        List<Food> rest = new ArrayList<>(pq);
        rest.sort(Comparator.comparingInt(f -> f.index));

        return rest.get((int)(k % remaining)).index;
    }

    class Food {
        int index;
        int times;

        public Food(int index, int times) {
            this.index = index;
            this.times = times;
        }
    }
}

