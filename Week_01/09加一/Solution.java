class Solution {
    public int[] plusOne(int[] digits) {
        if(null == digits || digits.length <= 0 || digits.length > 100){
            return null;
        }
        for(int i = digits.length-1; i>=0; i--){
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0){
                return digits;
            }            
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }
}