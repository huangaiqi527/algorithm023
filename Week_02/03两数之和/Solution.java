/**
借助HashMap按key查找值的时间复杂度为O(1)的特性，创建一个HashMap（数组的值做为key，小标作为value）
循环遍历数组，计算第二和加数的值（和减去第一个加数），并判断该至是否存在Map中
如果存在则取出其value，即可以得到第二个加数的下标，将该下标和当前遍历位置作为结果数组返回
需要注意的地方：遍历数组时，每个元素都应当将其作为key,下标作为value放到Map中
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length<2) return null;
        Map<Integer,Integer> numsMap = new HashMap<Integer,Integer>();
        Integer index = -1;
        for(int i=0;i<nums.length;i++){
            if(null != (index = numsMap.get(target-nums[i]))){
                return new int[]{index, i};
            }
            numsMap.put(nums[i],i);
        }
        return null;
    }
}