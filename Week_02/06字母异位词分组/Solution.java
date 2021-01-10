/**
*主要解题思路：
*以此遍历字符串数组，将遍历到的字符串排序后存储到Map中，key为排序后的字符串，value则为存储字符串List
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	 Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}