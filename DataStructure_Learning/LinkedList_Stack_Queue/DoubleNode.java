package chapter02_LinkedList_Stack_Queue;

public class DoubleNode<T> {
    public T value;
    public DoubleNode next;
    public DoubleNode last;

    public DoubleNode(T value) {
        this.value = value;
    }
}
