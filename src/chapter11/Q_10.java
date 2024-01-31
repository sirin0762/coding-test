package chapter11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q_10 {

    public static void main(String[] args) {
        Q_10 main = new Q_10();
        System.out.println(Arrays.toString(main.solution(new String[]
            {"AA", "AB", "AC", "AA", "AC"}
        )));
    }
    // 1. 주어진 gems를 set을 통해 중복제거를 하여 총 길이를 따둔다.
    // 2. gems로 map을 만들어 투포인터 전략을 진행한다.
        // 1. map.size < set.size 이면, ed를 늘리고, gems[ed]를 map에 담는다.
        // 2. map.size = set.size라면, st - ed 가 가장 작은지 확인한다., 확인 후 st를 1늘리고 gem[st - 1] 을 map에서 제거한다.
    // 3. st ~ ed까지는 어피치가 들고있는 보석 목록이다.
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(List.of(gems));
        Map<String, Integer> map = new HashMap<>();
        int st = 0;
        int ed = 0;
        int s = 0;
        int e = gems.length;
        map.put(gems[st], 1);
        while (true) {
            // 보석을 더 가져와야하는 경우
            if (map.keySet().size() < set.size()) {
                ed++;
                if (ed == gems.length) break;
                map.put(gems[ed], map.getOrDefault(gems[ed], 0) + 1);
            }
            // 보석을 확인해야하는 경우
            else if (map.keySet().size() == set.size()) {
                if (e - s > ed - st) {
                    s = st;
                    e = ed;
                }
                map.put(gems[st], map.get(gems[st]) - 1);
                if (map.get(gems[st]) == 0) map.remove(gems[st]);
                st++;
            }
        }

        return new int[]{s + 1, e + 1};
    }

}
