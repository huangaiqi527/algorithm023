/**
解题思路：
f(n) = f(n-1) + f(n-2),f(1)=1,f(2)=2
缓存f(n-1)、 f(n-2)，避免重复计算
*/
class Solution {
    public int climbStairs(int n) {
        if( n <= 2){
            return n;
        }
        int prev = 1;
        int current = 2;
        int prevTemp = 0;
        for(int i = 3; i <= n ; i++){
            prevTemp = current;
            current = current + prev;
            prev = prevTemp;
        }
        return current;
    }
}