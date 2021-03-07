class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        // 每2k个元素为一组进行反转
        for (int i = 0; i < n; i += 2 * k){
            int left = i;
            int right = (i + k - 1 < n) ? i + k -1 : n - 1; //判断下标是否越界
            while (left <= right){
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        String str = new String(ch);
        return str;
    }
}