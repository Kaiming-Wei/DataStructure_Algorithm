package chapter02_LinkedList_Stack_Queue;

public class Queue03<T> {
    private Stack<T> push_stack = new Stack<T>();
    private Stack<T> pop_stack = new Stack<T>();

    private void transfer(){
        // only can transfer data to popStack when it is empty
        if(pop_stack.isEmpty()){
            // 倒data的时候一定要倒空
            while(!push_stack.isEmpty()){
                T data = push_stack.pop();
                pop_stack.push(data);
            }
        }
    }

    public boolean isEmpty(){
        if(push_stack.isEmpty() && pop_stack.isEmpty()){
            return true;
        }
        return false;
    }

    public void push(T data){
        push_stack.push(data);
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return null;
        }
        transfer();
        T data = pop_stack.pop();
        return data;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return null;
        }
        transfer();
        return pop_stack.peek();
    }

}
