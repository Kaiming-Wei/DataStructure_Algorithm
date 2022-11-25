public class LinkedList_Cycle {


    // to check if a linked list has cycle or not


    // set up 2 pointers
    // one fast, one slow
    // if there is no cycle, fast pointer will reach to null
    // if there is cycle, fast pointer and slow pointer will meet at the cycle
    public static boolean hasCycle(Node head){
        if(head == null || head.next == null){
            return false;
        }
        Node slow = head.next,
                fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                // following codes are used to find starting point of the cycle
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                System.out.println("Cycle starts at Node: " + slow.value);
                return  true;
            }
        }
        return false;
    }




    // test
    private static class Node<T>{
        T value;
        Node next;

        Node(T value){
            this.value = value;
        }
        Node(T value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node<Integer> node5 = new Node<Integer>(5,null);
        Node<Integer> node4 = new Node<Integer>(4,node5);
        Node<Integer> node3 = new Node<Integer>(3,node4);
        Node<Integer> node2 = new Node<Integer>(2,node3);
        Node<Integer> node1 = new Node<Integer>(1,node2);
        // node5.next = node1;
        System.out.println(hasCycle(node1));
    }

}
