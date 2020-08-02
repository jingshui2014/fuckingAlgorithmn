package Hot100.题394字符串解码;

import java.util.LinkedList;

public class Solution {
    public String decodeString(String s) {

        StringBuilder res = new StringBuilder();
        LinkedList<Integer> stackMulti = new LinkedList();
        LinkedList<String> stackRes = new LinkedList();
        int multi = 0;

        for (char curChar : s.toCharArray()) {
            if (Character.isDigit(curChar)) {
                multi = multi * 10 + (curChar - '0');
            } else if (curChar == '[') {
                stackMulti.add(multi);
                multi = 0;
                stackRes.add(res.toString());
                res = new StringBuilder();
            } else if (curChar == ']') {
                int times = stackMulti.removeLast();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < times; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stackRes.removeLast() + temp);
            } else {
                res.append(curChar);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        String s = so.decodeString("3[a2[c]]");
        System.out.println(s);
    }
}
