class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Time Complexity: O(1)
    public void insertAtHead(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Time Complexity: O(n)
    public void insertAtTail(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        // Traverse to the end of the list
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Time Complexity: O(n)
    public void deleteByValue(int value) {
        // Case 1: List is empty
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Case 2: Head holds the value to be deleted
        if (head.data == value) {
            head = head.next;
            return;
        }

        // Case 3: Search for the value in the rest of the list
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        // Check if value was found
        if (temp.next == null) {
            System.out.println("Value not found.");
        } else {
            // Unlink the node
            temp.next = temp.next.next;
        }
    }

    public void traverse() {
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class QUESTION2 {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Inserting elements
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10);
        list.insertAtTail(40);
        list.insertAtTail(50);

        // Print initial list
        list.traverse();

        // Deleting a value
        System.out.println("Deleting value 30...");
        list.deleteByValue(30);

        // Print updated list
        list.traverse();
    }
}