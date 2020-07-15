package 动态规划系列.liweiwei.第4部分经典问题.题91解码方法;

public class Solution {

    public int numDecodings(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;

        if(s.charAt(0)!='0'){
            dp[1] = 1;
        }

        for(int i = 2;i<=len;i++){
            if(s.charAt(i-1)!='0'){
                dp[i] =  dp[i-1];
            }

            if(s.charAt(i-2)!='0'){
                int num = (s.charAt(i -1)-'0')+(s.charAt(i-2)-'0')*10;
                if(num<=26 && num > 0){
                    dp[i]+= dp[i-2] ;
                }
            }
        }
        return dp[len];
    }
}
