package 贪心思想系列.liweiwei.题56合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        boolean flag = false;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end && intervals[i][1] >= end) {
                end = intervals[i][1];
            } else if(intervals[i][0] > end){
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        list.add(new int[]{start, end});

        int[][] array = list.toArray(new int[list.size()][2]);
        return array;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        so.merge(new int[][]{{1,4},{2,3}});
    }
}
