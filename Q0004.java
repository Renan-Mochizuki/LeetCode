class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;

    int medianPos = (m + n) / 2;
    boolean isMedianEven = (m + n) % 2 == 0;
    int mergedPos = 0;

    int i1 = 0, i2 = 0;
    int current = 0;

    while (i1 < m && i2 < n) {
      if (mergedPos == medianPos) {
        if (isMedianEven) {
          return (double) (current + Math.min(nums1[i1], nums2[i2])) / 2;
        }
        
        return Math.min(nums1[i1], nums2[i2]);
      }

      if (nums1[i1] < nums2[i2]) { 
        current = nums1[i1];
        i1++;
        mergedPos++;
      } else { 
        current = nums2[i2];
        i2++;
        mergedPos++;
      }
    }

    while (i1 < m) {
      if (mergedPos == medianPos) {
        if (isMedianEven) {
          return (double) (current + nums1[i1]) / 2;
        } else {
          return nums1[i1];
        }
      }

      current = nums1[i1];
      i1++;
      mergedPos++;
    }

    while (i2 < n) {
      if (mergedPos == medianPos) {
        if (isMedianEven) {
          return (double) (current + nums2[i2]) / 2;
        } else {
          return nums2[i2];
        }
      }

      current = nums2[i2];
      i2++;
      mergedPos++;
    }

    return 0;
  }
}
