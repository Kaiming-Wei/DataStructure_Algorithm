package chapter02_LinkedList_Stack_Queue;

public class Queue02 {
    private final int limit;
    private int size = 0;
    private int pop = 0;
    private int push = 0;
    private int[] arr;

    public Queue02(int limit) {
        this.limit = limit;
        arr = new int[limit];
    }

    public void push(int data){
        if(size == limit){
            System.out.println("Queue is full, can't push in "+ data);
        }else{
            arr[push] = data;
            push++;
            size++;
        }
    }

    public Integer pop(){
        if(size == 0){
            System.out.println("Queue is empty, can't pop out");
            return null;
        }else{
            pop++;
            return arr[pop-1];
        }
    }

    public int peek(){
        if(isEmpty()){
            return Integer.parseInt(null);
        }else{
            return arr[pop];
        }
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Queue02 myqueue = new Queue02(3);
        myqueue.pop();
        System.out.println(myqueue.isEmpty());
        myqueue.push(0);
        myqueue.push(1);
        myqueue.push(2);
        myqueue.push(2);
        System.out.println(myqueue.pop());
        System.out.println(myqueue.peek());
        System.out.println(myqueue.isEmpty());
    }
}
