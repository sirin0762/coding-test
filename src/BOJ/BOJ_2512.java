package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2512 {

    public static void main(String[] args) throws IOException {
        // 이분탐색...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] budgets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int totalBudget = Integer.parseInt(br.readLine());
        int maxBudget = Arrays.stream(budgets).sum();

        if (maxBudget <= totalBudget) {
            Arrays.stream(budgets).max().ifPresent(System.out::println);
            return;
        }

        int left = 0;
        int right = maxBudget;
        int mid = 0;

        // 뱡향: 좌 -> 우
        // 최대값 : 우
        while (left <= right) {
            mid = (left + right) / 2;
            long sumOfBudgets = getSumOfBudget(budgets, mid);
            if (sumOfBudgets <= totalBudget) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        System.out.println(right);
    }

    private static long getSumOfBudget(int[] budgets, int money) {
        long result = 0;
        for (int budget: budgets) {
            result += Math.min(budget, money);
        }
        return result;
    }

}
