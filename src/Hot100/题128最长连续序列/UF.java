package Hot100.题128最长连续序列;

import java.util.HashMap;
import java.util.Map;

public class UF {


    Map<Integer, Integer> map;
    private int count;

    public UF(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i]);
        }
        count = nums.length;
    }

    public void union(int a, int b) {
        Integer A = find(a);
        Integer B = find(b);
        if (A == null || B == null) {
            return;
        }
        if (A.equals(B)) {
            return;
        }
        map.put(A, B);
        count--;
    }

    public Integer find(int x) {
        if (!map.containsKey(x)) {
            return null;
        }
        int r = x;
        while (map.containsKey(r + 1)) {
            r = r + 1;
        }
        //做路径压缩
        int p = x;
        while (p != map.get(p)) {
            p = map.get(p);
            map.put(p, r);
        }
        return r;
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public int getCount() {
        return count;
    }
}
