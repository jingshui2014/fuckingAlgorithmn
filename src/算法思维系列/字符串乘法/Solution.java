package 算法思维系列.字符串乘法;

/**
 * 这题用小学里计算乘法的规则做，就在纸上写出运算顺序
 */
public class Solution {

    public String multiply(String s1, String s2) {

        int[] reslove = new int[s1.length() + s2.length()];
        for (int i = s1.length()-1; i >=0; i--) {
            for (int j = s2.length()-1;j>=0; j--) {
                int num1 = s1.charAt(i) - '0';
                int num2 = s2.charAt(j) - '0';
                int sum = num1 * num2 + reslove[i + j + 1];
                reslove[i + j + 1] = sum % 10;
                reslove[i + j] += sum / 10;
            }
        }
        int k = 0;
        for (; k < reslove.length; k++) {
            if (reslove[k] != 0) {
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (; k < reslove.length; k++) {
            stringBuilder.append(reslove[k]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.multiply("123", "456"));
    }
}
