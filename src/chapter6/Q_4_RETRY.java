package chapter6;

import java.util.HashSet;
import java.util.Set;

public class Q_4_RETRY {

    Set<Integer> primes = new HashSet<>();
    private boolean[] visited;

    public static void main(String[] args) {
        Q_4_RETRY main = new Q_4_RETRY();
        System.out.println(main.solution("011"));
    }

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs(numbers.split(""), "");
        return primes.size();
    }

    private void dfs(String[] split, String s) {
        if (s.length() > split.length) return;

        if (isPrime(s))  primes.add(Integer.parseInt(s));

        for (int i = 0; i < split.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(split, s + split[i]);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(String s) {
        if (s.isEmpty()) return false;
        int target = Integer.parseInt(s);
        if (target < 2) return false;

        for (int i = 2; i <= Math.sqrt(target); i++) {
            if (target % i == 0) return false;
        }
        return true;
    }

}
