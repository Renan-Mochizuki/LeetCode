import java.util.*;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    int l = 0, r = 1;
    int max = 0;

    Map<Character, Integer> map = new HashMap<>();

    if (s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }

    map.put(s.charAt(l), l);

    while (r < s.length()) {
      char right = s.charAt(r);
      if (map.containsKey(right)) {
        int calc = r - l;
        if (calc > max) {
          max = calc;
        }
        while (l < r) {
          char left = s.charAt(l);
          map.remove(left);
          l++;
          if (left == right) {
            break;
          }
        }
        r++;
      } else {
        r++;
      }
      map.put(right, r);
    }

    int calc = r - l;
    if (calc > max) {
      max = calc;
    }

    return max;
  }
}
