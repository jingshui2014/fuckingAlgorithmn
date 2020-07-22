package 贪心思想系列.liweiwei.题455分发饼干;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null || g.length == 0 || s.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; i < s.length && j < g.length; ) {
            if(s[i] >= g[j]){
                count++;
                i++;
                j++;
            }else {
                i++;
            }
        }
        return count;
    }
}
