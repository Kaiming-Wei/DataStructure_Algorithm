package chapter02_LinkedList_Stack_Queue;

public class DoubleLinkedList<T> {
    public DoubleNode<T> head;
    public DoubleNode<T> tail;

    public DoubleLinkedList() {
    }
    public DoubleLinkedList(DoubleNode head) {
        this.head = head;
        setTail();
    }
    public DoubleLinkedList(T data){
        head = new DoubleNode(data);
        tail = head;
    }
    private void setTail(){
        DoubleNode curr = head;
        while (curr.next!= null){
            curr = curr.next;
        }
        tail = curr;
    }

    public T getHead(){
        return head.value;
    }

    public T getTail(){
        return tail.value;
    }

    public int size(){
        int size = 0;
        DoubleNode curr = head;
        while (curr!=null){
            curr = curr.next;
            size++;
        }
        return size;
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }else{
            return false;
        }
    }

    public void printHead(){
        DoubleNode curr = head;
        while(curr != null){
            System.out.print(curr.value+"\t");
            curr=curr.next;
        }
        System.out.println();
    }

    public void printTail(){
        DoubleNode curr = tail;
        while (curr!=null){
            System.out.print(curr.value+"\t");
            curr = curr.last;
        }
        System.out.println();
    }

    public void addHead(T data){
        DoubleNode newNode = new DoubleNode(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head.last = newNode;
            head=newNode;
        }
    }

    public T removeHead(){
        DoubleNode<T> curr = head;
        head=head.next;
        head.last=null;
        return curr.value;
    }

    public void addTail(T data){
        DoubleNode newNode = new DoubleNode(data);
        tail.next = newNode;
        newNode.last = tail;
        tail = newNode;
    }

    public T removeTail(){
        DoubleNode<T> curr = null;
        DoubleNode<T> pre = null;
        if(tail.last == null){
            curr = tail;
            head = null;
            tail = null;
            return curr.value;
        }else{
            curr = tail;
            pre = tail.last;
            pre.next = null;
            tail = pre;
            return curr.value;
        }
    }

    public void reverseList(){
        DoubleNode pre = null;
        DoubleNode next = null;
        tail = head;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        head = pre;
    }

    public void deletElements(T element){
        while(head.value.equals(element)){
            head=head.next;
            head.last =null;
        }
        DoubleNode pre = head;
        DoubleNode curr = head.next;
        while (curr != null){
            if(curr.value.equals(element)){
                curr = curr.next;
                pre.next = curr;
                if (curr != null){
                    curr.last = pre;
                }else{
                     tail = pre;
                }
            }else{
                pre = curr;
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList head = new DoubleLinkedList();
        head.addHead(2);
    }
}
