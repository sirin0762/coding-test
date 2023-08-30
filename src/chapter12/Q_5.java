package chapter12;

import java.util.stream.IntStream;

public class Q_5 {

    // 1. 주어진 배열을 완탐한다.
        // 1.1 중지조건 : 단어가 target과 같을 때
        // 1.2 진행조건 : 방문여부를 확인하면서 변환

    int answer = (int) 1e9;
    boolean[] visited;

    public static void main(String[] args) {
        Q_5 q5 = new Q_5();
        q5.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer == (int) 1e9 ? 0 : answer;
    }

    private void dfs(String word, String target, String[] words, int depth) {
        if (word.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && oneCharDiff(words[i], word)) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean oneCharDiff(String str1, String str2) {
        return IntStream.range(0, str1.length()).mapToObj(
            i -> str1.charAt(i) == str2.charAt(i)
        ).filter(i -> !i).count() == 1;
    }

}
