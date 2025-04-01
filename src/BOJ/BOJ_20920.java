package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BOJ_20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = input[0];
        int atLeastWordLength = input[1];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String word = br.readLine();
            if (word.length() < atLeastWordLength) continue;

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((e1, e2) -> {
            if (!Objects.equals(e1.getValue(), e2.getValue())) return Integer.compare(e2.getValue(), e1.getValue());
            if (e1.getKey().length() != e2.getKey().length()) return Integer.compare(e2.getKey().length(), e1.getKey().length());
            return e1.getKey().compareTo(e2.getKey());
        });

        entries.forEach((e) -> {
            try {
                bw.write(e.getKey() + "\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bw.flush();
        bw.close();
    }

}
