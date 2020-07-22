package 贪心思想系列.liweiwei.题12整数转罗马数字;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {


    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        int[] array = new int[]{1000,900, 500,400, 100,90, 50,40, 10,9, 5, 4,1};


        if (map.containsKey(num)) {
            return map.get(num);
        }

        StringBuilder builder = new StringBuilder();
        int k = 0;
        while (num > 0) {

            if (array[k] <= num) {
                num -= array[k];
                builder.append(map.get(array[k]));
            } else {
                k++;
            }
        }

        return builder.toString();

    }


    public static void main(String[] args) {
//        Solution2 so = new Solution2();
//        int cur = so.cur(0);
//        System.out.println(cur);
    }
}
