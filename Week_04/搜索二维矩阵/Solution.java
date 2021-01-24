class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( null == matrix){
            return false;
        }
        int columns = matrix[0].length;
        //逐行判断target是否在当前行范围内，如果在则当前行进行二分查找
        for(int rowid = 0; rowid < matrix.length; rowid++){
            if(target <= matrix[rowid][columns -1]){
                return binarySearch(0, columns - 1, matrix[rowid], target);
            }
        }
        return false;
    }

    public boolean binarySearch(int left, int right, int[] nums, int target) {
        if(left > right){
            return false;
        }
        int mid = left + (right - left)/2;
        if(nums[mid] == target){
            return true;
        }
        if (target < nums[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return binarySearch(left, right, nums, target);

    }
}