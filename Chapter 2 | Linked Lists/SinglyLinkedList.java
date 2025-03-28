public class SinglyLinkedList {
    private ListNode head;

    // Singly Linked List Node 
    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }

    }

    // Display the SinglyLinkedList
    private void display(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null"+ "\n");
    }

    // Length of the SinglyLinkedList
    private int length(ListNode head){
        if(head == null){
            return 0;
        }
        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    // insert a new node at the beginning of the SinglyLinkedList
    private ListNode insertFirst(ListNode head, int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
        return head;
    }

    // insert a new node at the end of the SinglyLinkedList
    private ListNode insertLast(ListNode head, int value){
        ListNode newNode = new ListNode(value);
        
        if (head == null){
            head = newNode;
            return head;
        }

        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }

        current.next = newNode;

        return head;
    }

    // insert a node at a given position
    private ListNode insertAt(ListNode head, int value, int location){
        ListNode newNode = new ListNode(value);
        
         if(location ==1){
            newNode.next = head;
         }
         else{
            ListNode current = head;
            int count = 1;
            while(count < location -1){
                current = current.next;
                count++;
            }
            ListNode ahead = current.next;
            current.next = newNode;
            newNode.next = ahead; 
         }
         return head;
    }

    // delete first node of a SinglyLinkedList
    private ListNode deleteFirst(ListNode head){
        if (head == null){
            return head;
        }
        head = head.next;
        return head;
    }

    // delete last node of a SinglyLinkedList
    private ListNode deleteLast(ListNode head){
        if (head == null){
            return head;
        }
        ListNode current = head; 
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
        return head;
    }

    // delete a node at a given position
    private ListNode deleteAt(ListNode head, int location){

        if(head == null || location < 1){
            return head;
        }
        if(location ==1) head = head.next;
        else{
            ListNode current = head;
            while(location -1 > 1){
                current = current.next;
                location--;
            }
            current.next = current.next.next;
        }
        return head;
    }

    // check an element in the SinglyLinkedList
    private boolean contains(ListNode head, int value){
        ListNode current = head; 
        while(current != null){
            if(current.data == value){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private ListNode reverse(ListNode head){
    
        ListNode curr = head;
        ListNode prev = null;
        ListNode ahead = null;
        while(curr != null){
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }

    // find nth node from the end of a Singly Linked List
    private ListNode nThNode(ListNode head, int n){
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while(count < n){
            if(refPtr == null){
                throw new IllegalArgumentException(n + "is greater than the length of the linkedlist");
            }
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    // remove duplicate from sorted Singly Linked List
    private ListNode removeDubs(ListNode head){
        
        if (head == null || head.next == null){
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null){
            if(curr.data != prev.data){
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null; // Ensure the last node is handled properly
        return head;
    }

    // inset a node in sorted linked list
    private ListNode insertInSortedList(ListNode head, int value){
        ListNode valuetoInsert = new ListNode(value);
        if(head == null){
            return valuetoInsert;
        }
        ListNode curr = head;
        ListNode temp = null;

        while(curr != null && curr.data < valuetoInsert.data){
            temp = curr;
            curr = curr.next;
        }
        temp.next = valuetoInsert;
        valuetoInsert.next = curr;
        return head;
    }

    // remove a key from singly linked list
    private ListNode removeKey(ListNode head, int key){
      
        if(head.data == key){
            return head.next;
        }

        ListNode curr = head;
        ListNode temp = null;
        while(curr != null){
            if(curr.data == key){
                temp.next = curr.next;
                return head;
            }
            temp = curr;
            curr= curr.next;
        }
        return head;

    }

    // detect a loop in a linked list
    private boolean detectLoop(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                return true;
            }
        }
        return false;
    }

    // find the start of a loop in singly linked list (floyd's cycle detection algorithm)
    private ListNode detectLoopStart(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                return getStartPoint(head, slowPtr);
            }
        }
        return null;
    }

    private ListNode getStartPoint(ListNode head, ListNode slowPtr){
        ListNode temp = head;
        while(temp != slowPtr){// add .next to remove loop
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp; // return null to remove the loop;
    }

    // merge two sorted linked list
    private ListNode mergeTwoLists(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(a != null && b != null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }
            else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a == null && b != null){
            tail.next = b;
        } else if(b == null && a != null){
            tail.next = a;
        }
        return dummy.next;
    }

    public static void main(String[] args){

        System.out.println();
        SinglyLinkedList s = new SinglyLinkedList();
        s.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(7);
        ListNode fourth = new ListNode(8);

        s.head.next = second;
        second.next = third;
        third.next = fourth; 
        System.out.print("LinkedList: ");
        s.display(s.head);
        System.out.println("Length of the given LinkedList: " + s.length(s.head) + "\n");

        // insert a new node at the beginning of the SinglyLinkedList
        System.out.println("insert a new node at the beginning.");
        s.head = s.insertFirst(s.head, 8);
        System.out.print("LinkedList: ");
        s.display(s.head);
        System.out.println("Length of the given LinkedList: " + s.length(s.head) + "\n");

        // insert a new node at the end of the SinglyLinkedList
        System.out.println("insert a new node at the end.");
        s.head = s.insertLast(s.head, 9);
        System.out.print("LinkedList: ");
        s.display(s.head);
        System.out.println("Length of the given LinkedList: " + s.length(s.head) + "\n");
        
        // insert a node at a given position
        System.out.println("insert a node at a given position.");
        s.head = s.insertAt(s.head, 3, 5);
        System.out.print("LinkedList: ");
        s.display(s.head);
        System.out.println("Length of the given LinkedList: " + s.length(s.head) + "\n");

        // delete first node of a SinglyLinkedList
        System.out.println("delete first node of a SinglyLinkedList");
        s.head = s.deleteFirst(s.head);
        System.out.print("LinkedList: ");
        s.display(s.head);
        System.out.println("Length of the given LinkedList: " + s.length(s.head) + "\n");

        // delete last node of a SinglyLinkedList
        System.out.println("delete last node of a SinglyLinkedList");
        s.head = s.deleteLast(s.head);
        System.out.print("LinkedList: ");
        s.display(s.head);
        System.out.println("Length of the given LinkedList: " + s.length(s.head) + "\n");

        // delete a node at a given position
        System.out.println("delete a node at a given position");
        s.head = s.deleteAt(s.head, 2);
        System.out.print("LinkedList: ");
        s.display(s.head);
        System.out.println("Length of the given LinkedList: " + s.length(s.head) + "\n");

        // check an element in the SinglyLinkedList
        System.out.println("check an element in the SinglyLinkedList");
        System.out.print("LinkedList: ");
        s.display(s.head);
        System.out.println("Element present in the SinglyLinkedList: " + s.contains(s.head, 0)+ "\n");

        //reverse a SinglyLinkedList
        System.out.println("reverse a SinglyLinkedList");
        s.head = s.reverse(s.head);
        System.out.print("LinkedList: ");
        s.display(s.head);
        System.out.println("Length of the given LinkedList: " + s.length(s.head) + "\n");

        // find nth node from the end of a Singly Linked List
        System.out.println("find nth node from the end of a Singly Linked List");
        ListNode node = s.nThNode(s.head , 2);
        System.out.print("LinkedList: ");
        s.display(s.head);
        System.out.println("node data : " + node.data + "\n");

        // remove duplicate from sorted Singy Linked List
        ListNode sorted = new ListNode(1);
        sorted.next = new ListNode(1);
        sorted.next.next = new ListNode(2);
        sorted.next.next.next = new ListNode(3);
        sorted.next.next.next.next = new ListNode(3);
        sorted.next.next.next.next.next = new ListNode(4);

        // remove duplicate from sorted Singy Linked List
        System.out.println("remove duplicate from sorted Singy Linked List");
        sorted = s.removeDubs(sorted);
        System.out.print("LinkedList: ");
        s.display(sorted);
        System.out.println("Length of the given LinkedList: " + s.length(sorted) + "\n");

        // inset a node in sorted linked list
        System.out.println("inset a node in sorted linked list");
        sorted = s.insertInSortedList(sorted, 5);
        System.out.print("LinkedList: ");
        s.display(sorted);
        System.out.println("Length of the given LinkedList: " + s.length(sorted) + "\n");

        // remove a key from singly linked list
        System.out.println("remove a key from singly linked list");
        sorted = s.removeKey(sorted, 9);
        System.out.print("LinkedList: ");
        s.display(sorted);
        System.out.println("Length of the given LinkedList: " + s.length(sorted) + "\n");

        // detect a loop in a linked list
        System.out.println("detect a loop in a linked list");
        ListNode loop = new ListNode(1);
        loop.next = new ListNode(2);
        loop.next.next = new ListNode(3);
        loop.next.next.next = new ListNode(4);
        loop.next.next.next.next = loop.next;

        System.out.println("Loop present in the linked list: " + s.detectLoop(loop) + "\n");    

        // find the start of a loop in singly linked list
        System.out.println("find the start of a loop in singly linked list");
        System.out.println("Loop present in the linked list: " + s.detectLoopStart(loop).data + "\n");

        // merge two sorted linked list
        ListNode sorted1 = new ListNode(1);
        sorted1.next = new ListNode(2);     
        sorted1.next.next = new ListNode(4);
        sorted1.next.next.next = new ListNode(6);
        System.out.print("LinkedList1: ");
        s.display(sorted1);

        // merge two sorted linked list
        ListNode sorted2 = new ListNode(0);
        sorted2.next = new ListNode(3);
        sorted2.next.next = new ListNode(5);
        sorted2.next.next.next = new ListNode(7);
        System.out.print("LinkedList2: ");
        s.display(sorted2);
        ListNode merged = s.mergeTwoLists(sorted1, sorted2);
        System.out.print("Merged LinkedList: ");
        s.display(merged);
    }
}
