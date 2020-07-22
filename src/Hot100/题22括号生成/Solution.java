package Hot100.题22括号生成;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    int size;
    List<String> list = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        this.size = n;
        generateParenthesis(n, n, builder);
        return list;
    }

    private void generateParenthesis(int m, int n, StringBuilder builder) {
        if (builder.length() == size*2) {
            list.add(builder.toString());
            return;
        }
        if (m <= n && m > 0) {
            builder.append('(');
            generateParenthesis(m - 1, n, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (n > 0 && m <= n - 1) {
            builder.append(')');
            generateParenthesis(m, n - 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        List<String> list = so.generateParenthesis(1);
        for (String temp:list){
            System.out.println(temp);
        }
    }
}
