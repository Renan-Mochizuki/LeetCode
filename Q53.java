class Solution {
  public int maxSubArray(int[] nums) {
    int max = nums[0];
    int current = nums[0];

    for (int i = 1; i < nums.length; i++) {
      current = current + nums[i];
      if (nums[i] > current) {
        current = nums[i];
      }

      if (current > max) {
        max = current;
      }
    }

    return max;
  }
}