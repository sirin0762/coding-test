package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q_7 {

    // 1, course의 길이를 순회한다.
    // 2. orders 배열을 순회한다.
    // 3. 순회하며 CourseCandidate 로 만든다.

    int[] maxCourseCount;

    public static void main(String[] args) {
        Q_7 q7 = new Q_7();
        System.out.println(Arrays.toString(q7.solution(
            new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
            new int[]{2,3,5}
        )));
    }

    public String[] solution(String[] orders, int[] course) {
        String[][] menus = Arrays.stream(orders).sorted(Comparator.comparingInt(String::length))
            .map(s -> s.split(""))
            .toArray(String[][]::new);
        maxCourseCount = new int[course.length];

        List<CourseCandidate> answer = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int count = course[i];
            List<CourseCandidate> candidates = getCourseMenu(menus, count, i);
            final int index = i;
            answer.addAll(candidates.stream().filter(c -> c.count == maxCourseCount[index]).collect(Collectors.toList()));
        }
        return answer.stream()
            .map(candidate -> candidate.course)
            .sorted(String::compareTo)
            .toArray(String[]::new);
    }

    private List<CourseCandidate> getCourseMenu(String[][] menus, int count, int index) {
        List<CourseCandidate> candidates = new ArrayList<>();
        for (int i = 0; i < menus.length; i++) {
            int result = 1;
            if (menus[i].length == count) {
                result += getCourseMenu(menus, menus[i], i);
            }
            if (result >= 2) {
                candidates.add(new CourseCandidate(String.join("", menus[i]), result));
                maxCourseCount[index] = Math.max(maxCourseCount[index], result);
            }
        }
        return candidates;
    }

    private int getCourseMenu(String[][] menus, String[] menu, int start) {
        int result = 0;
        for (int i = start + 1; i < menus.length; i++) {
            if (isContain(menu, menus[i])) result++;
        }
        return result;
    }

    private boolean isContain(String[] target, String[] menu) {
        String s = String.join("", menu);
        for (String value : target) {
            if (!s.contains(value)) return false;
        }
        return true;
    }

    private static class CourseCandidate {
        String course;
        int count;

        public CourseCandidate(String course, int count) {
            this.course = course;
            this.count = count;
        }

    }

}
