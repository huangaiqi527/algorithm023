/**
*解法过程（判断两个字符串每个字母出现的次数是否一致）
*1、分配长度为26的整型数组charCount，用于存储26个小写字母出现的次数，下标index=为小写字母-'a'的值
*2、遍历字符串s里面的每个字符并做处理：charCount[s.charAt(i)]++;
*3、遍历字符串t里面的每个字符c，计算下标index=t.charAt(i) - 'a'，如果charCount[index] < 1则说明该字符出现的次数不一致返回true，否则charCount[index]--;
*/

class Solution {
    public boolean isAnagram(String s, String t) {
         if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        int[] charCount = new int[26];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            charCount[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            index = t.charAt(i) - 'a';
            if(charCount[index] < 1){
                return false;
            }
            charCount[index]--;
        }
        return true;
    }
}
/**
**进阶:如果输入字符串包含 unicode 字符时的处理
**改为使用Map存储字符出现的次数
class Solution {
    public boolean isAnagram(String s, String t) {
         if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> chars = new HashMap<Character, Integer>();
        char ch ;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            chars.put(ch, chars.getOrDefault(ch, 0) + 1);
        }
        int cnt = 0;
        for (int i = 0; i < t.length(); i++) {
            ch = t.charAt(i);
            cnt = chars.getOrDefault(ch, 0) - 1;
            if(cnt < 0){
                return false;
            }
            chars.put(ch, cnt);
        }
        return true;
    }
}
*/