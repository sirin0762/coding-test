package eCoTe.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "0001100";
        Pattern pattern = Pattern.compile("(0+|1+)");
        Matcher matcher = pattern.matcher(input);

        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }

        System.out.println(result); // [000, 11, 00]
    }
}