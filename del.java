import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    Node(int data1) {
        data = data1;
        next = null;
    }
}

class Solution {
    public Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;  // empty list or 1 node list
        }

        Node curr = head;

        // Move to the second last node
        while (curr.next.next != null) {
            curr = curr.next;
        }

        curr.next = null;  // delete last node
        return head;
    }
}

public class del {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node head = null;
        Node tail = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        // Build linked list using user input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            int val = sc.nextInt();
            Node newNode = new Node(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;  // insert at tail
                tail = newNode;
            }
        }

        Solution sol = new Solution();
        head = sol.deleteTail(head);

        // Print final list
        System.out.println("\nLinked List after deleting tail:");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        sc.close();
    }
}
