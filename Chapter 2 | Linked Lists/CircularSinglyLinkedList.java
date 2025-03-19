import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data = data;
        }
    }

    public CircularSinglyLinkedList(){
        last = null;
        length = 0;
    }

    private int length(){
        return length;
    }

    private boolean isEmpty(){
        return length == 0;
    }

    // initialize a circular singly linked list
    private void createCircularSinglyLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = first;

        last = sixth;
        length = 6;
    }

    //traverse and print a Circular Singly Linked List
    private void display(){
        if(last == null){
            return;
        }
        ListNode first = last.next;
        while(first!=last){
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.println(first.data);

    }

    //node at the start of a Circular Singly Linked List
    private void insertFirst(int data){
        ListNode temp = new ListNode(data);

        if(last == null){
            last = temp;
            
        }
        else{
            temp.next = last.next;
        }
        last.next = temp;
        length ++;
    }
    
    // insert node at the end of a Circular Singly Linked List
    private void insertLast(int data){
        ListNode temp = new ListNode(data);
        if(last == null){
            last = temp;
            last.next = last;
        }
        else{
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length ++;
    }

    // remove first node from a Circular Singly Linked List
    private void removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Circular Singly Linked List is empty");
        }
        ListNode temp = last.next;
        if(last.next == last){
            last = null;
        }
        else{
            last.next = temp.next;
        }
        temp.next = null;
        length--;
    }

    public static void main(String[] args){
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCircularSinglyLinkedList();
        csll.display();

        csll.insertFirst(0);
        csll.display();
        System.out.println(csll.length());

        csll.insertLast(7);
        csll.display();
        System.out.println(csll.length());

        csll.removeFirst();
        csll.display();
        System.out.println(csll.length());

    }
}