package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q_7_RETRY {

    public static void main(String[] args) {
        Q_7_RETRY main = new Q_7_RETRY();
        System.out.println(Arrays.toString(main.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }

    Map<String, Integer> courseMap;
    List<String> maxCourse = new ArrayList<>();

    // 1. 주어진 문자열들을 쪼개어, dfs를 통해 코스를 만들어 map에 넣는다.
    // 2. 해당 Map을 기반으로 가장 많이 호출된 course들을 담는다.
    // 3. 모두 담은 뒤 오름차순 정렬하여 리턴한다.
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < course.length; i++) {
            int courseCount = course[i];
            courseMap = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                dfs(Arrays.stream(orders[j].split("")).sorted().toArray(String[]::new), "",  0, 0, courseCount);
            }
            findMaxCourse();
        }
        Collections.sort(maxCourse);
        return maxCourse.toArray(String[]::new);
    }

    private void dfs(String[] orders, String order, int index, int start, int max) {
        if (index == max) {
            if (courseMap.containsKey(order)) {
                courseMap.put(order, courseMap.get(order) + 1);
            } else {
                courseMap.put(order, 1);
            }
        }

        for (int i = start; i < orders.length; i++) {
            dfs(orders, order + orders[i], index + 1, i + 1,  max);
        }
    }

    private void findMaxCourse() {
        int max = 0;
        for (Map.Entry<String, Integer> entry: courseMap.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        if (max < 2) return;
        for (Map.Entry<String, Integer> entry: courseMap.entrySet()) {
            if (entry.getValue() == max) maxCourse.add(entry.getKey());
        }
    }

}
