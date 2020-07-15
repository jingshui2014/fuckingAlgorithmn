package 高频面试系列.UnionFind算法详解;

import java.util.Arrays;

public class UF {

    public int count;
    public int[] parent;
    public int[] size;

    public UF(int N) {
        this.count = N;
        this.parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        this.size = new int[N];
        Arrays.fill(size, 1);
    }

    public boolean connected(int p, int q) {
        int pareP = find(p);
        int pareQ = find(q);
        return pareP == pareQ;
    }

    public void union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);
        if (parentP == parentQ) {
            return;
        }
        if (size[parentP] > size[parentQ]) {
            parent[parentQ] = parentP;
            size[parentP] += size[parentQ];
        }else{
            parent[parentP] = parentQ;
            size[parentQ] += size[parentP];
        }
        count--;
    }

    public int find(int p) {

        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public int getCount() {
        return count;
    }
}
