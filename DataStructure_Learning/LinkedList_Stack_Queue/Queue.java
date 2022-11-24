package chapter02_LinkedList_Stack_Queue;

public class Queue<T> {
    private DoubleLinkedList<T> queue;

    public Queue() {
        queue = new DoubleLinkedList();
    }

    public void push(T data){
        queue.addHead(data);
    }

    public T pop(){
        if(queue.isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }else{
            return queue.removeTail();
        }
    }

    public T peek(){
        if(queue.isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }else {
            return queue.getTail();
        }
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(0);
        System.out.println(queue.pop());
    }
}
