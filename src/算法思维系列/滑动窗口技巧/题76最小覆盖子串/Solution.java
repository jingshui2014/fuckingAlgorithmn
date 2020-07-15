package 算法思维系列.滑动窗口技巧.题76最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static String minWindow(String s, String t) {
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            if (mapt.containsKey(t.charAt(i))) {
                mapt.put(t.charAt(i), mapt.get(t.charAt(i)) + 1);
            } else {
                mapt.put(t.charAt(i), 1);
            }
        }

        int match = 0;
        String res = "";
        while (right < s.length()) {
            Character c1 = s.charAt(right);
            if (mapt.containsKey(c1)) {
                if (mapS.containsKey(c1)) {
                    mapS.put(c1, mapS.get(c1) + 1);
                } else {
                    mapS.put(c1, 1);
                }

                if (mapS.get(c1).equals(mapt.get(c1))) {
                    match++;
                }

                while (match == mapt.size()) {
                    Character c2 = s.charAt(left);
                    if (right - left < minLen) {
                        start = left;
                        minLen = right - left;
                    }

                    if (mapt.containsKey(c2)) {
                        mapS.put(c2, mapS.get(c2) - 1);
                        if (mapt.get(c2) > mapS.get(c2)) {
                            match--;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "":s.substring(start,start+minLen+1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
