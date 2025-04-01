package Chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chapter6_12 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            students[i] = new Student(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
        }

        Arrays.sort(students, (s1, s2) -> {
            if (s1.korean == s2.korean && s1.english == s2.english && s1.math == s2.math) {
                return s1.name.compareTo(s2.name);
            }

            if (s1.korean == s2.korean && s1.english == s2.english) {
                return Integer.compare(s2.math, s1.math);
            }

            if (s1.korean == s2.korean) {
                return Integer.compare(s1.english, s2.english);
            }

            return Integer.compare(s2.korean, s1.korean);
        });
        Arrays.stream(students).forEach(i -> System.out.println(i.name));

    }

    static class Student {
        public String name;
        public int korean;
        public int math;
        public int english;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.math = math;
            this.english = english;
        }

    }

}
