class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(null == g || null == s || g.length == 0 || s.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        for(int i = 0,j =0; i < g.length && j < s.length; ){
            if(g[i] <= s[j]){
                i++;
                j++;
                cnt++;
                continue;
            }
            j++;
        }
        return cnt;
    }
}