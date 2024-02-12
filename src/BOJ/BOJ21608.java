package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BOJ21608 {

    private final static int EMPTY = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] table = new int[n][n];
        Map<Integer, Set<Integer>> friendsMap = new LinkedHashMap<>();

        for (int i = 0; i < n * n; i++) {
            String[] split = br.readLine().split(" ");
            int key = 0;
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(split[j]);

                if (j == 0) {
                    friendsMap.put(num, new HashSet<>());
                    key = num;
                } else {
                    friendsMap.get(key).add(num);
                }
            }
        }

        for (int target: friendsMap.keySet()) {
            table = setProperSeat(table, target, friendsMap.get(target));
        }
        int answer = 0;
        for (int i = 0; i < table.length; i++) {
            for(int j = 0; j < table.length; j++) {
                answer += getScore(i, j, table, friendsMap);
            }
        }
        System.out.println(answer);
    }

    private static int getScore(int x, int y, int[][] table, Map<Integer, Set<Integer>> friendsMap) {
        int target = table[x][y];
        int result = 0;
        Set<Integer> friends = friendsMap.get(target);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= table.length || ny >= table.length) continue;
            if (friends.contains(table[nx][ny])) result++;
        }
        return (int) Math.pow(10, result - 1);
    }

    private static int[][] setProperSeat(int[][] table, int target, Set<Integer> friends) {
        List<Node> candidates = new ArrayList<>();
        int maxFriendCount = 0;
        // 인접한 학생 찾기
        for (int i = 0; i < table.length; i++) {
            for(int j = 0; j < table.length; j++) {
                Node candidate = new Node(i, j);
                if (table[candidate.x][candidate.y] != EMPTY) continue;
                int friendCount = getFriendCount(table, candidate, friends);
                if (friendCount > maxFriendCount) {
                    maxFriendCount = friendCount;
                    candidates = new ArrayList<>();
                    candidates.add(candidate);
                } else if (friendCount == maxFriendCount) {
                    candidates.add(candidate);
                }
            }
        }

        if (candidates.size() == 1) {
            Node properSeat = candidates.get(0);
            table[properSeat.x][properSeat.y] = target;
            return table;
        }

        // 비어있는 값
        candidates = getMostOfEmptySeat(candidates, table);

        if (candidates.size() == 1) {
            Node properSeat = candidates.get(0);
            table[properSeat.x][properSeat.y] = target;
            return table;
        }

        // 행
        candidates.sort(Comparator.comparingInt(n -> n.x));
        int properRow = candidates.get(0).x;
        candidates = candidates.stream().filter(node -> node.x == properRow).collect(Collectors.toList());

        if (candidates.size() == 1) {
            Node properSeat = candidates.get(0);
            table[properSeat.x][properSeat.y] = target;
            return table;
        }

        // 열
        candidates.sort(Comparator.comparingInt(n -> n.y));
        Node properSeat = candidates.get(0);
        table[properSeat.x][properSeat.y] = target;
        return table;
    }

    private static List<Node> getMostOfEmptySeat(List<Node> candidates, int[][] table) {
        List<Node> result = new ArrayList<>();
        int maxEmptyCount = 0;
        for (Node candidate: candidates) {
            int emptyCount = getEmptyCount(candidate, table);
            if (emptyCount > maxEmptyCount) {
                result = new ArrayList<>();
                result.add(candidate);
                maxEmptyCount = emptyCount;
            } else if (emptyCount == maxEmptyCount) {
                result.add(candidate);
            }
        }
        return result;
    }

    private static int getEmptyCount(Node candidate, int[][] table) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nx = candidate.x + dx[i];
            int ny = candidate.y + dy[i];

            if (nx < 0 || ny < 0 || nx >= table.length || ny >= table.length) continue;
            if (table[nx][ny] == EMPTY) result++;
        }
        return result;
    }

    private static int getFriendCount(int[][] table, Node candidate, Set<Integer> friends) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nx = candidate.x + dx[i];
            int ny = candidate.y + dy[i];

            if (nx < 0 || ny < 0 || nx >= table.length || ny >= table.length) continue;
            if (friends.contains(table[nx][ny])) result++;
        }
        return result;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
