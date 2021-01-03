/**
创建长度大小相同的临时数组
1、循环遍历数组，计算其右移k后所在的位置index=(i + k) % nums.length，并index元素的值赋值为当前遍历到的元素的值
2、循环遍历数组，将临时数组的至赋值到目标数据
*/
class Solution {
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}