/**
*解答思路：
*设定索引index=0,指向最近一个处理过的元素，且下标小于index的元素均不与之重复
*从左到右循环遍历数组(从下标1开始),如果遍历到的元素与下标index所在的元素相同，则继续处理下艺元素
*否则下标为index+1的元素赋值为当前遍历到的元素，index++
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if(null == nums){
            return 0;
        }
        if(1 == nums.length){
            return 1;
        }
        int index = 0;
        for(int i = 1; i< nums.length; i++){
            if(nums[i] == nums[index]){
                continue;
            }
            nums[index+1] = nums[i];
            index ++;

        }
        return index + 1;
    }
}