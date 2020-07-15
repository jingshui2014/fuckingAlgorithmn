package 高频面试系列.UnionFind算法详解.题990等式方程的可满足性;

import 高频面试系列.UnionFind算法详解.UF;

public class Solution {
    public boolean equationsPossible(String[] equations) {

        UF union = new UF(26);
        for (int i = 0; i < equations.length; i++) {
            int a = equations[i].charAt(0) - 'a';
            int b = equations[i].charAt(3) - 'a';
            if (equations[i].charAt(1) == '=') {
                union.union(a,b);
            }
        }
        for (int i = 0; i < equations.length; i++) {
            int a = equations[i].charAt(0) - 'a';
            int b = equations[i].charAt(3) - 'a';
            if (equations[i].charAt(1) == '!' && union.connected(a,b)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        boolean b = so.equationsPossible(new String[]{"a==b","b!=c","c==a"});
        System.out.println(b);
    }
}
