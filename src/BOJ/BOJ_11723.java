package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ_11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int number = 0;
            if (!command.equals("all") && !command.equals("empty")) {
                number = Integer.parseInt(input[1]);
            }

            switch (command) {
                case "add":
                    set.add(number);
                    break;
                case "remove":
                    set.remove(number);
                    break;
                case "check":
                    bw.write((set.contains(number) ? 1 : 0) + "\n");
                    break;
                case "toggle":
                    if (set.contains(number)) set.remove(number);
                    else set.add(number);
                    break;
                case "all":
                    set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
