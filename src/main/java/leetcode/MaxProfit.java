package leetcode;

import utils.ArrayUtils;

public class MaxProfit {
    /**
     * 122. 买卖股票的最佳时机 II
     * <p>
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     */

    public static void main(String[] args) {

        MaxProfit maxProfit = new MaxProfit();
        int[] ints = ArrayUtils.transStringToArray("7,6,4,3,1");

        int profit = maxProfit.maxProfit(ints);
        System.out.println(profit);
    }

    private int maxProfit(int[] prices) {
        int buy = -1;
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (buy < 0 && prices[i + 1] > prices[i]) {
                buy = i;
            } else if (buy >= 0 && prices[i + 1] < prices[i]) {
                profit = profit + prices[i] - prices[buy];
                buy = -1;
            }
        }

        if (buy >= 0) {
            profit = profit + prices[prices.length - 1] - prices[buy];
        }

        return profit;
    }
}
