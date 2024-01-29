package chapter11;

import java.util.PriorityQueue;

public class Q_8 {

    public static void main(String[] args) {
        Q_8 main = new Q_8();
    }

    // 1. 이중 순위 큐 구현
    // 2. 사이즈가 0일 때는 clear 해줘야함
    public int[] solution(String[] operations) {
        DoublePriorityQueue queue = new DoublePriorityQueue();
        for (String op: operations) {
            String[] split = op.split(" ");
            if (split[0].equals("I")) {
                int number = Integer.parseInt(split[1]);
                queue.insert(number);
            } else {
                if (split[1].startsWith("-")) {
                    queue.deleteMinNumber();
                } else {
                    queue.deleteMaxNumber();
                }
            }
        }
        return queue.result();
    }

    static class DoublePriorityQueue {
        int size = 0;
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        void insert(int number) {
            maxQ.add(number);
            minQ.add(number);
            size++;
        }

        void deleteMaxNumber() {
            if (size == 0) return;
            maxQ.poll();
            if (--size == 0) {
                maxQ.clear();
                minQ.clear();
            }
        }

        void deleteMinNumber() {
            if (size == 0) return;
            minQ.poll();
            if (--size == 0) {
                maxQ.clear();
                minQ.clear();
            }
        }

        int[] result() {
            if (size == 0) {
                return new int[]{0, 0};
            } else {
                return new int[]{maxQ.peek(), minQ.peek()};
            }
        }
    }

}
