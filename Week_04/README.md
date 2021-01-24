1、学习深度优先搜索、广度优先搜索的实现和特性
DFS代码模板:
// Java
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }

    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }

BSF代码模板：
// Java
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> allResults = new ArrayList<>();
		if (root == null) {
			return allResults;
		}
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
		int size = nodes.size();
		List<Integer> results = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			TreeNode node = nodes.poll();
			results.add(node.val);
			if (node.left != null) {
				nodes.add(node.left);
			}
			if (node.right != null) {
				nodes.add(node.right);
			}
			allResults.add(results);
		}
		return allResults;
	}

2、学习二分查找的实现、特性

// Java
	public int binarySearch(int[] array, int target) {
		int left = 0, right = array.length - 1, mid;
		while (left <= right) {
			mid = (right - left) / 2 + left;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		} 
		return -1;
	}    

 3、使用二分查找
 思路：
    a.半有序数组实际上就是分成两部分有序的数据，且半部分有序数组都比左边的小。
    b.可以使用二分查找的方式，但是判断搜索左半部分还是右半部分的由简单判断中值与目标的大小改为判断中值所在的部分：
        b1.如果中值属于左边升序范围内，且target在这个范围内，则查找左半部分，否则查找右半部分
        b2.否则，如果处于右边升序的部分，并且target在这个范围内，则查找右半部分，否则在左半部分中查找
// Java
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
