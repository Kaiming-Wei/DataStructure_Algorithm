package chapter02_LinkedList_Stack_Queue;

public class Stack<T> {
    private DoubleLinkedList<T> stack;

    public Stack() {
        stack = new DoubleLinkedList<>();
    }

    public void push(T data){
        stack.addHead(data);
    }

    public T pop(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }else{
            return stack.removeHead();
        }
    }

    public T peek(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }else{
            return stack.getHead();
        }
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }
}
