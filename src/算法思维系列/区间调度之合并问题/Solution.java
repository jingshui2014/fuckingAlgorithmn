package 算法思维系列.区间调度之合并问题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> lists = new LinkedList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int start = 0;
        int end = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                start = intervals[0][0];
                end = intervals[0][1];

            } else if (intervals[i][0] > end) {
                lists.add(Arrays.asList(start, end));
                start = intervals[i][0];
                end = intervals[i][1];

            } else if (intervals[i][1] > end) {
                end = intervals[i][1];
            }

            if (i == intervals.length - 1) {
                lists.add(Arrays.asList(start, end));
            }
        }
        int[][] mergeArray = new int[lists.size()][2];

        int i = 0;
        for (List<Integer> list : lists) {
            mergeArray[i++] = new int[]{list.get(0), list.get(1)};
        }
        return mergeArray;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] merge = so.merge(new int[][]{{1, 3},{2,4}});
        System.out.println(Arrays.deepToString(merge));
    }
}
