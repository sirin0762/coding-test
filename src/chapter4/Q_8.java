package chapter4;

import java.util.HashMap;
import java.util.Map;

public class Q_8 {

    // 1. 각 영어 단어에 맞는 숫자를 Map, 또는 배열에 담는다.
    // 2.

    public static void main(String[] args) {

    }

    public int solution(String s) {
        Map<String, Integer> numberMap = Map.of(
            "zero", 0,
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
        );
        for (Map.Entry<String, Integer> entry: numberMap.entrySet()) {
            s = s.replaceAll(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return Integer.parseInt(s);
    }

}
