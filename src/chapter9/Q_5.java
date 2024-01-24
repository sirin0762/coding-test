package chapter9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Q_5 {

    public static void main(String[] args) {

    }

    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!Objects.equals(participant[i], completion[i])) return participant[i];
        }
        return participant[participant.length - 1];
    }

}
