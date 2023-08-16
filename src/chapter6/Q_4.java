package chapter6;

import java.util.HashSet;
import java.util.Set;

public class Q_4 {

    boolean[] visited;
    int answer = 0;
    Set<Integer> primes = new HashSet<>();

    public static void main(String[] args) {
        Q_4 q4 = new Q_4();
        System.out.println(q4.solution("011"));
    }

    public int solution(String numbers) {
        String[] strings = numbers.split("");
        int length = strings.length;
        visited = new boolean[length];

        dfs(strings, new StringBuilder(), 0, length);

        return primes.size();
    }

    private void dfs(String[] origin, StringBuilder sb, int depth, int max) {
        if (!sb.toString().isEmpty() && isPrime(Integer.parseInt(sb.toString()))) {
            primes.add(Integer.parseInt(sb.toString()));
        }

        if (depth == max) return;

        for (int i = 0; i < origin.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(origin[i]);
                dfs(origin, sb, depth  + 1, max);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

}
