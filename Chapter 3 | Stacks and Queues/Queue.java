import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.NoSuchElementException;

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    public class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    private int length(){
        return length;
    }

    private boolean isEmpty(){
        return length == 0;
    }

    public Queue(){
        this.front = null;
        this.rear = null; 
        this.length = 0;
    }

    private void enQueue(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            front = newNode;
        }
        else{
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    private int deQueue(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int result = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        length--;
        return result;
    }

    private void print(){
        if(isEmpty()){
            return;
        }
        ListNode current = front;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        Queue queue = new Queue();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.print();
        System.out.println();
        queue.deQueue();
        queue.deQueue();
        queue.print();

    }
}
