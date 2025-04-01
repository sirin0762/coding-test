package toss;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_2 {

    public ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public boolean[] visited;
    public int alreadyFriend = 0;
    public int newFriend = 0;

    public static void main(String[] args) {
        Problem_2 solution = new Problem_2();
        System.out.println(solution.solution(new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 2, 3));
    }

    public int solution(int[][] relationships, int target, int limit) {
        drawGraph(relationships);
        dfs(target, 0, limit + 1);
        return alreadyFriend * 5 + newFriend * 10 + newFriend;
    }

    private void drawGraph(int[][] arr) {
        for (int i = 0; i < 101; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[101];

        for (int i = 0; i < arr.length; i++) {
            int[] relation = arr[i];
            int start = relation[0];
            int end = relation[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
    }

    private void dfs(int start, int depth, int limit) {
        if (depth == limit) {
            return;
        }

        if (depth == 1) {
            alreadyFriend++;
        } else if (depth != 0){
            newFriend++;
        }
        visited[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (!visited[next]) dfs(next, depth + 1, limit);
        }
    }

}
