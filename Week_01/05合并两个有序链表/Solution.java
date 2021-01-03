 /**
*1.定义一个头结点用于拼接两个链表
*2.在shile循环中处理链表的拼接
*2.1如果链表l1当前节点的值小，则将其当前节点连接到head中，head、l1移到下一个节点
*   否则将l2当前节点连接到head中，head、l2移到下一个节点
*2.2如果l1为null,则直接连接l2并结束拼接处理；如果l2为null,则直接连接l1并结束拼接处理
*   否则将l2当前节点连接到head中，head、l2移到下一个节点
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1){
            return l2;
        }
        if(null == l2){
            return l1;
        }
        ListNode head =  new ListNode(0);
        ListNode result =  head;
        while( true ){
            if(l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }else{
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
            if(null == l1){
                head.next = l2;
                break;
            }
            if(null == l2){
                head.next = l1;
                break;
            }
        }
        return result.next;
    }
}