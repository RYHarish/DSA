public class ArrayStack {
    private int top;
    private int[] stack;

    public ArrayStack(int capacity){
        top = -1;
        stack = new int[capacity];
    }

    public ArrayStack(){
        this(10);
    }

    public void push(int data){
        if(isFull()){
            throw new IllegalStateException("Stack is full");
        }
        top++;
        stack[top] = data;
    }
    
    private boolean isFull(){return stack.length == size();}
    private int size(){return top + 1;}

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        int temp = stack[top];
        top--;
        return temp;
        
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty(){return top < 0;}

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);
        stack.push(30);
        
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        
    }

}
