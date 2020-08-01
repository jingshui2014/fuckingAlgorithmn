package Hot100.题347前K个高频元素;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int num : nums) {
            if (queue.contains(num)) {
                continue;
            }
            if (queue.size() == k) {
                if(map.get(num) > map.get(queue.peek())){
                    queue.poll();
                    queue.add(num);
                }
            }else {
                queue.add(num);
            }

        }
        int[] res = new int[queue.size()];
        int m = 0;
        for (int temp:queue){
            res[m++] = temp;
        }
        return res;
    }

    public static void main(String[] args) {

        Solution so = new Solution();

    }
}
