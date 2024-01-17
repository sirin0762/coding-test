package chapter8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q_1_RETRY {

    public static void main(String[] args) {
        Q_1_RETRY main = new Q_1_RETRY();
        System.out.println(Arrays.toString(main.solution(
            new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
            new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}
        )));
    }
    // 1. 점수를 기반으로 이진탐색을 한다.
    // 2. 이진 탐색된 걸 기반으로 순회를 한다.
    // 3. 조건에 만족하는 지원자를 찾는다.
    public int[] solution(String[] info, String[] query) {
        List<Developer> developers = Arrays.stream(info)
            .map(i -> i.split(" "))
            .map(i -> new Developer(i[0], i[1], i[2], i[3], Integer.parseInt(i[4])))
            .sorted(Comparator.comparingInt(d -> d.testScore))
            .collect(Collectors.toList());

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] array = query[i].split(" and | ");
            int index = findIndex(developers, array);
            int passedCount = 0;
            for (int j = index; j < developers.size(); j++) {
                Developer developer = developers.get(j);
                if (developer.isPass(array)) passedCount++;
            }
            answer[i] = passedCount;

        }

        return answer;
    }

    private int findIndex(List<Developer> developers, String[] array) {
        int start = 0;
        int end = developers.size() - 1;
        int target = Integer.parseInt(array[4]);

        while (start < end) {
            int mid = (start + end) / 2;
            int value = developers.get(mid).testScore;
            if (value >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static class Developer {
        String language;
        String work;
        String workPeriod;
        String soulFood;
        int testScore;

        public Developer(String language, String work, String workPeriod, String soulFood, int testScore) {
            this.language = language;
            this.work = work;
            this.workPeriod = workPeriod;
            this.soulFood = soulFood;
            this.testScore = testScore;
        }

        public boolean isPass(String[] array) {
            return (language.equals(array[0]) || array[0].equals("-"))
                && (work.equals(array[1]) || array[1].equals("-"))
                && (workPeriod.equals(array[2]) || array[2].equals("-"))
                && (soulFood.equals(array[3]) || array[3].equals("-"));
        }

    }

}
