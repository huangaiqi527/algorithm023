/**
*解答思路：
*设定索引index=0,指向最近一个处理过的元素，且下标小于index的元素均不为0
*1.从左到右循环遍历数组,如果遍历到的元素为0，则继续处理下一个元素
* 否则下标为index的元素赋值为当前遍历到的元素，index++
*2.循环处理结束后，将下标从index开始的元素的值置为0
*/
class Solution {
    public void moveZeroes(int[] nums) {
        if(null == nums || nums.length == 1){
            return;
        }
        int index = 0; 
        for(int i = 0; i< nums.length;i++){
            if(nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
        }
        for(int i=index;i < nums.length;i++){
            nums[i]=0;
        }
    }
}