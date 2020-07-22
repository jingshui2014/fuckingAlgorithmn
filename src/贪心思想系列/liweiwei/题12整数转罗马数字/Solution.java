package 贪心思想系列.liweiwei.题12整数转罗马数字;

import java.util.HashMap;
import java.util.Map;

public class Solution {


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

        int[] array = new int[]{1000, 500, 100, 50, 10, 5, 1};
        int[] array2 = new int[]{400, 40, 4};
        int[] array3 = new int[]{900, 90, 9};

        if (map.containsKey(num)) {
            return map.get(num);
        }

        StringBuilder builder = new StringBuilder();
        int k = 0;
        while (num > 0) {
            int curNum = cur(num);
            if (curNum == 4) {
                for (int temp : array2) {
                    if (num - temp >= 0) {
                        num -= temp;
                        builder.append(map.get(temp));
                        break;
                    }
                }
            } else if (curNum == 9) {
                for (int temp : array3) {
                    if (num - temp >= 0) {
                        num -= temp;
                        builder.append(map.get(temp));
                        break;
                    }
                }
            } else {
                if (array[k] <= num) {
                    num -= array[k];
                    builder.append(map.get(array[k]));
                } else {
                    k++;
                }
            }
        }

        return builder.toString();

    }

    private int cur(int x) {
        while (x / 10 > 9) {
            x /= 10;
        }
        return x >= 10 ? x / 10 : x;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int cur = so.cur(0);
        System.out.println(cur);
    }
}
