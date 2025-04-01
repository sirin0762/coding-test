package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chapter3_03 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 0 -> 1
        int zeroCount = 0;
        // 1 -> 0
        int oneCount = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) continue;
            else {
                if (str.charAt(i) == '0') zeroCount++;
                else oneCount++;
            }
        }

        if (str.charAt(str.length() - 1) == '0') zeroCount++;
        else oneCount++;

        System.out.println(Math.min(zeroCount, oneCount));
    }

}
