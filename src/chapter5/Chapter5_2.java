package chapter5;

import java.util.LinkedList;
import java.util.Queue;

public class Chapter5_2 {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }

}
