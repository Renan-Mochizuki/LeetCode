import java.util.*;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    int i = -1, j = -1;

    for (i = 0; i < nums.length; i++) {
      int difference = target - nums[i];
      Integer jValue = map.get(difference);
      if (jValue != null) {
        j = jValue.intValue();
        break;
      }
      map.put(nums[i], i);
    }

    int[] answer = new int[] { i, j };
    return answer;
  }
}