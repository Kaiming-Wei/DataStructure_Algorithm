package chapter02_LinkedList_Stack_Queue;

public class SingledLinkedList<T> {
    public Node<T> head;

    public SingledLinkedList() {
    }

    public SingledLinkedList(Node<T> head) {
        this.head = head;
    }

    public void printValue(){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.value+"\t");
            curr = curr.next;
        }
        System.out.println();
    }

    public int size(){
        int count = 0;
        Node curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    public void addToHead(T data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void removeHead(){
        head = head.next;
    }

    public void addToTail(T data){
        Node newNode = new Node(data);
        if(head == null){
            addToHead(data);
            return;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void removeTail(){
        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
    }

    public void reverseList(){
        if(head == null || head.next == null){

        }else{
            Node pre = null;
            Node next = null;
//            while(next != null){
//                head.next = pre;
//                pre = head;
//                head = next;
//                next = head.next;
//            }
//            Node pre = null;
//            Node next = null;
            while(head != null){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            head = pre;
        }
    }

    public void deletElements(T element){
        while(head.value.equals(element)){
            head = head.next;
        }
        Node curr = head;
        Node pre = head;
        while(curr != null){
            if(curr.value.equals(element)){
                curr = curr.next;
                pre.next = curr;
            }
            else{
                pre = curr;
                curr= curr.next;
            }
        }
    }

    public static void main(String[] args) {
        SingledLinkedList head = new SingledLinkedList<>();
        head.addToHead(1);
        head.addToHead(2);
        //head.addToTail(3);
        //head.addToTail(2);
        //head.addToTail(2);
        //head.reverseList();
        System.out.println(head.size());
        head.printValue();
        System.out.println("-------------------------");
        //head.deletElements(2);
        head.reverseList();
        head.printValue();
        System.out.println("-------------------------");

    }
}
