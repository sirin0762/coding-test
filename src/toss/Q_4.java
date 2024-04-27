package toss;

public class Q_4 {

    public static void main(String[] args) {

    }

    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료
        double additionalValueAmount = Math.ceil(((double) orderAmount - taxFreeAmount - serviceFee) / 10);
        double orderInsteadPrice = orderAmount + additionalValueAmount - serviceFee;
        if (orderInsteadPrice - taxFreeAmount == 1) return 0;

        return (long) (additionalValueAmount);
    }

}
