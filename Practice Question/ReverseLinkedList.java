public class ReverseLinkedList {


    public static class Node<T> {
        public T value;
        public Node next;

        public Node(T value){this.value = value;}
    }


    // 2 ways to reverse a list

    // iteration
    public static Node reverseList_iteration(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node curr = head, prev = null, next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    // recursion
    public static Node reverseList_recursion(Node head){
        if(head == null || head.next == null){
            return head;
        }
        reverseList_recursion(head.next);
        head.next.next = head;
        head.next = null;
        return null;
    }

    public static void main(String[] args) {
        Node node1 = new Node<Integer>(1);
        Node node2 = new Node<Integer>(2);
        Node node3 = new Node<Integer>(3);
        node1.next = node2;
        node2.next = node3;


    }

}
