package Hot100.题49母异位词分组;

import java.util.*;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> lists = new LinkedList<>();
        if (strs == null || strs.length == 0) {
            return lists;
        }
        int[] bit = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(bit, 0);
            for (char temp : strs[i].toCharArray()) {
                bit[temp - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                builder.append('#');
                builder.append(bit[j]);
            }
            String c = builder.toString();
            if (map.containsKey(c)) {
                map.get(c).add(strs[i]);
            }else {
                LinkedList<String> list = new LinkedList<>();
                list.add(strs[i]);
                map.put(c,list);
            }
        }
        lists.addAll(map.values());
        return lists;
    }

    public static void main(String[] args) {
        Solution2 so = new Solution2();
        List<List<String>> lists = so.groupAnagrams(new String[]{"ate", "eat", "nat"});
        System.out.println(lists);
    }

}
