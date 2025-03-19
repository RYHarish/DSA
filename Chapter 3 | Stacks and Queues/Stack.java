import java.util.*;

public class Stack {
    private ListNode top;
    private int length;
    
    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public Stack(){
        top = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }
     
    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public int pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int result = top.data;
        ListNode temp = top;
        top = temp.next;
        temp.next = null;
        length--;
        return result;
    }

    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
}
