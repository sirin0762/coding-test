package chapter6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q_5_ANSWER {

    public static void main(String[] args) {
        Q_5_ANSWER q5 = new Q_5_ANSWER();
        q5.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"});
    }

    public int solution(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id).map(id -> id.replace("*", "."))
            .map(banned -> Arrays.stream(user_id)
                .filter(id -> id.matches(banned))
                .toArray(String[]::new))
            .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();

        dfs(0, new HashSet<>(), bans, banSet);

        return banSet.size();
    }

    private void dfs(int depth, HashSet<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if (depth == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }
        for (int i = 0; i < bans[depth].length; i++) {
            if (!banned.contains(bans[depth][i])) {
                banned.add(bans[depth][i]);
                dfs(depth + 1, banned, bans, banSet);
                banned.remove(bans[depth][i]);
            }
        }
    }

}
