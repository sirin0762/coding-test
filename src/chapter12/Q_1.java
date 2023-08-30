package chapter12;

import java.util.Arrays;

public class Q_1 {

    public static void main(String[] args) {
        Q_1 q1 = new Q_1();
        q1.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }

    public int solution(String skill, String[] skill_trees) {
        String regex = "[^" + skill + "]";
        return (int) Arrays.stream(skill_trees).map(
            s -> s.replaceAll(regex, "")
        ).filter(skill::startsWith).count();
    }

}
