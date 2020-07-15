package 动态规划系列.liweiwei.第4部分经典问题.题5最长回文子串;

/**
 * 中心扩展法
 */
public class Solution {
    public  String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        String maxstring = s.substring(0,1);
        for (int i = 0; i < s.length() - 1; i++) {
            String l = longestPalindrome(s, i, i);
            String r = longestPalindrome(s, i, i + 1);
            l = (l.length() >= r.length() ? l : r);
            maxstring = (l.length() > maxstring.length() ? l : maxstring);
        }
        return maxstring;
    }

    private  String longestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        String babad = so.longestPalindrome("a");
        System.out.println(babad);
    }
}
