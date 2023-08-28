package chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q_5_ANSWER {

    // 1. 다리를 지나고
    // 2. 트럭 태우고
    // 3. 시간 지나고

    public static void main(String[] args) {

    }

    public int solution(int bridge_length, int maxWeight, int[] truck_weights) {
        Queue<Truck> queue = new LinkedList<>();
        for (int t : truck_weights) {
            queue.add(new Truck(t));
        }

        List<Truck> bridge = new ArrayList<>();
        int time = 1;
        while (true) {
            // 트럭 다리 지나기
            for (int i = 0; i < bridge.size(); i++) {
                Truck truck = bridge.get(i);
                if (truck.time >= bridge_length) {
                    bridge.remove(i);
                    i--;
                }
            }

            if (queue.isEmpty() && bridge.isEmpty()) {
                break;
            }
            // 트럭 탑승 시키기
            if (!queue.isEmpty()) {
                int currentBridgeWeight = bridge.stream().map(t -> t.weight).mapToInt(i -> i).sum();
                if (currentBridgeWeight + queue.peek().weight <= maxWeight) {
                    bridge.add(queue.poll());
                }
            }

            // 시간 경과
            time++;
            for (Truck truck : bridge) {
                truck.flow();
            }
        }
        return time;
    }

    private static class Truck {
        int weight;
        int time;

        public Truck(int weight) {
            this.weight = weight;
            time = 0;
        }

        public void flow() {
            time++;
        }
    }
}
