import java.util.Scanner;

class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data1){
            data = data1;
            next = null;
        }
    }

    // Insert at head (user-defined)
    void push(int new_data) {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    // Delete alternate nodes
    void deleteAlt() {
        if (head == null) return;

        Node node = head;

        while (node != null && node.next != null) {
            node.next = node.next.next;  // skip next node
            node = node.next;            // move to next alternate
        }
    }

    // Display Linked List
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // MAIN METHOD - USER INPUT VERSION
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " values:");

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ll.push(val);    // insert at head
        }

        System.out.println("\nLinked List before deletion:");
        ll.printList();

        ll.deleteAlt();

        System.out.println("Linked List after deleting alternate nodes:");
        ll.printList();

        sc.close();
    }
}
