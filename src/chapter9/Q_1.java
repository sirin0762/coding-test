package chapter9;

import java.util.HashMap;
import java.util.Map;

public class Q_1 {

    public static void main(String[] args) {

    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.putIfAbsent(name, 0);
            map.put(name, map.get(name) + 1);
        }

        for (String name : completion) {
            int count = map.get(name) - 1;
            map.put(name, count);
            if (count == 0) map.remove(name);
        }

        return map.entrySet().iterator().next().getKey();
    }

}
