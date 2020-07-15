package 算法思维系列.滑动窗口技巧.题3无重复字符的最长子串;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

/**
 * 窗口函数，配加一个window哈希表
 */
public class Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;

        while (right < s.length()) {
            Character c1 = s.charAt(right);
            if(map.containsKey(c1)){
                while (s.charAt(left) != c1) {
                    map.remove(s.charAt(left));
                    left++;
                }
                left++;
            }else {
                map.put(c1,1);
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res == Integer.MIN_VALUE ? 0: res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}
