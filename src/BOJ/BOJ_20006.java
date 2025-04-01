package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BOJ_20006 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int p = input[0];
        int m = input[1];

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i ++) {
            String[] strs = br.readLine().split(" ");
            String playerId = strs[1];
            int level = Integer.parseInt(strs[0]);

            if (!enter(rooms, playerId, level, m)) {
                rooms.add(new Room(playerId, level, i));
            }
        }

        for (Room room: rooms) {
            room.players.sort(Comparator.comparing(p2 -> p2.playerId));
            if (room.players.size() == m) {
                bw.write("Started!\n");
            } else {
                bw.write("Waiting!\n");
            }

            room.players.forEach(p1 -> {
                try {
                    bw.write(p1.level + " " + p1.playerId + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        bw.flush();
        bw.close();
    }

    static boolean enter(List<Room> rooms, String playerId, int level, int maxNumber) {
        for (Room room: rooms) {
            if (room.canEnter(level, maxNumber)) {
                room.enter(playerId, level);
                return true;
            }
        }
        return false;
    }

    static class Room {

        List<Player> players = new ArrayList<>();
        int level;
        int time;

        public Room(String playerId, int level, int time) {
            players.add(new Player(playerId, level));
            this.level = level;
            this.time = time;
        }

        public boolean canEnter(int level, int maxNumber) {
            return (this.level - 10 <= level && this.level + 10 >= level) && players.size() < maxNumber;
        }

        public void enter(String playerId, int level) {
            players.add(new Player(playerId, level));
        }

    }

    static class Player {
        String playerId;
        int level;

        public Player(String playerId, int level) {
            this.playerId = playerId;
            this.level = level;
        }

    }

}
