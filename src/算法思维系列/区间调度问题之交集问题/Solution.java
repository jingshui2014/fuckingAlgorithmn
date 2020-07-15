package 算法思维系列.区间调度问题之交集问题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<List<Integer>> lists = new LinkedList<>();


        int start = 0;
        int end = 0;
        for (int i = 0; i < A.length; i++) {

            start = A[i][0];
            end = A[i][1];

            for (int j = 0; j < B.length; j++) {
                if(B[j][0] > end || B[j][1] < start){
                   continue;
                }
                if (B[j][1] <= end){
                    if(B[j][0] < start){
                        lists.add(Arrays.asList(start,B[j][1]));
                    }else {
                        lists.add(Arrays.asList(B[j][0],B[j][1]));
                    }
                }else {
                    if(B[j][0] < start){
                        lists.add(Arrays.asList(start,end));
                    }else {
                        lists.add(Arrays.asList(B[j][0],end));
                    }
                }
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
        so.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}},new int[][]{{1,5},{8,12},{15,24}});
    }
}
