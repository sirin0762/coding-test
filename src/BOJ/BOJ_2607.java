package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_2607 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Word target = new Word(br.readLine());
        List<Word> words = new ArrayList<>();

        for (int i = 1; i < count; i++) {
            words.add(new Word(br.readLine()));
        }

        System.out.println(words.stream().filter(target::isSimilarWord).count());
    }

    static class Word {

        private Map<Character, Integer> wordMap;
        private String originString;

        public Word(String str) {
            wordMap = new HashMap<>();
            for (char c: str.toCharArray()) {
                wordMap.putIfAbsent(c, 0);
                wordMap.put(c, wordMap.get(c) + 1);
            }
            originString = str;
        }

        // 이게 문제
        public boolean isSimilarWord(Word other) {
            int result = 0;

            // other 기준
            for (Map.Entry<Character, Integer> entry: other.wordMap.entrySet()) {
                Character key = entry.getKey();
                result += Math.abs(this.wordMap.getOrDefault(key, 0) - entry.getValue());
            }

            // this 기준
            for (Character key: this.wordMap.keySet()) {
                if (!other.wordMap.containsKey(key)) {
                    result += this.wordMap.get(key);
                }
            }
            return result <= 2 && Math.abs(this.originString.length() - other.originString.length()) <= 1;
        }

    }

}
