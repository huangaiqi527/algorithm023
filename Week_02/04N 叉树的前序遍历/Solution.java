/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(Node root) {
        if(null == root){
            return result;
        }
        traverseNode(root, 0);
        return result;
    }
    /**
    *递归遍历节点
    */
    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);//将该节点的val加入所在的层级的结果集中
        for (Node child : node.children) {//遍历子节点
            traverseNode(child, level + 1);
        }
    }
}
/**
**使用逐层循环处理的方式
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(null == root){
            return result;
        }
        List<Node> nodeList = new ArrayList<Node>();
        List<Integer> list = null;
        nodeList.add(root);
        List<Node> children = null;
        while (null != nodeList && nodeList.size() > 0) {
            list = new ArrayList<Integer>() ;
            List<Node> childrens = new ArrayList<Node>();
            for(Node node : nodeList){
                list.add(node.val);
                children = node.children;
                if(null != children && children.size()>0){
                    childrens.addAll(children);
                }
            }
            result.add(list);
            nodeList = childrens;
        }    
        return result;
    }
}
*/