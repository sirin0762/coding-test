package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String regex = br.readLine();
        int length = text.length();
        text = text.replace(regex, "");
        System.out.println((length- text.length()) / regex.length());
    }

}
