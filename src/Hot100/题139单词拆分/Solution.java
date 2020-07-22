package Hot100.题139单词拆分;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict1) {

        Set<String> wordDict = new HashSet<>(wordDict1);
        boolean dp[] = new boolean[s.length()];
        if (wordDict.contains(String.valueOf(s.charAt(0)))) {
            dp[0] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
               if(wordDict.contains(s.substring(j,i+1))){
                   if(j-1>=0){
                       dp[i] |=dp[j-1];
                   }else {
                       dp[i] = true;
                   }
                   if(dp[i]){
                       break;
                   }
               }
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        boolean b = so.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(b);
    }
}
