package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// 박스 채우기
public class BOJ_1493 {

    static boolean[][][] box;

    static int X, Y, Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        X = input[0];
        Y = input[1];
        Z = input[2];
        box = new boolean[input[0]][input[1]][input[2]];

        int n = Integer.parseInt(br.readLine());
        List<Cube> cubeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cubeList.add(new Cube((int) Math.pow(2, input[0]), input[1]));
        }

        cubeList.sort((c1, c2) -> Integer.compare(c2.length, c1.length));

        AtomicInteger answer = new AtomicInteger();

        cubeList.forEach((cube) -> {
            for (int i = 0; i < cube.count; i++) {
                Node node = getPossiblePosition(cube);
                if (node == null) break;
                putCubeIntoBox(cube, node);
                answer.getAndIncrement();
            }
        });

        if (isImpossibleToFillOut(box)) {
            System.out.println(-1);
        } else {
            System.out.println(answer.get());;
        }

    }

    private static boolean isImpossibleToFillOut(boolean[][][] box) {
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                for (int k = 0; k < box[0][0].length; k++) {
                    if (!box[i][j][k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void putCubeIntoBox(Cube cube, Node node) {
        for (int i = node.x; i < node.x + cube.length; i++) {
            for (int j = node.y; j < node.y + cube.length; j++) {
                for (int k = node.z; k < node.z + cube.length; k++) {
                    box[i][j][k] = true;
                }
            }
        }
    }

    private static Node getPossiblePosition(Cube cube) {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < Z; k++) {
                    if (box[i][j][k]) continue;
                    if (getPossiblePosition(i, j, k, cube.length)) {
                        return new Node(i, j, k);
                    }
                }
            }
        }
        return null;
    }

    private static boolean getPossiblePosition(int x, int y, int z, int length) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                for (int k = z; k < z + length; k++) {
                    if (i >= X  || j >= Y || k >= Z || box[i][j][k]) return false;
                }
            }
        }
        return true;
    }

    static class Cube {
        int length;
        int count;

        public Cube(int length, int count) {
            this.length = length;
            this.count = count;
        }

    }

    static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }

}
