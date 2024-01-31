package chapter13;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Q_3 {

    public static void main(String[] args) {
        Q_3 main = new Q_3();
        System.out.println(Arrays.toString(main.solution(
            new int[]{180, 5000, 10, 600},
            new String[]{
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"}
        )));
    }


    // 1. 주어진 records를 Map<String, List<LocalTime> 으로 둔다
    // 2. 답을 위한 Map을 LinkedHashMap으로 두고, 이를 정렬한뒤에 value를 리턴받는다.
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<LocalTime>> recordsMap = new HashMap<>();
        Map<String, Integer> answer = new TreeMap<>();
        for (String r: records) {
            String[] split = r.split(" ");
            LocalTime time = LocalTime.parse(split[0]);
            String carNumber = split[1];
            recordsMap.putIfAbsent(carNumber, new ArrayList<>());
            recordsMap.get(carNumber).add(time);
        }

        recordsMap.values().forEach(Collections::sort);

        for (String key: recordsMap.keySet()) {
            List<LocalTime> times = recordsMap.get(key);
            int time = 0;
            for (int i = 0; i < times.size(); i+=2) {
                if (i == times.size() - 1) {
                    time += (int) Duration.between(times.get(i), LocalTime.parse("23:59")).toMinutes();
                } else {
                    time += (int) Duration.between(times.get(i), times.get(i + 1)).toMinutes();
                }
            }
            int money = 0;
            // 기분시간보다 작으면
            if (time <= fees[0]) {
                // 기본요금
                money = fees[1];
            } else {
                money = fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            }
            answer.put(key, money);
        }

        return answer.values().stream().mapToInt(Integer::intValue).toArray();
    }


}
