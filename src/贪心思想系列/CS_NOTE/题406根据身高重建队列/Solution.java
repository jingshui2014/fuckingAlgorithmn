package 贪心思想系列.CS_NOTE.题406根据身高重建队列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){

            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        LinkedList<int[]> list = new LinkedList<>();

        for(int i = 0;i<people.length;i++){
          list.add(people[i][1],people[i]);
        }
        return list.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        so.reconstructQueue(new int[][]{{1,2},{3,4}});
    }
}
