/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /**
先序：根左右
中序：左根右
后序：左右根
 */
/**
**递归调用的方式 
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>  result = new ArrayList<Integer>();
        if(null == root){
            return result;
        }
        List<Integer> list = inorderTraversal(root.left);
        if(null != list){
            result.addAll(list);
        }
        result.add(root.val);
        list = inorderTraversal(root.right);
        if(null != list){
            result.addAll(list);
        }
        return result;
    }
}

/**
先序：根左右
中序：左根右
后序：左右根
 */
 /**
 //使用栈来处理
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if(null == root){
            return result;
        }
        stack.push(root);
        TreeNode node = null;
        TreeNode left;
        TreeNode right;
        while (!stack.isEmpty()) {
             node = stack.pop();
             left = node.left;
             right = node.right;
             node.left = null;//
             node.right = null;
             if(null == left && null == right){
                 result.add(node.val);
                 continue;
             }
             if(null == left){
            	 result.add(node.val);
            	 node = null;
             }
             if(null != right){
                 stack.push(right);
             }
             if(null != left){
                 stack.push(node);
                 stack.push(left);
             }
        }    
        return result;
    }
}
*/