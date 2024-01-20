package chapter9;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q_2_RETRY {

    public static void main(String[] args) {

    }

    public String solution(String my_string) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList(my_string.split("")));
        return String.join("", set);
    }

}
