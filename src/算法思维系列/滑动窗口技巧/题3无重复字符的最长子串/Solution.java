package 算法思维系列.滑动窗口技巧.题3无重复字符的最长子串;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int minLen = Integer.MIN_VALUE;
        for (int i = 0;i<s.length();i++){
            if(list.size() == 0 || !list.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }else {
                Iterator<Character> iterator = list.iterator();
                while (iterator.hasNext()){
                    if(iterator.next().equals(s.charAt(i))){
                        iterator.remove();
                        break;
                    }
                    iterator.remove();
                }
                list.add(s.charAt(i));
            }
            minLen = Math.max(minLen,list.size());
        }
        return minLen == Integer.MIN_VALUE ? 0:minLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}
