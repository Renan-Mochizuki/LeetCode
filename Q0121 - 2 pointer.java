class Solution {
  public int maxProfit(int[] prices) {
    int l = 0, r = 0;
    int max = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < prices[l]) {
        l = i;
        if (r < l) {
          r = i;
        }
      }
      if (prices[i] > prices[r]) {
        r = i;
      }
      int profit = prices[r] - prices[l];
      if (profit > max) {
        max = profit;
      }
    }
    return max;
  }
}