package chapter8;

public class Main {

    public static long[] d = new long[100];

    public static void main(String[] args) {
        System.out.println(buttomUp(50));
    }

    public static long fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        if (d[x] != 0) {
            return d[x];
        }

        d[x] =  fibo(x - 1) + fibo(x - 2);
        System.out.println(d[x]);
        return d[x];
    }

    public static long buttomUp(int x) {
        d[1] = 1;
        d[2] = 1;
        for (int i = 3; i <= x; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[x];
    }

}
