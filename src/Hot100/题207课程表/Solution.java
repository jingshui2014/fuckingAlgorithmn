package Hot100.题207课程表;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private boolean marked[];
    private boolean onStack[];
    private boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses, prerequisites);
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!marked[i]) {
                dfs(g, i);
                if (hasCycle) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : g.adj(v)) {
            if (hasCycle) {
                return;
            }
            if (!marked[w]) {
                dfs(g, w);
            } else if (onStack[w]) {
                hasCycle = true;
                return;
            }
        }
        onStack[v] = false;
    }
}

class Graph {

    private int V;
    List<List<Integer>> lists = new ArrayList<>();

    public Graph(int v, int[][] prerequisites) {
        this.V = v;
        for (int i = 0; i < v; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] tempNums : prerequisites) {
            lists.get(tempNums[0]).add(tempNums[1]);
        }
    }

    public List<Integer> adj(int a) {
        return lists.get(a);
    }
}
