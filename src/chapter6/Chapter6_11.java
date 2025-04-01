package Chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chapter6_11 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            students[i] = new Student(input[0], Integer.parseInt(input[1]));
        }

        Arrays.sort(students, (s1, s2) -> s1.score - s2.score);

        Arrays.stream(students).forEach(i -> System.out.println(i.name));

    }

    static class Student {
        public String name;
        public int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
        }

    }


}

