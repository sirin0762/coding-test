package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 기적의 매매법
public class BOJ_20546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine());
        int[] stockPrices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ShareHolder bnp = new ShareHolder(cash);
        ShareHolder timing = new ShareHolder(cash);

        int dayOfIncreasing = 0;
        int dayOfDecreasing = 0;

        bnp.buyStock(stockPrices[0]);
        for (int i = 1; i < stockPrices.length; i++) {
            int stockPrice = stockPrices[i];
            int yesterdayStockPrice = stockPrices[i - 1];

            bnp.buyStock(stockPrice);

            if (stockPrice > yesterdayStockPrice) {
                dayOfIncreasing++;
                dayOfDecreasing = 0;
            } else if (stockPrice < yesterdayStockPrice) {
                dayOfDecreasing++;
                dayOfIncreasing = 0;
            }

            if (dayOfIncreasing >= 3) {
                timing.sellStock(stockPrice);
                continue;
            }

            if (dayOfDecreasing >= 3) {
                timing.buyStock(stockPrice);
            }
        }

        int stockPriceOfLastDay = stockPrices[stockPrices.length - 1];

        if (bnp.calculateAsset(stockPriceOfLastDay) > timing.calculateAsset(stockPriceOfLastDay)) {
            System.out.println("BNP");
        } else if (bnp.calculateAsset(stockPriceOfLastDay) < timing.calculateAsset(stockPriceOfLastDay)) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }

    }

    static class ShareHolder {

        int cash;

        int stockCount;

        public ShareHolder(int cash) {
            this.cash = cash;
        }

        public void buyStock(int stockPrice) {
            int buyAmount = cash / stockPrice;
            cash -= buyAmount * stockPrice;
            stockCount += buyAmount;
        }

        public void sellStock(int stockPrice) {
            cash += stockPrice * stockCount;
            stockCount = 0;
        }

        public int calculateAsset(int stockPrice) {
            return cash + stockPrice * stockCount;
        }

    }

}
