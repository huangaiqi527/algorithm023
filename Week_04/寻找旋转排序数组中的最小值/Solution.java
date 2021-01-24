class Solution {
    public int findMin(int[] nums) {
        if(null == nums){
            return -1;
        }
        if(1 == nums.length){
            return nums[0];
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i -1]){
                return nums[i];
            }
        }
        return nums[0];
    }
}