package 算法思维系列.拆解复杂问题实现计算器.题224基本计算器;

import java.util.Stack;

public class Solution {

    public static int[] calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        s = s.replaceAll(" ", "");
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
            }

            if (i<s.length() && s.charAt(i) == '(') {
                //把左右括号看成一个数，递归调用calculate就行
                int[] answer = calculate(s.substring(i + 1));
                num = answer[0];
                i = i + answer[1]+2;
            }

            if ( i == s.length() || !Character.isDigit(s.charAt(i)) ) {

                //这个sign，是得到得新的num之前的字符
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        Integer pre = stack.pop();
                        int result = pre * num;
                        stack.push(result);
                        break;
                    case '/':
                        Integer preNum = stack.pop();
                        int res = preNum / num;
                        stack.push(res);
                        break;
                }
                num = 0;
                sign = i == s.length() ? sign : s.charAt(i);
            }

            if (i<s.length() && s.charAt(i) == ')') {
                int sum = 0;
                for (Integer temp : stack) {
                    sum += temp;
                }
                return new int[]{sum, i};
            }
        }
        int sum = 0;
        for (Integer temp : stack) {
            sum += temp;
        }
        return new int[]{sum, s.length() - 1};
    }

    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)")[0]);
    }
}
