  import java.util.*;

  class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[] sortedNums = nums.clone();
      Arrays.sort(sortedNums);
      int i = 0, j = sortedNums.length - 1;

      while (i < j) {
        int val = sortedNums[i] + sortedNums[j];
        if (val == target) {
          break;
        } else if (val > target) {
          j--;
        } else {
          i++;
        }
      }

      if (i >= j) {
        int[] answer = new int[] { -1, -1 };
        return answer;
      }

      int valI = sortedNums[i];
      int valJ = sortedNums[j];
      int dump = valI - valJ - 1;

      for (int k = 0; k < nums.length; k++) {
        if (nums[k] == valI) {
          i = k;
          nums[k] = dump;
          valI = dump - valI;
        } else if (nums[k] == valJ){
          j = k;
          nums[k] = dump;
          valJ = dump - valJ;
        }
      }

      int[] answer = new int[] { i, j };
      return answer;
    }
  }