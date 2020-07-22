package Hot100.题49母异位词分组;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> lists = new LinkedList<>();
        if (strs == null || strs.length == 0) {
            return lists;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String c = new String(chars);
            if (map.containsKey(c)) {
                map.get(c).add(strs[i]);
            } else {
                LinkedList<String> list = new LinkedList<>();
                list.add(strs[i]);
                map.put(c, list);
            }
        }
        lists.addAll(map.values());
        return lists;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        List<List<String>> lists = so.groupAnagrams(new String[]{"ate", "eat", "nat"});
        System.out.println(lists);
    }

}
