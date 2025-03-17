import java.util.NoSuchElementException;

public class DoublyLinkedList {
    
    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode {
        int data;
        ListNode next;
        ListNode prev;
        
        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    // insert a node at the beginning of the list
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail = newNode;
        }else{
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    // insert a node at last of the list
    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    public void displayForward(){
        if (head == null){
            return ;
        }
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.data + "-->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        if (tail == null ){
            return;
        }
        ListNode curr = tail;
        while(curr != null){
            System.out.print(curr.data + "-->");
            curr = curr.prev;
        }
        System.out.println("null");
    }

    // delete first node
    public void deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if(head == tail){
            tail = null;
        }
        else{
            head.next.prev = null;
        }
        head = head.next;
        temp.next = null;
        length--;
    } 
    
    // delete last node
    public void deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if(head == tail){
            head = null;
        }
        else{
            tail.prev.next = null;
        }
        tail = tail.prev;
        temp.prev = null;
        length--;
    } 

    public static void main(){
        DoublyLinkedList dll = new DoublyLinkedList();  
        dll.insertFirst(1); //insert at the beginning
        dll.insertFirst(68);
        dll.insertFirst(89);
        dll.insertFirst(23);
        dll.insertLast(2); //insert at the end

        dll.displayForward();
        dll.displayBackward();
        //print elements of a Doubly Linked List

        // delete first node
        dll.deleteFirst();
        dll.displayForward();
        dll.displayBackward();

        // delete last node
        dll.deleteLast();
        dll.displayForward();
        dll.displayBackward();
    }
}
