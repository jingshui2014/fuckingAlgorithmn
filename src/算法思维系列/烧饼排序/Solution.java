package 算法思维系列.烧饼排序;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    private List<Integer> list = new LinkedList<>();
    public List<Integer> pancakeSort(int[] A) {

        if(A == null || A.length == 0){
            return list;
        }
        sort(A,A.length-1);
        return list;
    }

    private void sort(int[] a,int length) {
        if(length < 0){
            return;
        }

        int maxValue = a[0];
        int maxIndex = 0;

        for (int i = 0;i<=length;i++){
            if(a[i] > maxValue){
                maxValue = a[i];
                maxIndex = i;
            }
        }
        reverse(a,0,maxIndex);
        list.add(maxIndex+1);
        reverse(a,0,length);
        list.add(length+1);
        sort(a,length-1);
    }

    private void reverse(int[] A,int start,int end){
        while (start<end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.pancakeSort(new int[]{3,2,4,1}));
    }
}
