package chapter13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Q_1 {

    public static void main(String[] args) {
        Q_1 main = new Q_1();
        System.out.println(Arrays.toString(main.solution(
            new String[]{"muzi", "frodo", "apeach", "neo"},
            new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
            2)));
    }

    // 1. 주어진 id_list를 Map<String, Integer> 형태로 만든다.
    // 2. 주어진 report도 Map<String, Set<String>> 형태로 만든다.
    // 3. report를 순회하며, report의 set 의 크기가 k 이상이면 해당 원소를 가져와 id_list_map에 반영한다.
    // 4. id_list_map을 토대로 정답을 도출한다.
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> id_map = new LinkedHashMap<>();
        Arrays.stream(id_list).forEach(id -> id_map.put(id, 0));

        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String r: report) {
            String[] split = r.split(" ");
            reportMap.putIfAbsent(split[1], new HashSet<>());
            reportMap.get(split[1]).add(split[0]);
        }

        for (String key: reportMap.keySet()) {
            if (reportMap.get(key).size() < k) continue;
            for (String target : reportMap.get(key)) {
                id_map.put(target, id_map.get(target) + 1);
            }
        }
        return id_map.values().stream().mapToInt(Integer::intValue).toArray();
    }

}
