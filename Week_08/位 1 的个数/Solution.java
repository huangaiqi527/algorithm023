public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);//使最后一位1变成0
        }
        return cnt;
    }

    /*
    public int hammingWeight(int n) {
        int cnt = 0;
        int mask = 1;
        for(int i = 0; i < 32 ; i++){
            cnt += (n & mask) != 0 ? 1 : 0;
            mask <<= 1;
        }
        return cnt;
    }
    */
}