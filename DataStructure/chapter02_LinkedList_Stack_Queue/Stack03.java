package chapter02_LinkedList_Stack_Queue;


// create stack using 2 queue
public class Stack03<T> {
    private Queue<T> q1 = new Queue<T>();
    private Queue<T> q2 = new Queue<T>();

    public void push(T data){
        if(q1.isEmpty() && q2.isEmpty()){
            q1.push(data);
        }else if(q1.isEmpty()){
            q2.push(data);
        }else {
            q1.push(data);
        }
    }

    public T pop(){
        T data = null;
        if(q1.isEmpty() && q2.isEmpty()){
            System.out.println("Stack is empty, can't pop");
            return data;
        }else if(q2.isEmpty()){
            while(!q1.isEmpty()){
                data = q1.pop();
                if(q1.isEmpty()){
                    return data;
                }else{
                    q2.push(data);
                }
            }
        }else{
            while(!q2.isEmpty()){
                data = q2.pop();
                if(q2.isEmpty()){
                    return data;
                }else{
                    q1.push(data);
                }
            }
        }
        return data;
    }

    public boolean isEmpty(){
        if(q1.isEmpty() && q2.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public T peek(){
        T data = pop();
        push(data);
        return data;
    }

    public static void main(String[] args) {
        Stack03<Integer> stack = new Stack03();
        System.out.println(stack.isEmpty());
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.pop());
    }
}
