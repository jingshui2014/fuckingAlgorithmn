package JavaGuide.题14最长公共前缀;

public class Solution {
     int value  = 11;

    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        if(strs == null || strs.length == 0){
            return builder.toString();
        }
        for(int i = 0;i<strs[0].length();i++){
            int j = 1;
            char cur = strs[0].charAt(i);
            for(;j<strs.length;j++){
                if(strs[j].length()<=i || strs[j].charAt(i)!=cur){
                    break;
                }
            }
            if(j!=strs.length){
                return builder.toString();
            }
            builder.append(cur);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        so.longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
}
