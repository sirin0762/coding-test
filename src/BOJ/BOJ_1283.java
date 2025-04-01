package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1283 {

    // 1. 주어진 단어를 split
    // 2. 단어를 기준으로 첫단어에 대해서 단축키 지정 확인
    // 3. 단축키 지정 유무
        // 3.1 단축키 지정 유 : 다음 명령어로,
        // 3.2 단축키 지정 무 : 앞에서 부터 진행

    static List<String> commands = new ArrayList<>();
    static boolean[] shortKey;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        shortKey = new boolean[26];

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            // 1.
            String[] splitCommand = command.split(" ");

            // 2.
            boolean isDesignated = designateSplitedCommand(splitCommand);

            // 3.1
            if (isDesignated) continue;

            // 3.2
            commands.add(designateNotSplitedCommand(command));
        }

        commands.forEach(System.out::println);
    }

    private static boolean designateSplitedCommand(String[] splitCommand) {
        boolean isDesignated = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitCommand.length; i++) {
            String sc = splitCommand[i];
            if (isDesignated) {
                sb.append(sc).append(" ");
                continue;
            }

            char firstLetter = sc.charAt(0);
            int index = Character.toUpperCase(firstLetter) - 'A';
            if (shortKey[index]) {
                sb.append(sc).append(" ");
            }
            else {
                shortKey[index] = true;
                isDesignated = true;
                sb.append(sc.replaceFirst(String.valueOf(firstLetter), "[" + firstLetter + "]")).append(" ");
            }
        }
        if (isDesignated)  commands.add(sb.toString());
        return sb.toString().contains("[");
    }

    private static String designateNotSplitedCommand(String command) {
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (Character.isWhitespace(c)) continue;
            int index = Character.toUpperCase(c) - 'A';
            if (!shortKey[index]) {
                String leftSide = command.substring(0, i);
                String rightSide = command.substring(i + 1);
                String replaced = "[" + c + "]";
                shortKey[index] = true;
                return leftSide + replaced + rightSide;
            }
        }
        return command;
    }

}
