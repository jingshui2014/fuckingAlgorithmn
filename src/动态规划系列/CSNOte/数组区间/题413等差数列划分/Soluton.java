package 动态规划系列.CSNOte.数组区间.题413等差数列划分;



public class Soluton {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length<3){
            return 0;
        }
        boolean[][] dp = new boolean[A.length][A.length];

        int count = 0;

        for(int i = 0;i<A.length;i++){
            for(int j = i+2;j<A.length;j++){
                if(j == i+2){
                    if(A[i+1] - A[i] == A[i+2]-A[i+1]){
                        dp[i][j] = true;
                    }
                }else{
                    if(i-1>=0 && dp[i-1][j] && A[i] - A[i-1] == A[i+1]-A[i]){
                        dp[i][j] = true;
                    }
                    if(j+1<A.length && dp[i][j+1] && A[j+1] - A[j] == A[j]-A[j-1]){
                        dp[i][j] = true;
                    }
                }
                if(dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Soluton so = new Soluton();
        so.numberOfArithmeticSlices(new int[]{1,2,3,4});
    }
}
