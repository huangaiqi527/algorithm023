class Solution {
    public int search(int[] nums, int target) {
        if(null == nums || nums.length == 0){
            return -1;
        }
        return binarySearch(0, nums.length -1 , nums, target);
    }

    public int binarySearch(int left, int right, int[] nums, int target) {
        if(left > right){
            return -1;
        }
        int mid = left + (right - left)/2;
        if(nums[mid] == target){
            return mid;
        }
        if (nums[0] <= nums[mid]) {//当前属于左边升序范围内
                //如果target在这个范围内，则查找左半部分，否则查找右半部分
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
        } else {//当前属于右边范围内
                //如果右边部分是升序的，并且target在这个范围内，则查找右半部分，否则在左半部分中查找
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
        }

        return binarySearch(left, right, nums, target);

    }
}