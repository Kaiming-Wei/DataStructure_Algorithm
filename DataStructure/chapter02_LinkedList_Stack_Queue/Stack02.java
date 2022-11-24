package chapter02_LinkedList_Stack_Queue;

// create stack using array
public class Stack02 {
    private final int limit;
    private int size=0;
    private int index = 0;
    private int arr[];

    public Stack02(int limit) {
        this.limit = limit;
        arr = new int[limit];
    }

    public void push(int data){
        if(size<limit){
            arr[index] = data;
            index++;
            size++;
        }else {
            System.out.println("Stack is full, "+data+" can't push into stack");
        }
    }

    public Integer pop(){
        if(size == 0){
            System.out.println("Stack is empty");
            return null;
        }else{
            int data = arr[index-1];
            index--;
            size--;
            return data;
        }
    }

    public int peek(){
        return arr[index-1];
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        Stack02 mystack = new Stack02(5);
        mystack.pop();
        mystack.push(0);
        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        mystack.push(4);
        System.out.println(mystack.isEmpty());
        System.out.println(mystack.pop());
        System.out.println(mystack.peek());
    }


}
