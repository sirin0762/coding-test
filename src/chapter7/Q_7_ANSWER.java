package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q_7_ANSWER {

    // 1. 주어진 orders 를 통해 완탐으로 정해진 길이의 배열 조합을 모두 만든다.

    List<String[]> everyCourse = new ArrayList<>();

    public static void main(String[] args) {
        Q_7_ANSWER q7 = new Q_7_ANSWER();
        System.out.println(Arrays.toString(q7.solution(
            new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
            new int[]{2,3,5}
        )));
    }

    public String[] solution(String[] orders, int[] course) {
        List<String[]> orderList = Arrays.stream(orders).sorted(Comparator.comparingInt(String::length))
            .map(s -> Arrays.stream(s.split(""))
                .sorted()
                .toArray(String[]::new)
            )
            .collect(Collectors.toList());

        for (String[] order : orderList) {
            for (int length : course) {
                if (order.length >= length) dfs(order, new String[length], 0, 0);
            }
        }

        Map<String, Integer> courseMap = new HashMap<>();
        int[] maxValue = new int[11];

        for (int i = 0; i < everyCourse.size(); i++) {
            String target = String.join("", everyCourse.get(i));
            if (courseMap.containsKey(target)) {
                courseMap.put(target, courseMap.get(target) + 1);
            } else {
                courseMap.put(target, 1);
            }
            maxValue[target.length()] = Math.max(maxValue[target.length()], courseMap.get(target));
        }

        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
            if (maxValue[entry.getKey().length()] == entry.getValue() && entry.getValue() > 1) {
                answer.add(entry.getKey());
            }
        }

        return answer.stream().sorted().toArray(String[]::new);
    }

    private void dfs(String[] origin, String[] target, int start,  int depth) {
        if (depth == target.length) {
            everyCourse.add(target.clone());
            return;
        }
        for (int i = start; i < origin.length; i++) {
            target[depth] = origin[i];
            dfs(origin, target, i + 1, depth + 1);
        }
    }


}
