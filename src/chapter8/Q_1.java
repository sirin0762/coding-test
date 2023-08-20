package chapter8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q_1 {

    public static void main(String[] args) {
        Q_1 q1 = new Q_1();
        System.out.println(Arrays.toString(q1.solution(
            new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
            new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}
        )));
    }

    public int[] solution(String[] info, String[] query) {
        List<Recruiter> recruiterList = Arrays.stream(info)
            .map(s -> s.split(" "))
            .map(arr -> new Recruiter(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4])))
            .collect(Collectors.toList());

        List<Recruiter> queryList = Arrays.stream(query)
            .map(s -> s.replace(" and ", " ").split(" "))
            .map(arr -> new Recruiter(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4])))
            .collect(Collectors.toList());

        Collections.sort(recruiterList, Comparator.comparingInt(r -> r.score));

        int[] answer = new int[queryList.size()];

        for (int i = 0; i < queryList.size(); i++) {
            int startIndex = getStartIndex(recruiterList, queryList.get(i).score);
            Recruiter queryCondition = queryList.get(i);
            for (int j = startIndex; j < recruiterList.size(); j++) {
                Recruiter recruiter = recruiterList.get(j);

                if (recruiter.satisfy(queryCondition)) answer[i]++;
            }
        }
        return answer;
    }

    private int getStartIndex(List<Recruiter> recruiterList, int target) {
        int start = 0;
        int end = recruiterList.size();
        while (start < end) {
            int mid = (start + end) / 2;
            int score = recruiterList.get(mid).score;
            if (target <= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    private static class Recruiter {
        public String language;
        public String apply;
        public String job;
        public String soulFood;
        public int score;

        public Recruiter(String language, String apply, String job, String soulFood, int score) {
            this.language = language;
            this.apply = apply;
            this.job = job;
            this.soulFood = soulFood;
            this.score = score;
        }

        public boolean satisfy(Recruiter queryCondition) {
            if (!(this.language.equals(queryCondition.language) || queryCondition.language.equals("-"))) return false;
            if (!(this.apply.equals(queryCondition.apply) || queryCondition.apply.equals("-"))) return false;
            if (!(this.job.equals(queryCondition.job) || queryCondition.job.equals("-"))) return false;
            if (!(this.soulFood.equals(queryCondition.soulFood) || queryCondition.soulFood.equals("-"))) return false;
            return this.score >= queryCondition.score;
        }

    }

}
