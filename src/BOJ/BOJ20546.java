package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ20546 {


    // BNP와 Timing 방식을 계산 한 후, 그 값을 이용하여 정답을 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int[] stockPrices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int bnp = calculateWithBnp(money, stockPrices);
        int timing = calculationWithTiming(money, stockPrices);

        if (bnp > timing) System.out.println("BNP");
        else if (bnp < timing) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }

    // BNP 방식
    private static int calculateWithBnp(int money, int[] stockPrices) {
        int stock = 0;
        for (int stockPrice : stockPrices) {
            stock += money / stockPrice;
            money = money % stockPrice;
        }
        return stockPrices[stockPrices.length - 1] * stock + money;
    }

    // Timing 방식
    private static int calculationWithTiming(int money, int[] stockPrices) {
        int continuousCount = 0;
        int lastStockPrice = 0;
        int stock = 0;
        boolean isUpside = true;
        for (int stockPrice : stockPrices) {
            // 상승세 지속
            if (isUpside && stockPrice >= lastStockPrice) {
                continuousCount++;
            }
            // 하향세 지속
            else if (!isUpside && lastStockPrice >= stockPrice) {
                continuousCount++;
            } else {
                isUpside = !isUpside;
                continuousCount = 1;
            }

            if (continuousCount == 3) {
                // 전량 매도
                if (isUpside) {
                    money += stock * stockPrice;
                    stock = 0;

                }
                // 전량 매수
                else {
                    stock += money / stockPrice;
                    money = money % stockPrice;
                }
            }
            lastStockPrice = stockPrice;
        }
        return money + stock * stockPrices[stockPrices.length - 1];
    }

}
