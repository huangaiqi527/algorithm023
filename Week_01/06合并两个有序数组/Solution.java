/**
从又往左遍历数据num1，num1和num2的元素也是从右往左处理（分别设定处理位置index1和index2）
如果num1没处理完毕，并且nums1[index1]>= nums2[index2]，则将当前遍历到的元素的值应该为nums1[index1]，并且index1--
否则当前遍历到的元素的值应该为nums1[index2]，并且index2--

边界处理：
1、index2小于0，说明num2的元素已全部合并至num1，此时处理结束
2、index1小于0，说明num1的元素已处理完毕，依次将nums2的元素合并处理即可
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;
        for(int i = m + n -1 ; i >=0 ; i--){
            if(index2 < 0){
                break;
            }
            if(index1 >= 0 && nums1[index1] >= nums2[index2]){
                nums1[i] = nums1[index1];
                index1--;
                continue;
            }
            nums1[i] = nums2[index2];
            index2--;
        }
    }
}