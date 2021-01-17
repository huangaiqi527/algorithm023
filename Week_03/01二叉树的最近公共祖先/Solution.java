/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root || root == p || root == q){
            return root;
        }
        getParent(root);
        /**
        *从p节点开始反向遍历至根节点，并将遍历过的节点放至Set中
        */
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        /**
        *从q节点开始反向遍历父节点，如果遍历到的父节点已经在Set中，则该父节点为最近公共祖先
        */
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    /**
    *标记每个节点的父节点
    *
    */

    public void getParent(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            getParent(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            getParent(root.right);
        }
    }
}