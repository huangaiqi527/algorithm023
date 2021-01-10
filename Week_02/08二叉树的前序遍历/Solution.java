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
 //递归处理
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>  result = new ArrayList<Integer>();
        if(null == root){
            return result;
        }
        result.add(root.val);
        List<Integer> list = preorderTraversal(root.left);
        if(null != list){
            result.addAll(list);
        }
        list = preorderTraversal(root.right);
        if(null != list){
            result.addAll(list);
        }
        return result;
    }
}
 /**
 //使用栈来处理
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
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
              result.add(node.val);
              left = node.left;
              right = node.right;
              if(null != right){
                  stack.push(right);
              }
              if(null != left){
            	  stack.push(left);
              }
         }    
         return result;
    }
}*/