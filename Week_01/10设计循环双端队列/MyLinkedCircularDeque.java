class MyLinkedCircularDeque {
    
    private Node first = null;
    private Node last = null;
    private int size = 0;
    private int capacity = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyLinkedCircularDeque(int k) {
        capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        Node node = new Node(null, value, null);
        if(isEmpty()){
            first = node;
            last = node;
            size ++;
            return true;

        }
        node.next = first;
        first.prev = node;
        first = node;
        size ++;
        return true;

    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        Node node = new Node(null, value, null);
        if(isEmpty()){
            first = node;
            last = node;
            size ++;
            return true;

        }
        last.next = node;
        node.prev = last;
        last = node;
        size ++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        Node next = first.next;
        if(size > 1){//删掉删除的节点对其它节点的引用和其他节点对它的引用
            next.prev = null;
            first.next = null;
        }
        first = next;
        size --;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        Node prev = last.prev;
        if(size > 1){//删掉删除的节点对其它节点的引用和其他节点对它的引用
            last.prev = null;
            prev.next = null;
        }
        last = prev;
        size --;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return first.value;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return last.value;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(size  == 0){
            return true;
        }
        return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(size >= capacity){
            return true;
        }
        return false;
    }
    private static class Node {
        int value;
        Node next;
        Node prev;
        Node(Node prev, int value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */