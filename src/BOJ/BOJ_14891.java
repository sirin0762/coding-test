package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

// 톱니바퀴
public class BOJ_14891 {

    static int leftSide = 6;
    static int rightSide = 2;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<LinkedList<Character>> circles = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            circles.add(br.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(LinkedList::new)));
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int target = input[0];
            int direction = input[1];
            isVisited = new boolean[4];
            rotate(circles, target - 1, direction);
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (circles.get(i).get(0) == '0') continue;
            answer += (int) Math.pow(2, i);
        }
        System.out.println(answer);
    }

    private static void rotate(ArrayList<LinkedList<Character>> circles, int target, int direction) {
        LinkedList<Character> circle = circles.get(target);
        isVisited[target] = true;
        if (target == 0) {
            LinkedList<Character> rightSideCircle = circles.get(target + 1);
            if (circle.get(rightSide) != rightSideCircle.get(leftSide) && !isVisited[target + 1]) {
                rotate(circles, target + 1, direction * -1);
            }
        } else if (target == 3) {
            LinkedList<Character> leftSideCircle = circles.get(target - 1);
            if (circle.get(leftSide) != leftSideCircle.get(rightSide) && !isVisited[target - 1]) {
                rotate(circles, target - 1, direction * -1);
            }
        } else if (target == 1 || target == 2) {
            LinkedList<Character> leftSideCircle = circles.get(target - 1);
            if (circle.get(leftSide) != leftSideCircle.get(rightSide) && !isVisited[target - 1]) {
                rotate(circles, target - 1, direction * -1);
            }

            LinkedList<Character> rightSideCircle = circles.get(target + 1);
            if (circle.get(rightSide) != rightSideCircle.get(leftSide) && !isVisited[target + 1]) {
                rotate(circles, target + 1, direction * -1);
            }
        } else {
            return;
        }
        if (direction == 1) {
            Character last = circle.pollLast();
            circle.addFirst(last);
        } else {
            Character first = circle.pollFirst();
            circle.addLast(first);
        }

    }


}
